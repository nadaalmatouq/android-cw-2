package com.example.signupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = findViewById(R.id.name);
        final EditText email = findViewById(R.id.email);
        final EditText phone = findViewById(R.id.phone);
        final EditText address = findViewById(R.id.address);

        Button signButton = findViewById(R.id.button);

        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make a bridge between the two views
                Intent i = new Intent(MainActivity.this,homeScreen.class);

                String NAME = name.getText().toString();
                i.putExtra("user",NAME); // things i want to move wih me to next view on the bridge

                String EMAIL = email.getText().toString();
                i.putExtra("email",EMAIL);

                String ADDRESS = address.getText().toString();
                i.putExtra("address",ADDRESS);

                String num = phone.getText().toString();
                i.putExtra("phone",num);

                //on button click Jump to homeScreen view
                startActivity(i);

            }
        });












    }
}