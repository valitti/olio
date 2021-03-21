package com.example.olio1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText writeName, readName, input;

    Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.fileInput);
        writeName = findViewById(R.id.writeName);
        readName = findViewById(R.id.readName);
        context = MainActivity.this;
    }

    public void writeFile(View v) {
        try{
            String name, text;
            name = writeName.getText().toString();
            text = input.getText().toString();
            OutputStreamWriter writer = new OutputStreamWriter(context.openFileOutput(name, Context.MODE_PRIVATE));
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            Log.e("IOException", "Virhe");
        } finally {
            System.out.println("Done");
        }
    }

    public void readFile(View v) {
        try{
            String name, line;
            input.setText("");
            name = readName.getText().toString();
            InputStream is = context.openFileInput(name);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                line = (line + System.getProperty("line.separator"));
                input.append(line);
            }
            is.close();
        } catch (IOException e) {
            Log.e("IOException", "Virhe");
        } finally {
            System.out.println("Done");
        }
    }
}