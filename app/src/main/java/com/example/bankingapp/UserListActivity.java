package com.example.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {
    ListView list;
    ImageButton back,home;
    public void startAnimate(){
        list.animate().translationYBy(2000).setDuration(0).withEndAction(() -> list.animate().translationYBy(-2000).setDuration(500));
        back.animate().translationXBy(-800).setDuration(0).withEndAction(() -> back.animate().translationXBy(800).setDuration(500));
        home.animate().translationXBy(-800).setDuration(0).withEndAction(() -> home.animate().translationXBy(800).setDuration(500));
    }
    public void onBack(View view){
        finish();
    }
    public void onHome(View view){
        Intent homepage = new Intent(getApplicationContext(),MainActivity.class);
        homepage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homepage);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_user_list);
        list = findViewById(R.id.listView);
        back = findViewById(R.id.backButton1);
        home = findViewById(R.id.homeImgbutton);
        SQLiteDatabase myDatabase = this.openOrCreateDatabase("customers", Context.MODE_PRIVATE,null);
        @SuppressLint("Recycle") Cursor c = myDatabase.rawQuery("SELECT * FROM customers",null);
        int nameInd = c.getColumnIndex("name");
        int balInd = c.getColumnIndex("balance");
        int idInd = c.getColumnIndex("custid");
        c.moveToFirst();
        ArrayList<User> custList = new ArrayList<>();
        ArrayList<String> custID = new ArrayList<>();
        while(!c.isAfterLast()){
            custList.add(new User(c.getString(nameInd),c.getString(balInd)));
            custID.add(c.getString(idInd));
            c.moveToNext();
        }
        ListAdapter adapter = new ListAdapter(this,R.layout.act_view,custList);
        list.setAdapter(adapter);
        startAnimate();
        Intent parent = this.getIntent();
        String senderID = parent.getStringExtra("SenderID");
        String senderName = parent.getStringExtra("SenderName");
        list.setOnItemClickListener((parent1, view, position, id) -> {
            if(senderID.equals("")) {
                Intent CustomerDetails = new Intent(getApplicationContext(), UserProfile.class);
                CustomerDetails.putExtra("customerID", custID.get(position));
                startActivity(CustomerDetails);
            }
            else{
                String receiverID = custID.get(position);
                if(senderID.equals(receiverID)){
                    Toast.makeText(UserListActivity.this, "Sender and receiver can not be same", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent transferPage = new Intent(getApplicationContext(),Transfer.class);
                    transferPage.putExtra("ReceiverID",receiverID);
                    transferPage.putExtra("SenderID",senderID);
                    transferPage.putExtra("ReceiverName",custList.get(position).name);
                    transferPage.putExtra("SenderName",senderName);
                    startActivity(transferPage);
                    finish();
                }
            }
        });
    }
}