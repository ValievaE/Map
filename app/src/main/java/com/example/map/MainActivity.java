package com.example.map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private String input = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSearch = findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coordinateType();

                Intent intent = new Intent(Intent.ACTION_VIEW, createUri());
                startActivity(intent);
            }
        });
    }

    private boolean coordinateType() {
        EditText coordinates = findViewById(R.id.editTextCoordinates);
        input = coordinates.getText().toString();
        char[] inputChar = input.toCharArray();
        boolean b = false;
        for (char ch : inputChar) {
            b = Character.isLetter(ch);
        }
        return b;
    }

    private Uri createUri(){
        Uri uri;
        if (coordinateType() == true) {
            String text = " ?q=";
            uri = Uri.parse("geo:" + text + input);
        } else {
            uri = Uri.parse("geo:" + input);
        }
        return uri;
    }


}