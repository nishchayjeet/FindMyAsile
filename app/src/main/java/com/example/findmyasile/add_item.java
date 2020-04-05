package com.example.findmyasile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Pname = InputName.getText().toString();
                String Pasile = inputAsile.getText().toString();

                String key =ref.push().getKey();
                ref.child(key).child("Pname").setValue(Pname);
                ref.child(key).child("Pasile").setValue(Pasile);




            }
        });

    }
}
