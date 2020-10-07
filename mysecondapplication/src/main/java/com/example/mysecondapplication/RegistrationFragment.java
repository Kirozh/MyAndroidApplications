package com.example.mysecondapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RegistrationFragment extends Fragment {
    private EditText mLogin;
    private EditText mPassword;
    private EditText mPasswordAgain;
    private Button mReg;

    public static RegistrationFragment newInstance() {return new RegistrationFragment();}

    private View.OnClickListener mOnRegistrationClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if (isInputValid()){
                return true;
            }
            return false;
        }




    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_registration, container, false);

        mLogin = view.findViewById(R.id.etLogin);
        mPassword = view.findViewById(R.id.etPassword);
        mPasswordAgain = view.findViewById(R.id.etPasswordAgain);
        mReg = view.findViewById(R.id.regBtn);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private boolean isInputValid(){
        String email = mLogin.getText().toString();
        if (isEmailValid(email) && isPasswordValid()){
            return true;
        }
        return false;
    }

    public boolean isEmailValid(String email) {
        return !(TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.
                matcher(email).matches());
    }

    public boolean isPasswordValid(){
        String password = mPassword.getText().toString();
        String passwordAgain = mPasswordAgain.getText().toString();

        return password.equals(passwordAgain)
                || !TextUtils.isEmpty(password)
                || !TextUtils.isEmpty(passwordAgain);
    }
}
