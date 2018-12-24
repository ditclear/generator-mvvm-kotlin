package <%= appPackage %>

import android.app.Application

/**
 * 页面描述：CoreService spi 加载
 *
 * Created by ditclear on 2018/11/28.
 */
interface CoreService{

    val serviceName:String

    fun init(app:Application)

}