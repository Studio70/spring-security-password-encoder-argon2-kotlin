[ru.assadi.springframework.security.crypto.argon2](../index.md) / [Argon2PasswordEncoder](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`Argon2PasswordEncoder(type: Argon2Types = Argon2Factory.Argon2Types.ARGON2id, saltLength: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = DEFAULT_SALT_LENGTH, hashLength: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = DEFAULT_HASH_LENGTH)`

Copyright (c) 2017 [Omar Saleh Assadi](https//assadi.ru/).
Licensed under the [LGPL v3](https//www.gnu.org/licenses/lgpl-3.0.txt).

This is [PasswordEncoder](#) implementation that uses the Argon2 hashing functions.
It is capable of hashing and verifying all three Argon2 variants.

This uses [Moritz Kammerer's Argon2 library](https//github.com/phxql/argon2-jvm)—which binds against the native
Argon2 libraries using JNA. What this means, however, is that by default, this will only run on x86 and x86_64 based
machines as Mortiz' library does not include ARM/Power builds of Argon2.

### Parameters

`type` - The chosen [Argon2 variant](#). Default: [Argon2id](#).

`saltLength` - The length of the generated salt. Minimum of 8. Default: 16.

`hashLength` - The length of the hash that will be generated. Minimum of 4. Default: 32.

**Author**
[Omar Saleh Assadi](https//assadi.ru/) [&lt;&gt;](#)

