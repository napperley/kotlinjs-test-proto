@file:Suppress("unused")

package org.example.kotlinjstest.testlib

infix fun Any.equalTo(expected: Any) {
    if (this != expected) {
        throw AssertionFailedException(type = "EqualTo", expected = this, actual = expected,
            msg = "$this isn't equal to $expected")
    }
}

infix fun Any.notEqualTo(expected: Any) {
    if (this == expected) {
        throw AssertionFailedException(type = "NotEqualTo", expected = this, actual = expected,
            msg = "$this must not be equal to $expected")
    }
}