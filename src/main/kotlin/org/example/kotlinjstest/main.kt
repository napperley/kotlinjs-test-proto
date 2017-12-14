package org.example.kotlinjstest

import org.example.kotlinjstest.testlib.FunSpec
import org.example.kotlinjstest.testlib.SpecRunner
import org.example.kotlinjstest.testlib.equalTo

fun main(args: Array<String>) {
    println("Doing testing...")
    runTests()
}

fun runTests() {
    val spec = object : FunSpec("Function") {
        init {
            test("foo returns correct result") {
                foo() equalTo 7
            }
        }
    }

    SpecRunner.runSpecs(spec)
}

fun foo() = 10