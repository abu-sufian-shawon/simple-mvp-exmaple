package com.abusufian.simple_mvp_example;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.abusufian.simple_mvp_example.Presenter.LoginPresenter;
import com.abusufian.simple_mvp_example.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init view components
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtPassword = findViewById(R.id.edtPassword);
        AppCompatButton btnLogin = findViewById(R.id.btnLogin);


        loginPresenter = new LoginPresenter(this); // initialize presenter

        // pass data to presenter
        btnLogin.setOnClickListener(v -> {
            loginPresenter.onLogin(edtEmail.getText().toString()
                    , edtPassword.getText().toString());
        });
    }

    @Override
    public void onLoginResult(String message) {
        // after doing some operation, presenter will call this method
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}