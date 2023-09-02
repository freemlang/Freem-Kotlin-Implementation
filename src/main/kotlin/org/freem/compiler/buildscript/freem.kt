package org.freem.compiler.buildscript

fun freem(scope: BuilderScope) {

}

sealed interface BuilderArea {
    fun analyzer(scope: AnalyzerScope) {

    }
}

typealias BuilderScope = BuilderArea.() -> Unit

private class Builder: BuilderArea {

}




sealed interface AnalyzerArea {

}

typealias AnalyzerScope = AnalyzerArea.() -> Unit

private class Analyzer: AnalyzerArea {

}