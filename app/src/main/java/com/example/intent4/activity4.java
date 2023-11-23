package com.example.intent4;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity4 extends AppCompatActivity {
    public static int Request_Code = 1;
    static String from = "4 activity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4);

        Button button1 = findViewById(R.id.But1);
        Button button3 = findViewById(R.id.But3);
        Button button2 = findViewById(R.id.But2);
        Button buttonB = findViewById(R.id.ButB);

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("result", from);
                setResult(RESULT_OK,i);
                finish();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity4.this,MainActivity.class);
                startActivityForResult(i, Request_Code);
                i.putExtra("result", from);
                setResult(RESULT_OK,i);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity4.this,activity3.class);
                startActivityForResult(i, Request_Code);
                i.putExtra("result", from);
                setResult(RESULT_OK,i);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity4.this,activity2.class);
                startActivityForResult(i, Request_Code);
                i.putExtra("result", from);
                setResult(RESULT_OK,i);
            }
        });
    }
    protected void onActivityResult(int request_Code, int resultCode, Intent data ) {

        super.onActivityResult(request_Code, resultCode, data);
        if(request_Code==Request_Code){
            String to = data.getStringExtra("result");
            Toast.makeText(getApplicationContext(),"From " + from + " To " + to, Toast.LENGTH_SHORT).show();
        }
    }
}
