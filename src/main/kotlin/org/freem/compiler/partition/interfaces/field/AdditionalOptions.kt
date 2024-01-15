package org.freem.compiler.partition.interfaces.field

interface AdditionalOptions {
    infix fun optional(optional: Boolean): AdditionalOptions
    infix fun repeat(range: IntRange): AdditionalOptions
    infix fun repeatMin(min: Int): AdditionalOptions
    infix fun repeatMax(max: Int): AdditionalOptions
    infix fun multiply(amount: Int): AdditionalOptions
}

