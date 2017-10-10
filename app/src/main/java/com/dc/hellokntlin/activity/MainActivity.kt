package com.dc.hellokntlin.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import butterknife.BindView
import butterknife.ButterKnife
import com.dc.hellokntlin.R
import com.dc.hellokntlin.util.ToastUtil
import com.dc.hellokntlin.util.Tool.initBindView

/**
 * Pos机首页页面
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    @BindView(R.id.activity_main_btn_sign)
    private val activity_main_btn_sign: Button? = null

    @BindView(R.id.activity_main_btn_uninstall)
    private val activity_main_btn_uninstall: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        initBindView(this)

        initListener()
    }

    /*监听初始化绑定*/
    private fun initListener() {
        activity_main_btn_uninstall!!.setOnClickListener(this)
        activity_main_btn_sign!!.setOnClickListener(this)
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.activity_main_btn_sign -> {
                startActivity(SignActivity::class.java)/*跳转至签到页*/
                finish()
            }
            R.id.activity_main_btn_uninstall/*禁止卸载应用授权*/ ->
                /*此功能模块目的不明确,Toast*/
                ToastUtil.show(this@MainActivity, "此设备已经激活,请勿重复激活")
        }
    }


    /*意图跳转*/
    fun startActivity(activityClass: Class<out Activity>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }

}
