package com.example.digitalcard;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditDataScreen extends AppCompatActivity {

    private FloatingActionButton saveButton, editScreenButton;
//    private String fullName;
    private TextView fullNameTextview,designationTextview,companyText,aboutUserTextview,userNumberTextview,userWhatsappTextview,userEmailTextview,userAddressTextview,userServiceTextview;

    private RelativeLayout headerBox,contentBox,mainViewBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_data_screen);
        initBindings();



    }

    public void initBindings(){

        saveButton = findViewById(R.id.floatingButton_download);
        editScreenButton = findViewById(R.id.floatingButton_edit);
        fullNameTextview = findViewById(R.id.user_name);
        designationTextview = findViewById(R.id.user_designation);
        companyText = findViewById(R.id.user_company);
        aboutUserTextview = findViewById(R.id.user_about_me);
        userNumberTextview = findViewById(R.id.user_contact);
        userWhatsappTextview = findViewById(R.id.user_whatsapp);
        userEmailTextview = findViewById(R.id.user_email);
        userAddressTextview = findViewById(R.id.user_address);
        userServiceTextview = findViewById(R.id.user_service_text);
        headerBox = findViewById(R.id.relative1);
        contentBox = findViewById(R.id.relative2);
        mainViewBox = findViewById(R.id.mainRelative);

    }
}