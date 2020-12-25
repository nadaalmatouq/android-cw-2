package com.example.signupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class homeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        TextView username = findViewById(R.id.name);
        TextView useremail = findViewById(R.id.email);
        TextView useraddr = findViewById(R.id.address);
        TextView userphone = findViewById(R.id.phone);


        Bundle b = getIntent().getExtras();  //Bundle has all the things traveled from the other view
        final String name = b.getString("user"); //get the sting name from the bundle
        final String address = b.getString("address");
        final String email = b.getString("email");
        final String phone = b.getString("phone");

        username.setText(name);
        useremail.setText("Email: "+email);
        useraddr.setText("Address: "+address);
        userphone.setText("Phone number: "+phone);


        //phone
        userphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+phone));
                startActivity(callIntent);


            }
        });

        //map
        useraddr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?q=loc:%f,%f", 29.2835281,48.0263599);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);

            }
        });

        //email
        useremail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent email_i = new Intent(Intent.ACTION_SEND);

                email_i.putExtra(Intent.EXTRA_EMAIL, email);
                email_i.putExtra(Intent.EXTRA_SUBJECT, "");
                email_i.putExtra(Intent.EXTRA_TEXT, "");

//need this to prompts email client only
                email_i.setType("text/plain");

                startActivity(Intent.createChooser(email_i, "Choose an Email client :"));


            }
        });













    }
}