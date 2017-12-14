package org.example.kotlinjstest.testlib

/**
 * A descriptor for an actual test case.
 */
data class TestCase(
    val displayName: String,
    val test: () -> Unit
)