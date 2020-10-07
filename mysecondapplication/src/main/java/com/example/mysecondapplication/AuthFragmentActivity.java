package com.example.mysecondapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AuthFragmentActivity extends Fragment {

    private TextView mLogin;
    private TextView mPassword;
    private Button mEnter;
    private Button mReg;

    private View.OnClickListener mOnEnterListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {


            if (isEmailValid() && isPasswordValid()){
                Intent startProfileIntent = new Intent(getActivity(),
                        ProfileActivity.class);

                startProfileIntent.putExtra(ProfileActivity.USER_KEY, new User(
                        mLogin.getText().toString(), mPassword.getText().toString()));
//                startProfileIntent.putExtra(ProfileActivity.PASSWORD_KEY,
//                        mPassword.getText().toString());
                startActivity(startProfileIntent);

            }
            else{
                //showMessage(R.string.login_input_error);
            }
        }
    };

//    private void showMes(){
//        if (!TextUtils.isEmpty(mLogin.getText()))
//            Toast.makeText(this, mLogin.getText(), Toast.LENGTH_LONG).show();
//    }
//
//    private void showMessage(@StringRes int string){
//        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
//    }

    public boolean isEmailValid(){
        return !(TextUtils.isEmpty(mLogin.getText()) && Patterns.EMAIL_ADDRESS.
                matcher(mLogin.getText()).matches());
    }

    public boolean isPasswordValid(){
        return !TextUtils.isEmpty(mPassword.getText());
    };

    private View.OnClickListener mOnRegisterListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            //TO DO override on
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_activity, container, false);

        //setContentView(R.layout.activity_main);

        mLogin = v.findViewById(R.id.etLogin);
        mPassword = v.findViewById(R.id.etPassword);
        mEnter = v.findViewById(R.id.enterBtn);
        mReg = v.findViewById(R.id.regBtn);

        mEnter.setOnClickListener(mOnEnterListener);
        mReg.setOnClickListener(mOnRegisterListener);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


}
