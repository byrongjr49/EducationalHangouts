package com.byrongjr.educationalhangouts;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class HomeActivity extends MainActivity {

    Button mapButton, chatButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mapButton = (Button) findViewById(R.id.map_btn);
        chatButton = (Button) findViewById(R.id.chatroom_btn);


        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(HomeActivity.this, MapsActivity.class);
                HomeActivity.this.startActivity(mapIntent);
            }
        });

        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chatIntent = new Intent(HomeActivity.this, MainActivity.class);
                if(userCount != 1 )
                {
                    Toast.makeText(HomeActivity.this, userCount + " Users are ready to Hangout !", Toast.LENGTH_LONG)
                            .show();
                }
                else{
                    Toast.makeText(HomeActivity.this, userCount + " User is ready to Hangout !", Toast.LENGTH_LONG)
                            .show();
                }

                HomeActivity.this.startActivity(chatIntent);
            }
        });

    }





}
