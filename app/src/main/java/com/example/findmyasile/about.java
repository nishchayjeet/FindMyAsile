package com.example.findmyasile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle("About App");

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.nav_about);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {

                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), getStarted.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_search:
                        startActivity(new Intent(getApplicationContext(), Main2Activity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_list:
                        startActivity(new Intent(getApplicationContext(), myList.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nav_about:

                        return true;


                }
                return false;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {


            case R.id.nav_settings:
                FirebaseAuth.getInstance().signOut();
                Intent Tologin = new Intent(about.this, login.class);
                startActivity(Tologin);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}