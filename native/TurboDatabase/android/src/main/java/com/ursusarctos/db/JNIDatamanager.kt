package com.ursusarctos.db

import android.content.Context

class JNIDatamanager {

    companion object {
        private var instance : JNIDatamanager? = null
        var context = Context? = null

        init {
            System.loadLibrary("TurboDatabase")
            instance = JNIDatamanager()
        }

        @JvmStatic
        fun getData() : String {
            context?.let{
                instance?.data = assets.open("HP6.txt").bufferedReader().use(BufferedReader::readText)
            }
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
    }

    external fun installBinding(javaScriptContextHolder: Long)
    private var data: String = "Sync Data from JVM"
}
