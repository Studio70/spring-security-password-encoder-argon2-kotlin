[ru.assadi.springframework.security.crypto.argon2](../index.md) / [Argon2PasswordEncoder](index.md) / [matches](./matches.md)

# matches

`fun matches(rawPassword: `[`CharSequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)`, encodedPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

### Parameters

`rawPassword` - The password that is to be verified against the string.

`encodedPassword` - The hash that is to be verified.

**Return**
`false` if the password does not match the hash. Otherwise, `true`.

