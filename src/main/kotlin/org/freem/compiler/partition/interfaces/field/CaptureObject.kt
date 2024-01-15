package org.freem.compiler.partition.interfaces.field

import java.util.concurrent.Future

interface CaptureObject: Future<String> {
    fun fin()
}