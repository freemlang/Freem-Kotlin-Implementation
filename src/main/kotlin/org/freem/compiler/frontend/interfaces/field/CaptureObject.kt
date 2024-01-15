package org.freem.compiler.frontend.interfaces.field

import java.util.concurrent.Future

interface CaptureObject: Future<String> {
    fun fin()
}