package ru.assadi.springframework.security.crypto.argon2

import de.mkammerer.argon2.Argon2Constants.DEFAULT_HASH_LENGTH
import de.mkammerer.argon2.Argon2Constants.DEFAULT_SALT_LENGTH
import de.mkammerer.argon2.Argon2Factory
import org.springframework.security.crypto.password.PasswordEncoder

/**
 * Copyright (c) 2017 [Omar Saleh Assadi][https://assadi.ru/].
 * Licensed under the [LGPL v3][https://www.gnu.org/licenses/lgpl-3.0.txt].
 *
 * This is [PasswordEncoder] implementation that uses the Argon2 hashing functions.
 * It is capable of hashing and verifying all three Argon2 variants.
 *
 * This uses [Moritz Kammerer's Argon2 library](https://github.com/phxql/argon2-jvm)—which wraps around the native
 * Argon2 libraries using JNA. What this means, however, is that by default, this will only run on x86 and x86_64 based
 * machines as Mortiz' library does not include ARM/Power builds of Argon2.
 *
 * @param type The chosen [Argon2 variant][Argon2Factory.Argon2Types]. Default: [Argon2id][Argon2Factory.Argon2Types.ARGON2id].
 * @param saltLength The length of the generated salt. Minimum of 8. Default: 16.
 * @param hashLength The length of the hash that will be generated. Minimum of 4. Default: 32.
 *
 * @author [Omar Saleh Assadi][https://assadi.ru/] [<omar@assadi.co.il>][mailto:omar@assadi.co.il]
 */
class Argon2PasswordEncoder(
    type: Argon2Factory.Argon2Types = Argon2Factory.Argon2Types.ARGON2id,
    saltLength: Int = DEFAULT_SALT_LENGTH,
    hashLength: Int = DEFAULT_HASH_LENGTH
) : PasswordEncoder {

    /**
     * This ensures that the parameters the constructor was invoked with match the required minimum values.
     */
    init {
        require(saltLength >= MINIMUM_SALT_LENGTH) { "Salt length must be greater than or equal to: $MINIMUM_SALT_LENGTH. Default: $DEFAULT_SALT_LENGTH" }
        require(hashLength > 0) { "Hash length must be greater than or equal to: $MINIMUM_HASH_LENGTH. Default: $DEFAULT_HASH_LENGTH." }
    }

    /**
     * This contains all [Argon2PasswordEncoder] constants.
     */
    companion object {
        val MINIMUM_SALT_LENGTH = 8
        val MINIMUM_HASH_LENGTH = 4
        val DEFAULT_ITERATIONS = 2
        val DEFAULT_MEMORY = 65536
        val DEFAULT_PARALLELISM = 1
    }

    /**
     * The [Argon2Factory] that will be used in this object instance to verify and hash passwords.
     */
    private val argon2 = Argon2Factory.create(type, saltLength, hashLength)

    /**
     * @param rawPassword The password that is to be hashed.
     * @param iterations The number of iterations to use when hashing said password.
     * @param parallelism The number of parallel parallelism.
     *
     * @return The hashed form of the specified password.
     */
    fun encode(rawPassword: CharSequence, iterations: Int, memory: Int, parallelism: Int): String = argon2.hash(iterations, memory,
        parallelism, rawPassword.toString())

    /**
     * @param rawPassword The password that is to be hashed.
     *
     * @return The hashed form of the specified password.
     */
    override fun encode(rawPassword: CharSequence): String = argon2.hash(DEFAULT_ITERATIONS, DEFAULT_MEMORY, DEFAULT_PARALLELISM,
        rawPassword.toString())

    /**
     * @param rawPassword The password that is to be verified against the string.
     * @param encodedPassword The hash that is to be verified.
     *
     * @return `false` if the password does not match the hash. Otherwise, `true`.
     */
    override fun matches(rawPassword: CharSequence, encodedPassword: String): Boolean = argon2.verify(encodedPassword, rawPassword.toString())
}
