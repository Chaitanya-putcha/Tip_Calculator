package com.example.tip_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView price,tip,total;
    EditText service_cost;
    String money;
    SeekBar seekbar;
    float total_price;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        price = findViewById(R.id.textView1);
        tip = findViewById(R.id.textView2);
        total = findViewById(R.id.textView3);
        service_cost = findViewById(R.id.edittext);
        seekbar = findViewById(R.id.seekBar2);
        seekbar.setProgress(5);
        seekbar.setMax(25);
        progress = seekbar.getProgress();

        service_cost.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                money = service_cost.getText().toString();
                total_price = Float.parseFloat(money);
                total_price += (progress/100.0)*total_price;
                Toast.makeText(MainActivity.this,""+total_price,Toast.LENGTH_SHORT).show();
                total.setText("Total: "+total_price);
            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tip.setText("Tip: "+progress+"%");
                total_price = Float.parseFloat(money);
                total_price += (progress/100.0)*total_price;
                Toast.makeText(MainActivity.this,""+total_price,Toast.LENGTH_SHORT).show();
                total.setText("Total: "+total_price);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}