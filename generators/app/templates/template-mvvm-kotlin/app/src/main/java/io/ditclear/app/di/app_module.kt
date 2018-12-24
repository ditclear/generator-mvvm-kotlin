package <%= appPackage %>.di
import org.koin.dsl.module.module

val viewModelModule = module {



}

val appModule = listOf(viewModelModule)