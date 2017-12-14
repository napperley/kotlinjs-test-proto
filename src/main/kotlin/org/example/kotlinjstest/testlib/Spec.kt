package org.example.kotlinjstest.testlib

interface Spec {
    val name: String
    val testCases: MutableList<TestCase>

    fun beforeTestCase() = {}

    fun afterTestCase() = {}
}