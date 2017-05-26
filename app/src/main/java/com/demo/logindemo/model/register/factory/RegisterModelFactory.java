package com.demo.logindemo.model.register.factory;

import com.demo.logindemo.model.register.impl.RegisterModel;
import com.demo.logindemo.model.register.interf.IRegisterModel;

/**
 * Created by fupengpeng on 2017/5/26 0026.
 * 注册信息业务工厂
 */

public class RegisterModelFactory {

    /**
     * 创建注册信息业务
     *
     * @return 注册信息业务
     */
    public static IRegisterModel newInstance() {
        return new RegisterModel();
    }
}
