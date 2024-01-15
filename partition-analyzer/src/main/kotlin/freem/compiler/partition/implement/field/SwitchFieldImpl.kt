package freem.compiler.partition.implement.field

import freem.compiler.partition.interfaces.field.CaseObject
import freem.compiler.partition.interfaces.field.SwitchField

internal class SwitchFieldImpl<ReturnsType>: SwitchField<ReturnsType> {
    override val case: CaseObject<ReturnsType> = CaseObjectImpl()
}