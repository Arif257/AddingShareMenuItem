package com.arif.addingsharemenuitem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedBackActivity extends AppCompatActivity implements View.OnClickListener {
    private Button sendButton, clearButton;
    private EditText nameEditText, messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        sendButton = findViewById(R.id.sendButtonId);
        clearButton = findViewById(R.id.clearButtonId);

        nameEditText = findViewById(R.id.nameEditTextId);
        messageEditText = findViewById(R.id.messageEditTextId);

        sendButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        try {
            String name = nameEditText.getText().toString();
            String message = messageEditText.getText().toString();
            if (v.getId() == R.id.sendButtonId) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"arifemran018@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"FeedBack from app");
                intent.putExtra(Intent.EXTRA_TEXT, "Name : " + name + "\n Message:" + message);
                startActivity(Intent.createChooser(intent, "feedback with "));


            } else if (v.getId() == R.id.clearButtonId) {
                nameEditText.setText("");
                messageEditText.setText("");

            }

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Exception : "+e,Toast.LENGTH_SHORT).show();

        }


    }
}