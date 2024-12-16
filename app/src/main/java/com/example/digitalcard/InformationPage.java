package com.example.digitalcard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import de.hdodenhof.circleimageview.CircleImageView;


public class InformationPage extends AppCompatActivity {

    private CircleImageView profile_image;
    private TextInputLayout fullName,designation,company,aboutMe,contactNumber,email,address,service;
    private TextInputEditText fullName_content,designation_content,company_content,aboutMe_content,contactNumber_content,email_content,address_content,service_content;
    private RadioGroup radioGroup;
    private RadioButton isWhatsapp,isNotWhatsapp;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_information_page);
        initBinding();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformationPage.this,EditDataScreen.class);
                startActivity(intent);
            }
        });
    }

    public void initBinding(){
        profile_image = findViewById(R.id.profile_image);

        fullName = findViewById(R.id.fullName);
        designation = findViewById(R.id.designation);
        company = findViewById(R.id.company);
        aboutMe = findViewById(R.id.aboutMe);
        contactNumber = findViewById(R.id.contactNumber);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        service = findViewById(R.id.service);

        fullName_content = findViewById(R.id.fullName_content);
        designation_content = findViewById(R.id.designation_content);
        company_content = findViewById(R.id.company_content);
        aboutMe_content = findViewById(R.id.aboutMe_content);
        contactNumber_content = findViewById(R.id.contactNumber_content);
        email_content = findViewById(R.id.email_content);
        address_content = findViewById(R.id.address_content);
        service_content = findViewById(R.id.service_content);

        radioGroup =findViewById(R.id.radioGroup);
        isWhatsapp =findViewById(R.id.isWhatsapp);
        isNotWhatsapp =findViewById(R.id.isNotWhatsapp);
        nextButton =findViewById(R.id.nextButton);

    }
}