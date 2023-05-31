package com.t.firebasedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    EditText userId,name,email;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userId = findViewById(R.id.userId);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        button = findViewById(R.id.button);
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }


    public void writeNewUser(){
        User user = new User(userId.getText().toString(),
                name.getText().toString(),
                email.getText().toString());
        mDatabase.child(user.getUserId()).setValue(user);

    }

    public void sendData(View view) {
        writeNewUser();
        Toast.makeText(getApplicationContext(),"Data Sent",Toast.LENGTH_SHORT).show();
    }
}