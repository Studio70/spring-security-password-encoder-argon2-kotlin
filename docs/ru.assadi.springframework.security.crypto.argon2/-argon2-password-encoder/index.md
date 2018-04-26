[ru.assadi.springframework.security.crypto.argon2](../index.md) / [Argon2PasswordEncoder](./index.md)

# Argon2PasswordEncoder

`class Argon2PasswordEncoder : PasswordEncoder`

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

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Argon2PasswordEncoder(type: Argon2Types = Argon2Factory.Argon2Types.ARGON2id, saltLength: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = DEFAULT_SALT_LENGTH, hashLength: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = DEFAULT_HASH_LENGTH)`<br>Copyright (c) 2017 [Omar Saleh Assadi](https//assadi.ru/). Licensed under the [LGPL v3](https//www.gnu.org/licenses/lgpl-3.0.txt). |

### Functions

| Name | Summary |
|---|---|
| [encode](encode.md) | `fun encode(rawPassword: `[`CharSequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)`, iterations: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, memory: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, parallelism: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>`fun encode(rawPassword: `[`CharSequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [matches](matches.md) | `fun matches(rawPassword: `[`CharSequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)`, encodedPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [DEFAULT_ITERATIONS](-d-e-f-a-u-l-t_-i-t-e-r-a-t-i-o-n-s.md) | `val DEFAULT_ITERATIONS: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [DEFAULT_MEMORY](-d-e-f-a-u-l-t_-m-e-m-o-r-y.md) | `val DEFAULT_MEMORY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [DEFAULT_PARALLELISM](-d-e-f-a-u-l-t_-p-a-r-a-l-l-e-l-i-s-m.md) | `val DEFAULT_PARALLELISM: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [MINIMUM_HASH_LENGTH](-m-i-n-i-m-u-m_-h-a-s-h_-l-e-n-g-t-h.md) | `val MINIMUM_HASH_LENGTH: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [MINIMUM_SALT_LENGTH](-m-i-n-i-m-u-m_-s-a-l-t_-l-e-n-g-t-h.md) | `val MINIMUM_SALT_LENGTH: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
