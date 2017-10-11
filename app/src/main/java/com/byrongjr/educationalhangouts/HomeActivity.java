package com.byrongjr.educationalhangouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button byronsButton = (Button)findViewById(R.id.byronsButton);
        RelativeLayout.LayoutParams byronsButton2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        // byronsButton.addRule(RelativeLayout.CENTER_HORIZONTAL);
        // byronsButton.addRule(RelativeLayout.CENTER_VERTICAL);


        byronsButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView byronsText = (TextView)findViewById(R.id.byronsText);
                        byronsText.setText("Good Fucking Job");
                    }
                }

        );
    }
}
