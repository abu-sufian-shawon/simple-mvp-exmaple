package com.abusufian.simple_mvp_example.Presenter;

import com.abusufian.simple_mvp_example.Model.User;
import com.abusufian.simple_mvp_example.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {
    ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        boolean isLoginSuccess = user.isValidData();

        if (isLoginSuccess) iLoginView.onLoginResult("Login Success");
        else iLoginView.onLoginResult("Login Error");
    }
}
