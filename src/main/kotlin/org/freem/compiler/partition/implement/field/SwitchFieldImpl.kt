package org.freem.compiler.partition.implement.field

import org.freem.compiler.partition.interfaces.field.CaseObject
import org.freem.compiler.partition.interfaces.field.SwitchField

internal class SwitchFieldImpl<ReturnsType>: SwitchField<ReturnsType> {
    override val case: CaseObject<ReturnsType> = CaseObjectImpl()
}