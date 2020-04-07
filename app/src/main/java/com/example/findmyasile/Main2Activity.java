package com.example.findmyasile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
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

public class Main2Activity extends AppCompatActivity   {
EditText ed1;
TextView tv1;


  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Search Your Items");

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.nav_search);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),getStarted.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_search:

                        return true;

                    case R.id.nav_list:
                        startActivity(new Intent(getApplicationContext(),myList.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_about:
                        startActivity(new Intent(getApplicationContext(),about.class));
                        overridePendingTransition(0,0);
                        return true;




                }
                return false;
            }
        });



        ed1=findViewById(R.id.editText);
        tv1=findViewById(R.id.textView2);

        FirebaseDatabase abc= FirebaseDatabase.getInstance();
         DatabaseReference db=abc.getReference();

         //c1 obj=new c1("honey","10&11");
     //     db.child("Products").push().setValue(obj);

    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }}


    public void search(View view) {
        closeKeyboard();

        FirebaseDatabase abc= FirebaseDatabase.getInstance();
        DatabaseReference db=abc.getReference();

        Query query= db.child("Products").orderByChild("Pname").equalTo(ed1.getText().toString().toLowerCase());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){

                    Map map= (Map) ds.getValue();

                    String getname = (String) map.get("Pasile");
                    String asile = (String) map.get("Pname");

                    if (ds.exists() == true)
                    {
                        tv1.setText(asile+ " " + "in" + " " + getname + " Asile");
                    }
                    else
                    {
                        tv1.setText("Item Not Found");
                        Toast.makeText(Main2Activity.this," Item Not Found ",Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
        switch (item.getItemId()){


            case R.id.nav_settings:
                FirebaseAuth.getInstance().signOut();
                Intent Tologin = new Intent(Main2Activity.this, login.class);
                startActivity(Tologin);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

}


class c1{
    public String Pname,Pasile;

    public c1(String pname, String pasile) {
        Pname = pname;
        Pasile = pasile;
    }


}