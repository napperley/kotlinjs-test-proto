package org.example.kotlinjstest.testlib

/**
 * Base class for doing unit tests.
 */
abstract class FunSpec(override val name: String, body: FunSpec.() -> Unit = {}) : Spec {
    override val testCases: MutableList<TestCase> = mutableListOf()

    init {
        body()
    }

    /**
     * Creates a [test case][TestCase] that will be executed later.
     * @param name Unique name of the test case.
     * @param block Test logic for the test case.
     */
    fun test(name: String, block: () -> Unit) {
        testCases += TestCase(displayName = name, test = block)
    }
}