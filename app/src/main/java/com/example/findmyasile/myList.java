package com.example.findmyasile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
}
