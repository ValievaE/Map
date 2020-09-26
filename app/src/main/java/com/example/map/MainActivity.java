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
    private EditText coordinates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinates = findViewById(R.id.editTextCoordinates);


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
        input = coordinates.getText().toString();
        char[] charArray = input.toCharArray();
        boolean b = false;
        for (int i = 0; i < charArray.length; i++) {
            b = Character.isLetter(charArray[i]);
            if (b == true) break;
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