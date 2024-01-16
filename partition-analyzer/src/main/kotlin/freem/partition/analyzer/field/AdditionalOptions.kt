package freem.partition.analyzer.field

import freem.partition.analyzer.PartitionAnalyzeTask

open class AdditionalOptions internal constructor(private val baseTask: PartitionAnalyzeTask) {
    infix fun optional(optional: Boolean): AdditionalOptions {



        return this
    }

    infix fun repeat(range: IntRange): AdditionalOptions {


        return this
    }

    infix fun repeatMin(min: Int): AdditionalOptions {


        return this
    }

    infix fun repeatMax(max: Int): AdditionalOptions {


        return this
    }

    infix fun multiply(amount: Int): AdditionalOptions {


        return this
    }
}

