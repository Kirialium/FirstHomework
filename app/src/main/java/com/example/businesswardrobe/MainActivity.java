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
    private int money;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(this.getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);

        btn_ok = findViewById(R.id.button_ok);
        edit_count = findViewById(R.id.edit_text_count_money);
        youCan = findViewById(R.id.you_can);
        textView2 = findViewById(R.id.text_view2);
        textView3 = findViewById(R.id.text_view3);
        textView4 = findViewById(R.id.text_view4);
        textView5 = findViewById(R.id.text_view5);
        textView6 = findViewById(R.id.text_view6);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(edit_count.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Type count", Toast.LENGTH_SHORT).show();
                }else {
                    money = Integer.parseInt(edit_count.getText().toString());
                    youCan.setAlpha(1);
                    fillAssortment(money);
                }
            }
        });
    }
    public static class assortment{
        String name;
        int cost;
        float discount;
        float total;
    }
    public void fillAssortment(int money){
        //Пальто
        assortment coat = new assortment();
        coat.name = "Coat";
        coat.cost = 70;
        coat.discount = 0.77f;
        coat.total = coat.cost * coat.discount;

        //Шляпа
        assortment hat = new assortment();
        hat.name = "Hat";
        hat.cost = 25;
        hat.discount = 0.37f;
        hat.total = hat.cost * hat.discount;

        //Костюм
        assortment suit = new assortment();
        suit.name = "Suit";
        suit.cost =  53;
        suit.discount = 0.44f;
        suit.total = suit.cost * suit.discount;

        //Сорочка
        assortment shirt = new assortment();
        shirt.name = "Shirt";
        shirt.cost = 19;
        shirt.discount = (int)1;
        shirt.total = shirt.cost * shirt.discount;

        //Туфли
        assortment shoes = new assortment();
        shoes.name = "Shoes";
        shoes.cost = 41;
        shoes.discount = 0.32f;
        shoes.total = shoes.cost * shoes.discount;

        float fullCost = coat.total + hat.total + suit.total + shirt.total + shoes.total;

        if(fullCost <= money){
            textView2.setAlpha(1);
            textView2.setText("Вы можете купить весь набор!");
        }
        else if(shirt.total > money){
            textView2.setAlpha(1);
            textView2.setText("Вы не можете купить ничего");
        }
        else{
            textView2.setAlpha(1);
            textView2.setText("Вы не можете купить весь набор, но вы можете купить это по отдельности:");
            int sum = money - (int)shirt.total;
            int count = 1;
            while(count <= 4){
                switch(count){
                    case 1:
                        sum = sum - (int)hat.total;
                        textView3.setAlpha(1);
                        textView3.setText("Сорочка");
                        if(money - sum >= 0){
                            count++;
                        }
                        else{
                            break;
                        }
                        break;
                    case 2:
                        sum = sum - (int)shoes.total;
                        textView4.setAlpha(1);
                        textView4.setText("Туфли(32% скидка!)");
                        if(money - sum >= 0){
                            count++;
                        }
                        else{
                            break;
                        }
                        break;
                    case 3:
                        sum = sum - (int)suit.total;
                        textView5.setAlpha(1);
                        textView5.setText("Костюм(44% скидка!)");
                        if(money - sum >= 0){
                            count++;
                        }
                        else{
                            break;
                        }
                        break;
                    case 4:
                        sum = sum - (int)coat.total;
                        textView6.setAlpha(1);
                        textView6.setText("Пальто(77% скидка!)");
                        if(money - sum >= 0){
                            count++;
                        }
                        else{
                            break;
                        }
                        break;
                }
            }
        }
    }
}