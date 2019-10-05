package com.garbo.marrion.garbopracticalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText comment1;
    CheckBox checkBox, checkBox1, checkBox2, checkBox3, checkBox4, checkBox5,
            checkBox6, checkBox7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comment1 = findViewById(R.id.comment1);
        checkBox = findViewById(R.id.checkBox);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);

    }

    public void writeData(View v) {
        String comment1data = comment1.getText().toString();

        String events = "";
        if (checkBox.isChecked()) {
            events = events + checkBox.getText().toString() + "\n";
        }
        if (checkBox1.isChecked()) {
            events = events + checkBox1.getText().toString() + "\n";
        }
        if (checkBox2.isChecked()) {
            events = events + checkBox2.getText().toString() + "\n";
        }
        if (checkBox3.isChecked()) {
            events = events + checkBox3.getText().toString() + "\n";
        }
        if (checkBox4.isChecked()) {
            events = events + checkBox4.getText().toString() + "\n";
        }
        if (checkBox5.isChecked()) {
            events = events + checkBox5.getText().toString() + "\n";
        }
        if (checkBox6.isChecked()) {
            events = events + checkBox6.getText().toString() + "\n";
        }
        if (checkBox7.isChecked()) {
            events = events + checkBox7.getText().toString() + "\n";
        }


        FileOutputStream writer = null;
        FileOutputStream writer1 = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer1 = openFileOutput("data2.txt", MODE_PRIVATE);
            writer1.write(events.getBytes());
            writer.write(comment1data.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("Error", "File not found");
        } catch (IOException e) {
            Log.d("Error", "IO Error");
        } finally {
            try {
                writer.close();
                writer1.close();
            } catch (IOException e) {
                Log.d("Error", "File not found");
            }
        }
        Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show();
    }


    public void next(View v) {
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }
}

