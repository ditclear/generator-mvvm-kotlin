package <%= appPackage %>.di
import org.koin.dsl.module.module
import <%= appPackage %>.view.main.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel

val viewModelModule = module {

    viewModel { MainViewModel() }

}

val appModule = listOf(viewModelModule)