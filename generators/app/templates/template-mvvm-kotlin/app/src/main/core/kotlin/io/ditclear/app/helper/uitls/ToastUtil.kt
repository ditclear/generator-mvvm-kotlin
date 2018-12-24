package <%= appPackage %>.helper.uitls

import android.app.Activity
import android.widget.Toast

/**
 * 页面描述：ToastUtil
 *
 * Created by ditclear on 2018/12/11.
 */
object ToastUtil {
    fun warning(activity: Activity, msg: CharSequence, duration: Int) {
        Toast.makeText(activity, msg, duration).show()
    }

    fun error(activity: Activity, msg: CharSequence, duration: Int) {
        Toast.makeText(activity, msg, duration).show()
    }

    fun info(activity: Activity, msg: CharSequence, duration: Int) {
        Toast.makeText(activity, msg, duration).show()
    }

    fun success(activity: Activity, msg: CharSequence, duration: Int) {
        Toast.makeText(activity, msg, duration).show()
    }

}