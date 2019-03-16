package com.example.Bachelors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProperty extends AppCompatActivity {

    //DatabaseHelper myDb;
    EditText editName,editlocation,editAvl_rooms ,editTextPt;
    Button btnAddData;
    Button btnviewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);

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
    }
}
