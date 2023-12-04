package com.example.Bachelors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Review2 extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    EditText xName;
    EditText xProperty;
    EditText xAddress;
    EditText xDuration;
    EditText xFeedback;
    RatingBar xRatingBar;
    Button xsubmit;
    review_get_set Details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review2);
    }
}
