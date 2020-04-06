package com.example.findmyasile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  Toast.makeText(add_item.this,"Item Added In Server",Toast.LENGTH_SHORT).show();

                String Pname = InputName.getText().toString();
                String Pasile = inputAsile.getText().toString();

                String key =ref.push().getKey();
                ref.child(key).child("Pname").setValue(Pname);
                ref.child(key).child("Pasile").setValue(Pasile);



                Query query= ref.child("Products").orderByChild("Pname");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds:dataSnapshot.getChildren()){
                            Map map= (Map) ds.getValue();
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
}
