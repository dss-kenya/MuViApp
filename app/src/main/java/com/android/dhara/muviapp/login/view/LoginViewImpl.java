package com.android.dhara.muviapp.login.view;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.dhara.muviapp.R;
import com.android.dhara.muviapp.common.ViewInteractionListener;
import com.android.dhara.muviapp.utils.KeyboardHelper;

import javax.inject.Inject;

public class LoginViewImpl implements LoginView {
    private final AppCompatActivity activity;
    private EditText etUserName;
    private EditText etPassword;
    private Button btnLogin;
    private View progressView;

    @Inject
    public LoginViewImpl(final AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void initViews(final ViewInteractionListener listener) {
        progressView = activity.findViewById(R.id.lnr_progress_view);
        etUserName = activity.findViewById(R.id.et_username);
        etPassword = activity.findViewById(R.id.et_password);
        btnLogin = activity.findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(v -> {
            KeyboardHelper.hideKeyboard(activity.getCurrentFocus());

            if (TextUtils.isEmpty(etUserName.getText().toString())) {
                showErrorMessage(activity.getString(R.string.error_username_cannot_be_empty));
                return;
            }

            if (TextUtils.isEmpty(etPassword.getText().toString())) {
                showErrorMessage(activity.getString(R.string.error_password_cannot_be_empty));
                return;
            }

            listener.onLoginClicked();
        });

        final TextView txtRegister = activity.findViewById(R.id.txt_register);
        txtRegister.setOnClickListener(v -> listener.onSignUpClicked());
    }

    @Override
    public void showErrorMessage(final String errorMessage) {
        Snackbar.make(btnLogin, errorMessage, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {
        progressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressView.setVisibility(View.GONE);
    }

    @Override
    public String getUserName() {
        return etUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }
}
