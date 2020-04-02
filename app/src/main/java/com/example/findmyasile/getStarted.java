package com.example.findmyasile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class getStarted extends AppCompatActivity {
    Intent intent;
    Button btnlogout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
        btnlogout = findViewById(R.id.button6);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent Tologin = new Intent(getStarted.this, login.class);
                startActivity(Tologin);
            }
        });
    }


    public void click(View view) {
        Toast toast=Toast.makeText(this,"Hello",Toast.LENGTH_LONG);
        toast.show();
        intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void add(View view) {
        intent = new Intent(this, myList.class);
        startActivity(intent);
    }
}
