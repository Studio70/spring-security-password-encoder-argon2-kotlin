[ru.assadi.springframework.security.crypto.argon2](../index.md) / [Argon2PasswordEncoder](index.md) / [encode](./encode.md)

# encode

`fun encode(rawPassword: `[`CharSequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)`, iterations: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, memory: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, parallelism: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

### Parameters

`rawPassword` - The password that is to be hashed.

`iterations` - The number of iterations to use when hashing said password.

`parallelism` - The number of parallel parallelism.

**Return**
The hashed form of the specified password.

`fun encode(rawPassword: `[`CharSequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

### Parameters

`rawPassword` - The password that is to be hashed.

**Return**
The hashed form of the specified password.

