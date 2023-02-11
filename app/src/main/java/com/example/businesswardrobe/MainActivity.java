package com.example.businesswardrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Button btn_ok;
    private EditText edit_count;
    private TextView youCan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(this.getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);

        btn_ok = findViewById(R.id.button_ok);
        edit_count = findViewById(R.id.edit_text_count_money);
        youCan = findViewById(R.id.you_can);

        fillAssortment();

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(edit_count.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Type count", Toast.LENGTH_SHORT).show();
                }else {
                    int money = Integer.parseInt(edit_count.getText().toString());
                    youCan.setAlpha(1);
                }
            }
        });
    }
    public static class assortment{
        String name;
        int cost;
        float discount;
    }
    public void fillAssortment(){
        //Пальто
        assortment coat = new assortment();
        coat.name = "Coat";
        coat.cost = 70;
        coat.discount = 0.77f;

        //Шляпа
        assortment hat = new assortment();
        hat.name = "Hat";
        hat.cost = 25;
        hat.discount = 0.37f;

        //Костюм
        assortment suit = new assortment();
        suit.name = "Suit";
        suit.cost =  53;
        suit.discount = 0.44f;

        //Сорочка
        assortment shirt = new assortment();
        shirt.name = "Shirt";
        shirt.cost = 19;
        shirt.discount = (int)1;

        //Туфли
        assortment shoes = new assortment();
        shoes.name = "Shoes";
        shoes.cost = 41;
        shoes.discount = 0.32f;
    }
}
