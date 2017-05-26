package com.demo.logindemo.presenter.register.factory;

import com.demo.logindemo.activity.register.view.IRegisterView;
import com.demo.logindemo.presenter.register.impl.RegisterPresenter;
import com.demo.logindemo.presenter.register.interf.IRegisterPresenter;

/**
 * Created by fupengpeng on 2017/5/26 0026.
 * 注册界面主导器工厂
 */

public class RegisterPresenterFactory {
    /**
     * 创建注册界面主导器
     *
     * @param registerView 注册界面
     * @return 注册界面主导器实例
     */
    public static IRegisterPresenter newInstance(IRegisterView registerView) {
        return new RegisterPresenter(registerView);
    }
}
