package com.example.tuhin.android03_newactivitysendreceivedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// Variable declaration -> EditText, TextView, Button
// Initialization of variables -> EditText, TextView, Button
// Intent -> sent text receiving setup
// Button -> click event
// Intent -> reply setup

public class DisplayActivity extends AppCompatActivity {

    // Variable declaration
    TextView tvName, tvEmail, tvMobile, tvReplyMessage;
    EditText etReplyMessage;
    Button btnReply, btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //Initialization of variables
        tvName   = (TextView) findViewById(R.id.lblName);
        tvEmail  = (TextView) findViewById(R.id.lblEmail);
        tvMobile = (TextView) findViewById(R.id.lblMobile);
        etReplyMessage = (EditText) findViewById(R.id.txtReplyMessage);
        btnReply = (Button) findViewById(R.id.buttonReply);
        btnClose = (Button) findViewById(R.id.buttonClose);

        // sent text receiving setup
        String rName, rEmail, rMobile;
        rName   = "Name: " + getIntent().getStringExtra("nameKey");
        rEmail  = "Email: " + getIntent().getStringExtra("emailKey");
        rMobile = "Mobile: " + getIntent().getStringExtra("mobileKey");

        tvName.setText(rName);
        tvEmail.setText(rEmail);
        tvMobile.setText(rMobile);

        // Reply button event
        btnReply.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String replyMessage = etReplyMessage.getText().toString();
                        Intent intentReply = new Intent();
                        if(replyMessage.length() == 0) {
                            intentReply.putExtra("replyKey", "No any reply found.");
                        } else {
                            intentReply.putExtra("replyKey", replyMessage);
                        }
                        setResult(1, intentReply);
                        finish();
                    }
                }
        );

        // Close button event
        btnClose.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
    }
}
