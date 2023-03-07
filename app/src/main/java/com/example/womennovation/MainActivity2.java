package com.example.womennovation;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity2 extends  AppCompatActivity{

    public MaterialButton login,signUp;

    public EditText userName,passWord,age,city,state,contact1,contact2,contact3,pin;
    public static String username_,password_;
    public static DatabaseHandler dataBaseHandler;

    public static ArrayList<String> nameList = new ArrayList<>();
    public static ArrayList<String> passwordList = new ArrayList<>();
    public static ArrayList<Integer> ageList = new ArrayList<>();
    public static ArrayList<String> cityList = new ArrayList<>();
    public static ArrayList<String> stateList = new ArrayList<>();
    public static ArrayList<Long> contact1List = new ArrayList<>();
    public static ArrayList<Long> contact2List = new ArrayList<>();
    public static ArrayList<Long> contact3List = new ArrayList<>();
    public static ArrayList<Integer> pinList = new ArrayList<>();
    public static int index=-1;
    public void loadData() {

        Cursor data = dataBaseHandler.getListContents();
        if (data.getCount() == 0) {
            Toast.makeText(MainActivity2.this, "No content", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity2.this, "Content Exists", Toast.LENGTH_LONG).show();
            while (data.moveToNext()) {
                nameList.add(data.getString(0));
                passwordList.add(data.getString(1));
                ageList.add(data.getInt(2));
                cityList.add(data.getString(3));
                stateList.add(data.getString(4));
                contact1List.add(data.getLong(5));
                contact2List.add(data.getLong(6));
                contact3List.add(data.getLong(7));
                pinList.add(data.getInt(8));

                System.out.println(data.getString(0));
                System.out.println(data.getString(1));
                System.out.println(data.getInt(2));
                System.out.println(data.getString(3));
                System.out.println(data.getString(4));
                System.out.println(data.getLong(5));
                System.out.println(data.getLong(6));
                System.out.println(data.getLong(7));
                System.out.println(data.getInt(8));

            }


        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar  =getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dataBaseHandler=new DatabaseHandler(this);



        login=(MaterialButton) findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = (EditText) findViewById(R.id.username);
                username_ = userName.getEditableText().toString();

                passWord = (EditText) findViewById(R.id.password);
                password_ = passWord.getEditableText().toString();


                loadData();
                int flag=1;
                for (String i:nameList)
                {
                    if (i.equals(username_)) {
                        index = nameList.indexOf(i);
                        break;
                    }
                }
                if (index==-1)
                {
                    Toast.makeText(MainActivity2.this, "Account doesn't exists", Toast.LENGTH_LONG).show();
                    flag=0;
                }
                else if (!passwordList.get(index).equals(password_))
                {
                    Toast.makeText(MainActivity2.this, "Invalid Password", Toast.LENGTH_LONG).show();
                    flag=0;
                }
                if (flag==1)
                {
                    Intent intent = new Intent(MainActivity2.this,MainActivity4.class);
                    startActivity(intent);
                }

            }
        });
        signUp=(MaterialButton) findViewById(R.id.signUpButton);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }
        });



    }
}
