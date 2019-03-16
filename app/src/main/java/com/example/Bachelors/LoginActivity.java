package com.example.Bachelors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends Activity {

    Button email_sign_in_button;
    EditText email;
    EditText password;
    String Email;
    String Password;
    FirebaseAuth firebaseAuth;
    FirebaseUser mUser;


    @Override
    public void onCreate(@Nullable Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_login);

        // initilaising firebase auth here
        firebaseAuth = FirebaseAuth.getInstance();
        mUser = firebaseAuth.getCurrentUser();
        //

        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        email_sign_in_button = findViewById(R.id.email_sign_in_button);
        email_sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();
                firebaseAuth.signInWithEmailAndPassword(Email ,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(LoginActivity.this,"Login success",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,Dashboard_common.class));
                            finish();
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this,"Not a valid client",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        });
    }
}

//        email = (EditText)findViewById(R.id.email);
//        password = (EditText)findViewById(R.id.password);
//        spinner = (Spinner)findViewById(R.id.spinner);
//        email_sign_in_button = (Button)findViewById(R.id.email_sign_in_button);
//
//        email_sign_in_button.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v){
//                Login();
//            }
//        });








//    private void Login(){
//        String Email = email.getText().toString().trim();
//        String Password = password.getText().toString().trim();
//        String Spinner = spinner.getSelectedItem().toString();
//
//        if(!((TextUtils.isEmpty(Email))||(TextUtils.isEmpty(Password))||(TextUtils.isEmpty(Spinner)))){
//            //add here
//        }
//
//        else{
//
//            Toast.makeText(this,"Enter details",Toast.LENGTH_LONG).show();
//
//        }
//
//    }


