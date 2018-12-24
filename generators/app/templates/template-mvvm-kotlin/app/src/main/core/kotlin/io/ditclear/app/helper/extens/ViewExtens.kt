package <%= appPackage %>.helper.extens

import android.app.Activity
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Toast
import <%= appPackage %>.BuildConfig
import <%= appPackage %>.helper.Constants
import <%= appPackage %>.helper.uitls.ToastUtil
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


/**
 * description：some extens
 *
 * Created by ditclear on 2017/9/29.
 */

fun Activity.getCompactColor(@ColorRes colorRes: Int): Int = ContextCompat.getColor(this, colorRes)

fun Activity.dpToPx(@DimenRes resID: Int): Int = this.resources.getDimensionPixelOffset(resID)

fun Any.logD(msg: String?) {
    if (BuildConfig.DEBUG) {
        Log.d(javaClass.simpleName, msg)
    }
}

fun Activity.toast(msg: CharSequence, duration: Int = Toast.LENGTH_SHORT, type: Int = Constants.NORMAL) {
    when (type) {
        Constants.WARNING -> ToastUtil.warning(this, msg, duration)
        Constants.ERROR -> ToastUtil.error(this, msg, duration)
        Constants.NORMAL -> ToastUtil.info(this, msg, duration)
        Constants.SUCCESS -> ToastUtil.success(this, msg, duration)
    }
}


fun Activity.dispatchFailure(error: Throwable?) {
    error?.let {
        if (BuildConfig.DEBUG) {
            it.printStackTrace()
        }
        if (error is SocketTimeoutException) {
            it.message?.let { toast("网络连接超时", Constants.ERROR) }

        } else if (it is UnknownHostException || it is ConnectException) {
            //网络未连接
            it.message?.let { toast("网络未连接", Constants.ERROR) }

        } else {
            it.message?.let { toast(it, Constants.ERROR) }
        }
    }
}
