package com.example.intent4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String RESULT = "result";
    static String from = "1 activity";
    public static int Request_Code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button button2 = findViewById(R.id.But2);
        Button button3 = findViewById(R.id.But3);
        Button button4 = findViewById(R.id.But4);
        Button buttonB = findViewById(R.id.ButB);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, activity2.class);
                startActivityForResult(i, Request_Code);
                i.putExtra("result", from);
                setResult(RESULT_OK,i);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, activity3.class);
                startActivityForResult(i, Request_Code);
                i.putExtra("result", from);
                setResult(RESULT_OK,i);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, activity4.class);
                startActivityForResult(i, Request_Code);
                i.putExtra("result", from);
                setResult(RESULT_OK,i);
            }
        });
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("result", from);
                setResult(RESULT_OK,i);
                finish();
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