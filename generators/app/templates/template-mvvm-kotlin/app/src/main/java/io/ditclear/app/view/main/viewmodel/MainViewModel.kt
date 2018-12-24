package <%= appPackage %>.view.main.viewmodel

import android.arch.lifecycle.MutableLiveData
import <%= appPackage %>.helper.extens.get
import <%= appPackage %>.helper.extens.init
import <%= appPackage %>.helper.extens.set
import <%= appPackage %>.helper.extens.toFlowable
import <%= appPackage %>.viewmodel.BaseViewModel

/**
 * 页面描述：MainViewModel
 *
 * Created by ditclear on 2018/12/11.
 */
class MainViewModel constructor():BaseViewModel(){

    val text = MutableLiveData<String>().init("click me ")
    val doubleBindText = MutableLiveData<String>().apply {
        set("")
    }

    init {
        doubleBindText.toFlowable()
            .doOnNext {
                println("MainViewModel------》$it")
            }.subscribe()
    }


    val loading = MutableLiveData<Boolean>().apply { set(false) }

    fun testView() {
        text.set("${text.get() ?: ""}111")
    }
}