package <%= appPackage %>

import android.app.Application
import <%= appPackage %>.di.appModule
import org.koin.android.ext.android.startKoin
import org.koin.android.logger.AndroidLogger

/**
 * 页面描述：App
 *
 * Created by ditclear on 2018/12/11.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, appModule, logger = AndroidLogger(showDebug = BuildConfig.DEBUG))
    }
}