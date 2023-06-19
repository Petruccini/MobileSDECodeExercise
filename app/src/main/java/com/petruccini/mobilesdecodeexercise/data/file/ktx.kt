package com.petruccini.mobilesdecodeexercise.data.file

import android.content.res.Resources
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import java.io.StringWriter
import java.io.Writer

fun Resources.getJsonStringFromFile(rawFile: Int): String {

    val inputStream: InputStream = this.openRawResource(rawFile)
    val writer: Writer = StringWriter()
    val buffer = CharArray(inputStream.available())
    inputStream.use { stream ->
        val reader: Reader = BufferedReader(InputStreamReader(stream, "UTF-8"))
        var len: Int
        while (reader.read(buffer).also { len = it } != -1) {
            writer.write(buffer, 0, len)
        }
    }
    return writer.toString()
}