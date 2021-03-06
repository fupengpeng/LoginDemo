package com.demo.logindemo.model.register.interf;

import com.demo.logindemo.common.ObjectCallBack;

/**
 * Created by fupengpeng on 2017/5/26 0026.
 * 注册业务接口
 */

public interface IRegisterModel {

    /**
     * 获取验证码
     * @param mobilePhoneNumber  手机号码
     * @param callBack  回调
     */
    void getVerificationCode(String mobilePhoneNumber,ObjectCallBack<String> callBack);

    /**
     * 注册
     * @param tel  手机号码
     * @param password  密码
     * @param callBack  回调
     */
    void register(String tel,String password,ObjectCallBack<String> callBack);
}
