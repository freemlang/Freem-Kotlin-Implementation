package org.freem.compiler.frontend.interfaces.field

interface CaseObject<ReturnsType> {
    infix fun returns(value: ReturnsType): AddObject
}
