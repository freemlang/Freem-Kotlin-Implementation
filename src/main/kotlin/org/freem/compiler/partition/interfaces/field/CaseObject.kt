package org.freem.compiler.partition.interfaces.field

interface CaseObject<ReturnsType> {
    infix fun returns(value: ReturnsType): AddObject
}
