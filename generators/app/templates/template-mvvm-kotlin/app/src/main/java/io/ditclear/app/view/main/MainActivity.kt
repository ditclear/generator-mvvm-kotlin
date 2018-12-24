package <%= appPackage %>.view.main

import android.view.View
import <%= appPackage %>.R
import <%= appPackage %>.aop.annotation.SingleClick
import <%= appPackage %>.databinding.MainActivityBinding
import <%= appPackage %>.view.base.BaseActivity
import <%= appPackage %>.view.main.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainActivityBinding>() {


    private val mViewModel by viewModel<MainViewModel>()

    override fun loadData(isRefresh: Boolean) {

    }
    override fun initView() {
        mBinding.vm = mViewModel
    }

    override fun getLayoutId(): Int = R.layout.main_activity


    @SingleClick
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.test_tv -> testView()
        }
    }

    private fun testView() {
        mViewModel.testView()
    }
}
