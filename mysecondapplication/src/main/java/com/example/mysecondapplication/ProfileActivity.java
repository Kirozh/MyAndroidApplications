package com.example.mysecondapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;


public class ProfileActivity extends AppCompatActivity {
    private AppCompatImageView mPhoto;
    private TextView mLogin;
    private TextView mPassword;

    public static String USER_KEY = "USER_KEY";
    //public static String PASSWORD_KEY = "PASSWORD_KEY";

    private View.OnClickListener onPhotoClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //todo
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        mPhoto = findViewById(R.id.ivPhoto);
        mLogin = findViewById(R.id.tvEmail);
        mPassword = findViewById(R.id.tvPassword);

        Bundle bundle = getIntent().getExtras();
        User user = (User) bundle.get(USER_KEY);
        mLogin.setText(user.getLogin());
        mPassword.setText(user.getPassword());

        mPhoto.setOnClickListener(onPhotoClickListener);
    }
}
