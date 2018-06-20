package com.android.dhara.muviapp.register.view;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.dhara.muviapp.R;
import com.android.dhara.muviapp.common.ViewInteractionListener;
import com.android.dhara.muviapp.utils.KeyboardHelper;

import javax.inject.Inject;

public class RegisterViewImpl implements RegisterView {
    private final AppCompatActivity activity;
    private EditText etEmail;
    private EditText etPassword;
    private Button btnRegister;
    private View progressView;
    private ViewInteractionListener listener;

    @Inject
    public RegisterViewImpl(final AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void initViews(final ViewInteractionListener listener) {
        initToolbar();

        this.listener = listener;
        progressView = activity.findViewById(R.id.lnr_progress_view);
        etEmail = activity.findViewById(R.id.et_username);
        etPassword = activity.findViewById(R.id.et_password);
        btnRegister = activity.findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(v -> {
            KeyboardHelper.hideKeyboard(activity.getCurrentFocus());

            if (TextUtils.isEmpty(etEmail.getText().toString())) {
                showMessage(activity.getString(R.string.error_email_cannot_be_empty));
                return;
            }

            if (TextUtils.isEmpty(etPassword.getText().toString())) {
                showMessage(activity.getString(R.string.error_password_cannot_be_empty));
                return;
            }

            listener.onSignUpClicked();
        });

        final TextView txtLogin = activity.findViewById(R.id.txt_login);
        txtLogin.setOnClickListener(v -> listener.onLoginClicked());
    }

    @Override
    public void showMessage(final String message) {
        Snackbar.make(btnRegister, message, Snackbar.LENGTH_LONG).show();
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
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            listener.onBackPressed();
            return true;
        }
        return false;
    }

    @Override
    public String getEmail() {
        return etEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    private void initToolbar() {
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setHomeButtonEnabled(true);
    }
}
