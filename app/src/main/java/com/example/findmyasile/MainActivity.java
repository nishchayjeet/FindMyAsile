package com.example.findmyasile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }

    public void sample(View view) {
        intent = new Intent(this, getStarted.class);
        startActivity(intent);

    }

    public void login(View view) {
        intent = new Intent(this, login.class);
        startActivity(intent);

    }
}
