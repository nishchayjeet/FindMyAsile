package com.example.findmyasile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class add_item extends AppCompatActivity {

    private Button BtnSave;
    private EditText inputAsile, InputName;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        setTitle("Add New Item");


        InputName = findViewById(R.id.editText5);
        inputAsile = findViewById(R.id.editText7);


        BtnSave = findViewById(R.id.button6);

        ref = FirebaseDatabase.getInstance().getReference().child("Products");

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.nav_home);

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
                        startActivity(new Intent(getApplicationContext(), about.class));
                        overridePendingTransition(0, 0);
                        return true;


                }
                return false;
            }
        });
        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  Toast.makeText(add_item.this,"Item Added In Server",Toast.LENGTH_SHORT).show();

                String Pname = InputName.getText().toString();
                String Pasile = inputAsile.getText().toString();

                String key = ref.push().getKey();
                ref.child(key).child("Pname").setValue(Pname);
                ref.child(key).child("Pasile").setValue(Pasile);


                Query query = ref.child("Products").orderByChild("Pname");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            Map map = (Map) ds.getValue();
                            String getname = (String) map.get("Pasile");

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


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
                Intent Tologin = new Intent(add_item.this, login.class);
                startActivity(Tologin);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
