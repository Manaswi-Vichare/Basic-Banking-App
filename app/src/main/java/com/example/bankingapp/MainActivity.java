package com.example.bankingapp;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageButton transfer,history;
    TextView transferLabel,historyLabel;
    public void onHome(View view){
    }
    public void onBack(View view){
    }
    public void startAnimate(){
        transfer.animate().translationXBy(800).setDuration(0).withEndAction(() -> transfer.animate().translationXBy(-800).setDuration(500));
        transferLabel.animate().translationXBy(800).setDuration(0).withEndAction(() -> transferLabel.animate().translationXBy(-800).setDuration(500));
        history.animate().translationXBy(-800).setDuration(0).withEndAction(() -> history.animate().translationXBy(800).setDuration(500));
        historyLabel.animate().translationXBy(-800).setDuration(0).withEndAction(() -> historyLabel.animate().translationXBy(800).setDuration(500));
    }
    public void viewCustomerList(View view){
        Intent customerList = new Intent(getApplicationContext(),UserListActivity.class);
        customerList.putExtra("SenderID","");
        startActivity(customerList);
    }
    public void viewTransactionHistory(View view){
        Intent transact = new Intent(getApplicationContext(),History.class);
        startActivity(transact);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transfer = findViewById(R.id.transferImgButton);
        history = findViewById(R.id.historyImgButton);
        transferLabel = findViewById(R.id.transferButtonText);
        historyLabel = findViewById(R.id.historyButtonText);
        startAnimate();
        SQLiteDatabase myDataBase = this.openOrCreateDatabase("customers", Context.MODE_PRIVATE,null);
        //myDataBase.execSQL("DROP TABLE customers");
        myDataBase.execSQL("CREATE TABLE IF NOT EXISTS customers(custid VARCHAR PRIMARY KEY, name VARCHAR, email VARCHAR, phn INT(10), bank VARCHAR, balance DOUBLE)");
        //myDataBase.execSQL("DROP TABLE transitions");
        /*myDataBase.execSQL("CREATE TABLE IF NOT EXISTS transitions(transitionid VARCHAR PRIMARY KEY, sender VARCHAR, receiver VARCHAR, amount VARCHAR, status VARCHAR)");
        myDataBase.execSQL("INSERT INTO customers VALUES('A01','Manaswi', 'manaswi@gmail.com',1234567891,'ICICI Bank',10000.00)");
        myDataBase.execSQL("INSERT INTO customers VALUES('A02','Shruti', 'shruti@gmail.com',2345678912,'SBI Bank',20000.50)");
        myDataBase.execSQL("INSERT INTO customers VALUES('A03','Aditi', 'Aditi@gmail.com',3456789123,'HDFC Bank',10000.00)");
        myDataBase.execSQL("INSERT INTO customers VALUES('A04','Archana', 'Archana@gmail.com',4567891234,'ICICI Bank',10000.00)");
        myDataBase.execSQL("INSERT INTO customers VALUES('A05','Jennie', 'Jennie@gmail.com',5678912345,'Axis Bank',25000.50)");
        myDataBase.execSQL("INSERT INTO customers VALUES('A06','Melissa', 'Melissa@gmail.com',6789123456,'Axis Bank',20000.00)");
        myDataBase.execSQL("INSERT INTO customers VALUES('A07','Sara', 'Sara@gmail.com',7891234567,'HDFC Bank',50000.00)");
        myDataBase.execSQL("INSERT INTO customers VALUES('A08','Aalia', 'Aalia@gmail.com',8912345678,'SBI Bank',45000.50)");
        myDataBase.execSQL("INSERT INTO customers VALUES('A09','Priyanka', 'Priyanka@gmail.com',9123456789,'PNB Bank',90000.00)");
        myDataBase.execSQL("INSERT INTO customers VALUES('A10','Lisa', 'Lisa@gmail.com',1234567890,'ICICI Bank',30000.75)");
        */
    }
}