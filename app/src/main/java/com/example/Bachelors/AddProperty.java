package com.example.Bachelors;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;


public class AddProperty extends AppCompatActivity implements Serializable {


    EditText Name, location, avl_rooms, Pt;
    Button AddData;
    Button viewAll;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    String type;



    property Details;


    //DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        AddData = (Button) findViewById(R.id.button_addData);

        Name = (EditText) findViewById(R.id.editText_name);
        location = (EditText) findViewById(R.id.editText_location);
        avl_rooms = (EditText) findViewById(R.id.editText_rooms);
        Pt = (EditText) findViewById(R.id.editText_Pt);

        AddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int check = upload();
                if (check == 1) {
                    startActivity(new Intent(AddProperty.this, Dashboard_common.class));
                }

//               if( getType().compareToIgnoreCase("owner") == 0)

                else {
                    Toast.makeText(AddProperty.this, "Error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public int upload(){
        Details = new property();

        try {

            //serdetails test = (userdetails) getIntent().getSerializableExtra("type");
            //Details.setType(test.getType());
            Details.setName(Name.getText().toString().trim());
            Details.setLocation(location.getText().toString().trim());
            Details.setAvl_rooms(avl_rooms.getText().toString().trim());
            Details.setPt(Pt.getText().toString().trim());

            Toast.makeText(AddProperty.this, Details.getAvl_rooms(), Toast.LENGTH_LONG).show();

            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("User");
            String id = mUser.getUid();
            databaseReference.child(id).push().setValue(Details);


            //DatabaseReference reg = root.child("Reg");
            //reg.setValue(Details);
            return 1;


        } catch (NullPointerException e) {
            return 0;


        }

    }
}














      /*  myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editText_name);
        editlocation = (EditText)findViewById(R.id.editText_location);
        editAvl_rooms = (EditText)findViewById(R.id.editText_rooms);
        editTextPt= (EditText)findViewById(R.id.editText_Pt);
        btnAddData = (Button)findViewById(R.id.button_addData);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);

        AddData();
      viewAll();

    }

    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                  @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editlocation.getText().toString(),
                                editAvl_rooms.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(AddProperty.this,"Data Inserted",Toast.LENGTH_LONG).show();
                       else
                           Toast.makeText(AddProperty.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                   }
                }
        };
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("ID :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Address :"+ res.getString(2)+"\n");
                            buffer.append("Available :"+ res.getString(3)+"\n\n");
                }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);

        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         Inflate the menu;
         //this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         //Handle action bar item clicks here. The action bar will
         //automatically handle clicks on the Home/Up button, so long
         //as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        noinspection SimplifiableIfStatement
       if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);


    }


*/


//    private String getType() {
//        detail = new UserReg();
//        try {
//
//            FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
//            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("User");
//            DatabaseReference mroot = reference.child(mUser.getUid());
//            mroot.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    detail = dataSnapshot.getValue(UserReg.class);
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//
//
//
//            type = detail.getType();
//            Log.d("type ", detail.getType());
//
//        }catch (NullPointerException e){}
//        return type ;
//    }

