package com.example.Bachelors;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserProfile extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DatabaseReference databaseUsers;
    FirebaseAuth firebaseAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final Button buttonEdit = (Button) findViewById(R.id.buttonEdit);
        final Button buttonSaveChanges = (Button) findViewById(R.id.buttonSaveChanges);
        final EditText username = (EditText) findViewById(R.id.editText_username);
        final EditText firstname = (EditText) findViewById(R.id.editText_first_name);
        final EditText lastname = (EditText) findViewById(R.id.editText_last_name);
        final EditText phoneno = (EditText) findViewById(R.id.editText_phone_no);
        firebaseAuth = FirebaseAuth.getInstance();
        mUser = firebaseAuth.getCurrentUser();
        databaseUsers = FirebaseDatabase.getInstance().getReference("userdetails Details");

        // retrieve from database here

        username.setText("test@test.com");
        firstname.setText("Testboi");
        lastname.setText("1234");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    username.setInputType(0);
                    username.setEnabled(false);
                    phoneno.setInputType(1);
                    firstname.setInputType(1);
                    lastname.setInputType(1);
                    buttonSaveChanges.setVisibility(View.VISIBLE);
                    buttonEdit.setVisibility(View.INVISIBLE);

    }});

        buttonSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameString = username.getText().toString().trim();
                String firstnameString = firstname.getText().toString().trim();
                String lastnameString = lastname.getText().toString().trim();

                // check and update database

//                currentUser?.updateEmail(email) { error in
//                    if let error = error {
//                        print(error)
//                    }
//                    else {
//                        // Email updated
//                    }
//                }

                username.setInputType(0);
                username.setEnabled(true);
                phoneno.setInputType(0);
                firstname.setInputType(0);
                lastname.setInputType(0);
                buttonSaveChanges.setVisibility(View.INVISIBLE);
                buttonEdit.setVisibility(View.VISIBLE);

            }});

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch(id) {

            case R.id.nav_add_property :
//                Intent a = new Intent(AddProperty.this,AddProperty.class);
//                startActivity(a);
                break;
            case R.id.nav_chat :
//                Intent c = new Intent(Dashboard_common.this,Dashboard_common.class);
//                startActivity(a);
                break;
            case R.id.nav_dashboard :
                Intent d = new Intent(this,Dashboard_common.class);
                startActivity(d);
                break;
            case R.id.nav_notifications :
//                Intent a = new Intent(Dashboard_common.this,Dashboard_common.class);
//                startActivity(a);
                break;
            case R.id.nav_profile :
                Intent p = new Intent(UserProfile.this,UserProfile.class);
                startActivity(p);
                break;
            case R.id.nav_sign_out :
                Intent l = new Intent(this,LoginActivity.class);
                startActivity(l);
                break;
            case R.id.nav_suggestions :
//                Intent a = new Intent(Dashboard_common.this,Dashboard_common.class);
//                startActivity(a);
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
