package com.example.findmyasile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        Toast toast=Toast.makeText(this,"maa chudao",Toast.LENGTH_LONG);
        toast.show();
       intent = new Intent(this, Main2Activity.class);
       startActivity(intent);
    }

    public void add(View view) {
        intent = new Intent(this, List.class);
        startActivity(intent);
    }
}
