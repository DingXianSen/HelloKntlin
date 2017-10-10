package com.dc.hellokntlin.activity

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.dc.hellokntlin.R
import com.dc.hellokntlin.app.AppApplication
import com.dc.hellokntlin.bean.SignBean
import com.dc.hellokntlin.util.Constant
import com.dc.hellokntlin.util.DesBase64Util
import com.dc.hellokntlin.util.Tool
import com.dc.hellokntlin.util.Tool.disableShowSoftInput
import com.dc.hellokntlin.util.Tool.initBindView
import com.dc.hellokntlin.util.net.NetWorkUrl
import org.json.JSONException
import org.json.JSONObject
import java.util.*


/**
 * Created by dingchao on 2017/8/29.
 */

class SignActivity : Activity(), View.OnClickListener {

    /*类别(签到)*/
    @BindView(R.id.tv_layout_type)
    private val tv_layout_type: TextView? = null

    @BindView(R.id.activity_sign_et_teller)
    private val activity_sign_et_teller: EditText? = null

    @BindView(R.id.activity_sign_et_password)
    private val activity_sign_et_password: EditText? = null

    @BindView(R.id.activity_sign_btn_nowsign)
    private val activity_sign_btn_nowsign: Button? = null

    @BindView(R.id.activity_sign_num_1)
    internal var activity_sign_num_1: Button? = null
    @BindView(R.id.activity_sign_num_2)
    internal var activity_sign_num_2: Button? = null
    @BindView(R.id.activity_sign_num_3)
    internal var activity_sign_num_3: Button? = null
    @BindView(R.id.activity_sign_num_4)
    internal var activity_sign_num_4: Button? = null
    @BindView(R.id.activity_sign_num_5)
    internal var activity_sign_num_5: Button? = null
    @BindView(R.id.activity_sign_num_6)
    internal var activity_sign_num_6: Button? = null
    @BindView(R.id.activity_sign_num_7)
    internal var activity_sign_num_7: Button? = null
    @BindView(R.id.activity_sign_num_8)
    internal var activity_sign_num_8: Button? = null
    @BindView(R.id.activity_sign_num_9)
    internal var activity_sign_num_9: Button? = null
    @BindView(R.id.activity_sign_num_clear)
    internal var activity_sign_num_clear: Button? = null
    @BindView(R.id.activity_sign_num_0)
    internal var activity_sign_num_0: Button? = null
    @BindView(R.id.activity_sign_num_delete)
    internal var activity_sign_num_delete: Button? = null

    internal var app: AppApplication = null!!


    /*Sign的创建*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)
        ButterKnife.bind(this)
        initBindView(this)
        app = AppApplication.getmContext() as AppApplication
        initView()
        initListener()

    }

    /*监听初始*/
    private fun initListener() {
        activity_sign_btn_nowsign!!.setOnClickListener(this)
        activity_sign_num_1!!.setOnClickListener(this)
        activity_sign_num_2!!.setOnClickListener(this)
        activity_sign_num_3!!.setOnClickListener(this)
        activity_sign_num_4!!.setOnClickListener(this)
        activity_sign_num_5!!.setOnClickListener(this)
        activity_sign_num_6!!.setOnClickListener(this)
        activity_sign_num_7!!.setOnClickListener(this)
        activity_sign_num_8!!.setOnClickListener(this)
        activity_sign_num_9!!.setOnClickListener(this)
        activity_sign_num_clear!!.setOnClickListener(this)
        activity_sign_num_0!!.setOnClickListener(this)
        activity_sign_num_delete!!.setOnClickListener(this)
    }

    /*视图初始*/
    private fun initView() {
        tv_layout_type!!.text = "签到"
        disableShowSoftInput(activity_sign_et_teller)
        disableShowSoftInput(activity_sign_et_password)
    }

    /*获取输入框中的数据*/
    private fun getText(et: EditText?): String {
        val context = et!!.text.toString()
        return context
    }

