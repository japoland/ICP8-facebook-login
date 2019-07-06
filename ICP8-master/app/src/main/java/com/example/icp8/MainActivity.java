package com.example.icp8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.CallbackManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        //LoginUsingLoginButton();
        LoginUsingFacebookButton();
        //callbackManager = CallbackManager.Factory.create();
    }

    public void checkCredentials(View view) {
        EditText usernameCtrl = (EditText)findViewById(R.id.txt_uname);
        EditText passwordCtrl = (EditText) findViewById(R.id.txt_Pwd);
        TextView errorText = (TextView) findViewById(R.id.txt_login);
        String userName = usernameCtrl.getText().toString();
        String password = passwordCtrl.getText().toString();

        boolean validationFlag = false;

        if (!userName.isEmpty() && !password.isEmpty()){
            if (userName.equals("Admin") && password.equals("Admin")){
                validationFlag = true;
            }
        }
        if (!validationFlag){
            errorText.setVisibility(View.VISIBLE);
        }
        //else
            //navigate to home page
    }

    private void LoginUsingFacebookButton(){
        CallbackManager callbackManager;
        callbackManager = CallbackManager.Factory.create();
        FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>(){
            @Override
            public void onSuccess(LoginResult loginResult){
                //redirectToSearchPage();
            }

            @Override
            public void onCancel(){

            }
            @Override
            public void onError(FacebookException error){

            }
        };

        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("public_profile"));
        loginButton.registerCallback(callbackManager, callback);
    }



    //public void reDirectToHoePage(view v){
    //    Intent redirect = new Intent(SignUpActivity.this)
    //}
}
