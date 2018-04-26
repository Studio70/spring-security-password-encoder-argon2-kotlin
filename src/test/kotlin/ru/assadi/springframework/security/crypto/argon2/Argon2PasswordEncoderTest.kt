package ru.assadi.springframework.security.crypto.argon2

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Copyright (c) 2017 [Omar Saleh Assadi][https://assadi.ru/].
 * Licensed under the [LGPL v3][https://www.gnu.org/licenses/lgpl-3.0.txt].
 *
 * A basic test set for the [Argon2PasswordEncoder].
 * This could use more test cases. But, it'll do for now.
 *
 * @author [Omar Saleh Assadi][https://assadi.ru/] [<omar@assadi.co.il>][mailto:omar@assadi.co.il]
 */
object Argon2PasswordEncoderTest : Spek({
    given("an Argon2 password encoder") {
        val argon2 = Argon2PasswordEncoder()

        given("an ASCII password") {
            val password = "test pass"

            on("encode") {
                val hashedPassword = argon2.encode(password)

                it("it should return true when verified against the original password") {
                    assertTrue(argon2.matches(password, hashedPassword))
                }

                given("the wrong ASCII password") {
                    val wrongPassword = "wrong pass"

                    it("should return false when verified against the original hash") {
                        assertFalse(argon2.matches(wrongPassword, hashedPassword))
                    }
                }
            }
        }

        given("a cyrillic password") {
            val password = "тест пароль"

            on("encode") {
                val hashedPassword = argon2.encode(password)

                it("it should return true when verified against the original password") {
                    assertTrue(argon2.matches(password, hashedPassword))
                }

                given("the wrong cyrillic password") {
                    val wrongPassword = "неправильный пароль"

                    it("should return false when verified against the original hash") {
                        assertFalse(argon2.matches(wrongPassword, hashedPassword))
                    }
                }
            }
        }

        given("an emoji password") {
            val password = "🔬🔑"

            on("encode") {
                val hashedPassword = argon2.encode(password)

                it("it should return true when verified against the original password") {
                    assertTrue(argon2.matches(password, hashedPassword))
                }

                given("the wrong emoji password") {
                    val wrongPassword = "❌🔑"

                    it("should return false when verified against the original hash") {
                        assertFalse(argon2.matches(wrongPassword, hashedPassword))
                    }
                }
            }
        }
    }
})
