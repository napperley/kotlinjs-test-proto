package org.example.kotlinjstest.testlib

data class AssertionFailedException(
    val type: String,
    val expected: Any,
    val actual: Any,
    val msg: String
) : Exception(msg)