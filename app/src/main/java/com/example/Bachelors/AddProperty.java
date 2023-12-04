package com.example.Bachelors;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddProperty extends AppCompatActivity
{


    private EditText editName, editaddress, editAvl_rooms, editproperty;
    private Button btnAddData;
    property Details;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    private ImageButton SelectPostImage;
    private FirebaseDatabase database;
    private DatabaseReference Ref_name, Ref_address, Ref_rooms, Ref_property;
    private static final int Gallery_pick =1;
    private Uri ImageUri;
    private String Description;
    private StorageReference PostImageReference;
    private String saveCurrentDate,saveCurrentTime,PostrRandomName;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        PostImageReference = FirebaseStorage.getInstance().getReference();

        SelectPostImage = (ImageButton) findViewById(R.id.select_post_image);
        editName = (EditText) findViewById(R.id.editText_name);
        editaddress = (EditText) findViewById(R.id.editText_location);
        editAvl_rooms = (EditText) findViewById(R.id.editText_rooms);
        editproperty = (EditText) findViewById(R.id.editText_Pt);
        btnAddData = (Button) findViewById(R.id.button_addData);


        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        Ref_name = database.getReference("Owner").child("name");
        Ref_address = database.getReference("Owner").child("address");
        Ref_rooms = database.getReference("Owner").child("rooms");
        Ref_property = database.getReference("Owner").child("property");

        SelectPostImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGallery();
            }
        });


        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {

                ValidationPostInfo();
                int check = upload();

                if (check == 1) {
                    Toast.makeText(AddProperty.this,"Details added",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(AddProperty.this, Dashboard_common.class));
                }

                else {
                    Toast.makeText(AddProperty.this, "Error", Toast.LENGTH_LONG).show();
                }

//                Ref_name.push().setValue(editName.getText().toString());
//                Ref_address.push().setValue(editaddress.getText().toString());
//                Ref_rooms.push().setValue(editAvl_rooms.getText().toString());
//                Ref_property.push().setValue(editproperty.getText().toString());
            }
        });

    }

    public int upload(){
        Details = new property();

        try {

            Details.setName(editName.getText().toString().trim());
            Details.setLocation(editaddress.getText().toString().trim());
            Details.setAvl_rooms(editAvl_rooms.getText().toString().trim());
            Details.setPt(editproperty.getText().toString().trim());

            Toast.makeText(AddProperty.this, Details.getAvl_rooms(), Toast.LENGTH_LONG).show();

            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Property");
            String id = mUser.getUid();
            databaseReference.child(id).push().setValue(Details);
            return 1;


        } catch (NullPointerException e) {
            return 0;


        }

    }

    private void ValidationPostInfo()
    {
        if(ImageUri == null)
        {
            Toast.makeText(this, "Please select image", Toast.LENGTH_SHORT).show();
        }
        else
        {
            StoringImageToFirebaseStorage();
        }

    }

    private void StoringImageToFirebaseStorage()
    {
        Calendar calForDate =Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("dd-MMMM-YYYY");
        saveCurrentDate= currentDate.format(calForDate.getTime());

        Calendar calForTime =Calendar.getInstance();
        SimpleDateFormat currentTime = new SimpleDateFormat("dd-MMMM-YYYY");
        saveCurrentTime= currentDate.format(calForDate.getTime());


        PostrRandomName =saveCurrentDate+saveCurrentTime;
        StorageReference firePath = PostImageReference.child("Post Image").child(ImageUri.getLastPathSegment()+PostrRandomName+".jpg");

        firePath.putFile(ImageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task)
            {
                if(task.isSuccessful())
                {
                    Toast.makeText(AddProperty.this, "Image uploaded successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String message =task.getException().getMessage();
                    Toast.makeText(AddProperty.this, "Error occured"+message, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void OpenGallery()
    {
        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/");
        startActivityForResult(galleryIntent,Gallery_pick);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==Gallery_pick && resultCode==RESULT_OK && data!=null)
        {
            ImageUri=data.getData();
            SelectPostImage.setImageURI(ImageUri);
        }
    }

}
