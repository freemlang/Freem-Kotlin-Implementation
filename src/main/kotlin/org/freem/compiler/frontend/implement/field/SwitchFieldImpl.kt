package org.freem.compiler.frontend.implement.field

import org.freem.compiler.frontend.interfaces.field.CaseObject
import org.freem.compiler.frontend.interfaces.field.SwitchField

internal class SwitchFieldImpl<ReturnsType>: SwitchField<ReturnsType> {
    override val case: CaseObject<ReturnsType> = CaseObjectImpl()
}