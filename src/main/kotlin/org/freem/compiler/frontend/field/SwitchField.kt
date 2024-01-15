package org.freem.compiler.frontend.field

sealed interface CaseField<ReturnsType> {
    val case: CaseObject<ReturnsType>
}

internal class CaseFieldImpl<ReturnsType>: CaseField<ReturnsType> {
    override val case: CaseObject<ReturnsType> = CaseObjectImpl()
}