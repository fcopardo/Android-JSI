package com.ursusarctos.db

class JNIDatamanager {

    companion object {
        private var instance : JNIDatamanager? = null

        init {
            System.loadLibrary("TurboDatabase")
            instance = JNIDatamanager()
        }

        @JvmStatic
        fun getData() : String {
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
