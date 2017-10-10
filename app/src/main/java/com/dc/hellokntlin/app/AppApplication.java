package com.dc.hellokntlin.app;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.dc.hellokntlin.bean.SignBean;


/**
 * Created by dingchao on 2017/8/28.
 */

public class AppApplication extends Application {
    private static AppApplication application;
    private static Context mContext;

    private String cardNum;


    private SignBean signBean;

    private String versionName;

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    /**
     * 初始化配置
     */
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        /*try {
            getVersionName();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static AppApplication getApp() {
        if (application != null && application instanceof AppApplication) {
            return application;
        } else {
            application = new AppApplication();
            application.onCreate();
            return application;
        }
    }



    /*保存用户信息*/
 /*保存用户信息方法*/

    /**
     * save user info
     */
    public void saveUserInfo(SignBean user) {
        setSignBean(user);
    }

    /*清除用户登录信息，结算完成之后返回登录页，同时用户登录信息清空*/
    public void clearUserInfo() {
        setSignBean(null);
    }

    /*获取应用的版本号*/
    private void getVersionName() throws Exception {
        // 获取packagemanager的实例
        PackageManager packageManager = getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(), 0);
        String version = packInfo.versionName;
        setVersionName(version);
//        return version;
    }


    public SignBean getSignBean() {
        return signBean;
    }

    public void setSignBean(SignBean signBean) {
        this.signBean = signBean;
    }

    public static Context getmContext() {
        return mContext;
    }


    public void saveCardNum(String cardNum) {
        setCardNum(cardNum);
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}