    /*字符追加方法  str为要追加的数字*/
    fun stringAdd(str: String) {
        var con = ""
        if (activity_sign_et_teller!!.hasFocus()) {
            con = getText(activity_sign_et_teller)//获取到柜员号输入的
            if (con.length < 2) {
                con += str
                activity_sign_et_teller.setText(con)
                /* 光标移动到最后输入字符的后边*/
                activity_sign_et_teller.setSelection(con.length)
            }
            //            Toast.makeText(this, "-------+"+activity_sign_et_teller.getText().toString(), Toast.LENGTH_SHORT).show();
        } else {
            con = getText(activity_sign_et_password)
            if (con.length < 6) {
                con += str
                activity_sign_et_password!!.setText(con)
                activity_sign_et_password.setSelection(con.length)
                //                Toast.makeText(this, "-------+"+activity_sign_et_password.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    /*清除方法  那个有焦点清除哪一个，所有字符*/
    fun stringClear() {
        if (activity_sign_et_teller!!.hasFocus()) {
            activity_sign_et_teller.setText("")
        } else if (activity_sign_et_password!!.hasFocus()) {
            activity_sign_et_password.setText("")
        }
    }

    /*删除方法  一个一个字符删除*/
    fun stringDelete() {
        if (activity_sign_et_teller!!.hasFocus()) {
            if (getText(activity_sign_et_teller).length > 0) {
                activity_sign_et_teller.setText(activity_sign_et_teller.text.toString().substring(0, activity_sign_et_teller.text.toString().length - 1)) //sub -1
                activity_sign_et_teller.setSelection(getText(activity_sign_et_teller).length)
            }
        } else if (activity_sign_et_password!!.hasFocus()) {
            if (getText(activity_sign_et_password).length > 0) {
                activity_sign_et_password.setText(activity_sign_et_password.text.toString().substring(0, activity_sign_et_password.text.toString().length - 1)) //sub -1
                activity_sign_et_password.setSelection(getText(activity_sign_et_password).length)
            }
        }
    }

    /*立即签到方法  网络请求判断用户是否存在*/
    internal var dialog2: ProgressDialog

    fun userSign() {
        if (getText(activity_sign_et_teller).length <= 0 || getText(activity_sign_et_password).length <= 0) {
            Toast.makeText(this, "柜员号或密码不能为空", Toast.LENGTH_SHORT).show()
        } else {
            val teller = getText(activity_sign_et_teller)
            val password = getText(activity_sign_et_password)
            // 方式二：使用静态方式创建并显示，这种进度条只能是圆形条,设置title和Message提示内容
            dialog2 = ProgressDialog.show(this, "提示", "正在登录中...")
            /*控制点击屏幕外侧空白区域使dialog消失，必须要在show()方法调用之前*/
            dialog2.setCanceledOnTouchOutside(true)
            dialog2.show()
            /*设置dialog的取消事件*/
            dialog2.setOnCancelListener {
                dialog2.dismiss()
                dialog2.cancel()
            }
            Handler().postDelayed({
                //等待10000毫秒后销毁此页面，并提示登陆成功
                //                    iSignPresenter.login(teller, password);
                login(teller, password)
                //                    dialog2.dismiss();
            }, 1500)

        }
        /*startActivity(ConsumptionActivity.class);
        finish();*/
    }


    private fun login(teller: String, password: String) {
        // 方式二：使用静态方式创建并显示，这种进度条只能是圆形条,设置title和Message提示内容
        val mQueue = Volley.newRequestQueue(this@SignActivity)
        val stringRequest = object : StringRequest(Request.Method.POST, NetWorkUrl.BASEURL, Response.Listener<String> { s ->
            Log.d("TAG", s.toString())
            Log.e("login", "-------获取到的idjson--------" + s.toString())
            try {
                val jo = JSONObject(s)
                /*解析最外层数据*/
                dialog2.dismiss()

                /*获取公司*/
                val he = jo.getJSONObject("data")
                Log.e("he", "------------------data-he-json---------" + he)/*这里的he就是要解析的json*/

                /*ifstatus为0则表示成功，签到成功后跳转*/
                if (jo.getInt("status") == 0) {

                    //绑定SignBean
                    //                    SignBean signBean = new SignBean(he.getInt("userid"), he.getInt("supplierid"));
                    val signBean = SignBean()
                    signBean.userid = he.getInt("userid")
                    signBean.supplierid = he.getInt("supplierid")

                    app.saveUserInfo(signBean)


                    /*跳转*/
                    //                        startActivity(ConsumptionActivity.class);
                    finish()
                } else if (jo.getInt("status") == 1) {//如果登录失败的话提示失败原因
                    //                        ToastUtil.show(SignActivity.this, jo.getString("message"));
                }

            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }, Response.ErrorListener { }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                val map = HashMap<String, String>()
                /*在这拼接要传输的字符串*/
                /*功能名称signIn*/
                /*p为拼接的参数信息*/
                val p = "\"username\":\"$teller\",\"password\":\"$password\""//p是要传递的参数拼接起来的字符串
                val json = Tool.mosaicJson("signIn", p)
                /*json还要加密*/
                val encodeJson = DesBase64Util.encode(json)
                val decdeJson = DesBase64Util.decode(encodeJson)
                Log.e("sign", "--------teller:$teller-----password:$password----------p:$p-------json:$json-------encodeJson:$encodeJson--------decdeJson:$decdeJson")
                map.put("pos", encodeJson)
                return map
            }

            override fun parseNetworkResponse(response: NetworkResponse): Response<String> {
                val superResponse = super
                        .parseNetworkResponse(response)
                val responseHeaders = response.headers
                val rawCookies = responseHeaders["Set-Cookie"]
                if (rawCookies != null) {
                    //Constant是一个自建的类，存储常用的全局变量
                    Constant.localCookie = rawCookies.substring(0, rawCookies.indexOf(";"))
                    Log.d("sessionid", "sessionid----------------" + Constant.localCookie)
                }
                return superResponse
            }

        }
        /*设置请求一次*/
        stringRequest.retryPolicy = DefaultRetryPolicy(
                500000, //默认超时时间，应设置一个稍微大点儿的，例如本处的500000
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, //默认最大尝试次数
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )
        mQueue.add(stringRequest)/*请求数据*/
    }

    /*SignActivity的点击事件*/
    override fun onClick(v: View) {
        when (v.id) {
            R.id.activity_sign_btn_nowsign ->
                /*签到方法(登录)*/
                userSign()
            R.id.activity_sign_num_1 -> stringAdd("1")
            R.id.activity_sign_num_2 -> stringAdd("2")
            R.id.activity_sign_num_3 -> stringAdd("3")
            R.id.activity_sign_num_4 -> stringAdd("4")
            R.id.activity_sign_num_5 -> stringAdd("5")
            R.id.activity_sign_num_6 -> stringAdd("6")
            R.id.activity_sign_num_7 -> stringAdd("7")
            R.id.activity_sign_num_8 -> stringAdd("8")
            R.id.activity_sign_num_9 -> stringAdd("9")
            R.id.activity_sign_num_clear -> stringClear()
            R.id.activity_sign_num_0 -> stringAdd("0")
            R.id.activity_sign_num_delete -> stringDelete()
        }
    }


    /*意图跳转*/
    fun startActivity(activityClass: Class<out Activity>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}
