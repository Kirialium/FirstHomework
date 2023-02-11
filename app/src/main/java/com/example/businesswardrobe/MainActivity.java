package com.example.businesswardrobe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    final EditText editTextMoney = (EditText) findViewById(R.id.edit_text_count_money);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(this.getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);

        String value = editTextMoney.getText().toString();
        int finalValue = Integer.parseInt(value);

        

    }
}
