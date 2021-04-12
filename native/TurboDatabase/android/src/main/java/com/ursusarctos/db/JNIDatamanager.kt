package com.ursusarctos.db

import android.content.Context
import java.io.BufferedReader
import java.io.File
import java.text.DateFormat
import java.util.Date

class JNIDatamanager {

    companion object {
        private var instance : JNIDatamanager? = null
        private var context : Context? = null

        init {
            System.loadLibrary("TurboDatabase")
            instance = JNIDatamanager()
        }

        @JvmStatic
        fun getData() : String {
            android.util.Log.e("com.testdb", "reading starts "+DateFormat.getDateTimeInstance().format(Date()))
            context?.let {
                //val reader = context?.assets?.open("HP6.txt")?.bufferedReader()
                var contextNull : Boolean = context!=null
                android.util.Log.e("com.testdb", "context is "+contextNull)
                //var file = File(context?.filesDir, "HP6.txt")
                val reader = context?.assets?.open("HP6.txt")?.bufferedReader()
                //val reader = file.bufferedReader()

                //var assetsNull : Boolean = context?.assets!=null
                //android.util.Log.e("com.testdb", "assets is "+assetsNull)

                //var readerNull : Boolean = context?.assets?.open("HP6.txt")!=null
                //android.util.Log.e("com.testdb", "reader is "+readerNull)

                    var result = ""
                    val content = StringBuilder()
                    try {
                        var line = reader?.readLine()
                        while (line != null) {
                            content.append(line)
                            line = reader?.readLine()
                        }
                    } finally {
                        reader?.close()
                    }
                    result = content.toString()

                    if(!result.isNullOrBlank()){
                        android.util.Log.e("com.testdb", "result is "+result)
                        instance?.data = result
                    }else{
                        android.util.Log.e("com.testdb", "result is empty ")
                    }

                //instance?.data = context?.assets?.open("HP6.txt")?.bufferedReader().use(BufferedReader::readText)
            }
            android.util.Log.e("com.testdb", "reading finished "+DateFormat.getDateTimeInstance().format(Date()))
            return if(instance != null && instance?.data!=null){
                instance!!.data
            }else{
                "there is no data"
            }
        }

        @JvmStatic
        fun setData(data : String){
            instance?.data = data
        }

        @JvmStatic
        fun setContext(context : Context?){
            this.context = context
        }

        @JvmStatic
        fun getContext() : Context?{
            return context
        }
    }

    external fun installBinding(javaScriptContextHolder: Long)
    private var data: String = "Sync Data from JVM"
}
