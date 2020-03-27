package com.example.findmyasile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Main2Activity extends AppCompatActivity {
EditText ed1;
TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ed1=findViewById(R.id.editText);
        tv1=findViewById(R.id.textView2);
        FirebaseDatabase abc= FirebaseDatabase.getInstance();
         DatabaseReference db=abc.getReference();
         c1 obj=new c1("coke","20");
       // db.child("Products").push().setValue(obj);



    }

    public void search(View view) {
        FirebaseDatabase abc= FirebaseDatabase.getInstance();
        DatabaseReference db=abc.getReference();
       Query query= db.child("Products").orderByChild("Pname").equalTo(ed1.getText().toString());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){
                  Map map= (Map) ds.getValue();
                  String getname = (String) map.get("Pasile");
                  tv1.setText(getname);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
class c1{
    public String Pname,Pasile;

    public c1(String pname, String pasile) {
        Pname = pname;
        Pasile = pasile;
    }
}