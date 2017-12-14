package org.example.kotlinjstest.testlib

/**
 * Handles the execution of Specs.
 */
object SpecRunner {
    private var passedTestCases = 0
    private var failedTestCases = 0

    /**
     * Executes all [specs] and prints the test results.
     * @param specs The specs that will be executed by [SpecRunner].
     */
    fun runSpecs(vararg specs: Spec) {
        passedTestCases = 0
        failedTestCases = 0
        specs.forEach { s ->
            println("Running tests in ${s.name} Spec")
            s.testCases.forEach { tc ->
                executeTestCase(testCase = tc, before = s.beforeTestCase(), after = s.afterTestCase())
            }
        }
        printTestResults()
    }

    private fun executeTestCase(testCase: TestCase, before: () -> Unit, after: () -> Unit) {
        before()
        try {
            println("Test: ${testCase.displayName}...")
            testCase.test()
            passedTestCases++
        } catch (ae: AssertionFailedException) {
            println("Assertion (${ae.type}) Failed: ${ae.msg}")
            failedTestCases++
        }
        after()
    }

    private fun printTestResults() {
        println("-- Results --")
        println("Total Tests: ${passedTestCases + failedTestCases}")
        when {
            passedTestCases == 0 -> println("ALL TESTS FAILED!")
            failedTestCases == 0 -> println("ALL TESTS PASSED!")
            else -> {
                println("Passed Tests: $passedTestCases")
                println("Failed Tests: $failedTestCases")
                println("Some tests failed!")
            }
        }
    }
}