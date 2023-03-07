package com.example.womennovation;

import static com.example.womennovation.MainActivity2.dataBaseHandler;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;


public class MainActivity3 extends AppCompatActivity {
    MaterialButton register;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ActionBar actionBar  =getSupportActionBar();
        actionBar.hide();
        register=(MaterialButton) findViewById(R.id.registerButton);
        EditText name = (EditText) findViewById(R.id.registerName);
        EditText password = (EditText) findViewById(R.id.registerPassword);
        EditText age = (EditText) findViewById(R.id.registerAge);
        EditText city = (EditText) findViewById(R.id.registerCity);
        EditText state = (EditText) findViewById(R.id.registerState);
        EditText contact1 = (EditText) findViewById(R.id.registerContact1);
        EditText contact2 = (EditText) findViewById(R.id.registerContact2);
        EditText contact3 = (EditText) findViewById(R.id.registerContact3);
        EditText pin = (EditText) findViewById(R.id.registerPin);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int flag = 1;
                if(name.getEditableText().toString().equals("") || password.getEditableText().toString().equals("") || city.getEditableText().toString().equals("")|| state.getEditableText().toString().equals("")||pin.getEditableText().toString().equals("")||contact1.getEditableText().toString().equals("")||contact2.getEditableText().toString().equals("")||contact3.getEditableText().toString().equals("")||age.getEditableText().toString().equals("")){
                    Toast.makeText(MainActivity3.this, "Empty Field", Toast.LENGTH_LONG).show();
                    flag = 0;
                }
                else {
                    if (Integer.parseInt(age.getEditableText().toString()) > 100 || Integer.parseInt(age.getEditableText().toString()) < 1) {
                        Toast.makeText(MainActivity3.this, "Invalid Age", Toast.LENGTH_LONG).show();
                        flag = 0;
                    }
                    if (contact1.getEditableText().toString().length() != 10 || contact2.getEditableText().toString().length() != 10 || contact3.getEditableText().toString().length() != 10) {
                        Toast.makeText(MainActivity3.this, "Invalid Contact Number", Toast.LENGTH_LONG).show();
                        flag = 0;
                    }
                    if (pin.getEditableText().toString().length() != 4) {
                        Toast.makeText(MainActivity3.this, "Invalid pin", Toast.LENGTH_LONG).show();
                        flag = 0;
                    }
                }

                if(flag == 1){
                    String name_ = name.getEditableText().toString();
                    String password_ = password.getEditableText().toString();
                    int age_=Integer.parseInt(age.getEditableText().toString());
                    String city_ = city.getEditableText().toString();
                    String state_ = state.getEditableText().toString();
                    long contact1_=Long.parseLong(contact1.getEditableText().toString());
                    long contact2_=Long.parseLong(contact2.getEditableText().toString());
                    long contact3_=Long.parseLong(contact3.getEditableText().toString());
                    int pin_=Integer.parseInt(pin.getEditableText().toString());

                    boolean insertData=dataBaseHandler.addData(name_,password_,age_,city_,state_,contact1_,contact2_,contact3_,pin_);
                    if (insertData==true)
                    {
                        Toast.makeText(MainActivity3.this,"Data added Successfully!",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(MainActivity3.this,"Data failed to set",Toast.LENGTH_LONG).show();
                    }
                    Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                    startActivity(intent);
                }
            }
        });


    }
}
