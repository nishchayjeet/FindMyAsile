package com.example.findmyasile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;


public class myList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<String> moviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        moviesList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(moviesList);

  //     recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);


        moviesList.add("Air Freshner");
        moviesList.add("Alluminuim Foil");
        moviesList.add("Apple Cider");
        moviesList.add("Apple Sauce");
        moviesList.add("Artificial Sweatner");
        moviesList.add("Bacon");
        moviesList.add("Baking Cups");
        moviesList.add("Baking Soda");
        moviesList.add("Bathroom Cleaner");
        moviesList.add("Toilet Paper");
        moviesList.add("BBQ Sauce");
        moviesList.add("Beef");
        moviesList.add("Beans");
        moviesList.add("Bear");
        moviesList.add("Bird Food");
      

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                Intent i = new Intent(myList.this , getStarted.class);
                startActivity(i);
                return true;

            case R.id.nav_search:
                Intent j = new Intent(myList.this , Main2Activity.class);
                startActivity(j);
                return true;

            case R.id.nav_list:
                Intent k = new Intent(myList.this, myList.class);
                startActivity(k);
                return true;

            case R.id.nav_settings:
                FirebaseAuth.getInstance().signOut();
                Intent Tologin = new Intent(myList.this, login.class);
                startActivity(Tologin);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
