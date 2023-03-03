package com.minhtrietofficial.lab1_ex2;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edText;
    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edText = findViewById(R.id.edText);
        Button btClickme = findViewById(R.id.btClickme);
        tvText = findViewById(R.id.tvText);

        btClickme.setOnClickListener(view -> {
            String message = edText.getText().toString().trim();
            if (message.isEmpty()){
                Toast toast = Toast.makeText(MainActivity.this, "Vui lòng nhập thông tin", Toast.LENGTH_LONG);
                toast.show();
            }
            else {
                tvText.setText(message);
                edText.setText("");
            }
        });

        edText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String message = edText.getText().toString().toLowerCase();
                if(message.equals("on")) {
                    btClickme.setEnabled(true);
                }
                else if (message.equals("off")) {
                    btClickme.setEnabled(false);
                }
            }
        });

    }
}