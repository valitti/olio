package com.example.olio1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;

public class MainActivity extends AppCompatActivity {

    TextView text;
    EditText newText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView2);
        newText = findViewById(R.id.plain_text_input);
        newText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                String input = newText.getText().toString();
                text.setText(input);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int after, int count) {}
        });

    }
}