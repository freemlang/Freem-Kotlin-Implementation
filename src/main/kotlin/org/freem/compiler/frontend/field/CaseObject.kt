package org.freem.compiler.frontend.field

sealed interface CaseObject<ReturnsType> {
    infix fun returns(value: ReturnsType): AddObject
}

internal class CaseObjectImpl<ReturnsType>: CaseObject<ReturnsType> {
    override fun returns(value: ReturnsType): AddObject {
        TODO("Not yet implemented")
    }
}