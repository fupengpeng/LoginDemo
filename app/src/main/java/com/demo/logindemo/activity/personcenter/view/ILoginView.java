package com.demo.logindemo.activity.personcenter.view;

import com.demo.logindemo.activity.IBaseView;

/**
 * 登录界面接口
 */
public interface ILoginView extends IBaseView {
    /**
     * 设置登录成功
     */
    void setLoginSuccess();
    /**
     * 设置跳转注册页面的按钮点击事件
     */
    void setStartRegister();
}
