package com.example.digitalcard;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditDataScreen extends AppCompatActivity {

    private FloatingActionButton saveButton, editScreenButton;

    private TextView fullNameTextview, designationTextview, companyText, aboutUserTextview, userNumberTextview, userWhatsappTextview, userEmailTextview, userAddressTextview, userServiceTextview;

    private RelativeLayout headerBox, contentBox, mainViewBox;

    private String fullName;
    private static final int REQUEST_CODE_PERMISSIONS = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_data_screen);
        initBindings();
        getData();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveImage();
            }
        });

        editScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customEditBox();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    String getFilePath() {
        File f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        String path = f.getPath() + "/MyCard";
        File filePath = new File(path);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        return path;
    }

    void saveImage() {
        Bitmap bitmap = Bitmap.createBitmap(mainViewBox.getWidth(), mainViewBox.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        mainViewBox.draw(canvas);

        String path = getFilePath();
        String finalPath = path + "/" + "card.jpg";
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(finalPath))) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            Toast.makeText(EditDataScreen.this,"Successfully Download",Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving image: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }



    public void initBindings() {

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

    void getData() {
        Intent intent = getIntent();
        if (intent != null) {
            String imagePath = intent.getStringExtra("profilePicturePath");

            if (imagePath != null) {
                File imageFile = new File(imagePath);
                if (imageFile.exists()) {
                    Bitmap profilePicture = BitmapFactory.decodeFile(imagePath);
                    CircleImageView profileImageView = findViewById(R.id.user_profile);
                    profileImageView.setImageBitmap(profilePicture);
                } else {
                    Toast.makeText(EditDataScreen.this, "", Toast.LENGTH_SHORT).show();
                }
                fullName = intent.getStringExtra("fullName");
                String designation = intent.getStringExtra("designation");
                String company = intent.getStringExtra("company");
                String aboutMe = intent.getStringExtra("aboutMe");
                String contact = intent.getStringExtra("contactNumber");
                String whatsappNumber = intent.getStringExtra("selected");
                String email = intent.getStringExtra("email");
                String address = intent.getStringExtra("address");
                String services = intent.getStringExtra("serviceInfo");

                fullNameTextview.setText(fullName);
                designationTextview.setText(designation);
                companyText.setText(company);
                aboutUserTextview.setText(aboutMe);
                userNumberTextview.setText(contact);
                userWhatsappTextview.setText(whatsappNumber);
                userEmailTextview.setText(email);
                userAddressTextview.setText(address);
                userServiceTextview.setText(services);

            }
        }
    }

    public void customEditBox() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_dialog_box);

        LinearLayout blackColor = dialog.findViewById(R.id.blackColor);
        LinearLayout rosePinkColor = dialog.findViewById(R.id.rosePinkColor);
        LinearLayout beaverColor = dialog.findViewById(R.id.beaverColor);
        LinearLayout splashColor = dialog.findViewById(R.id.splashColor);
        LinearLayout darkPurpleColor = dialog.findViewById(R.id.darkPurpleColor);
        LinearLayout pacificCyanColor = dialog.findViewById(R.id.pacificCyanColor);

        LinearLayout bg1 = dialog.findViewById(R.id.bg1);
        LinearLayout bg2 = dialog.findViewById(R.id.bg2);
        LinearLayout bg3 = dialog.findViewById(R.id.bg3);
        LinearLayout bg4 = dialog.findViewById(R.id.bg4);
        LinearLayout bg5 = dialog.findViewById(R.id.bg5);
        LinearLayout bg6 = dialog.findViewById(R.id.bg6);
        TextView fontStyle1 = dialog.findViewById(R.id.fontStyle1);
        TextView fontStyle2 = dialog.findViewById(R.id.fontStyle2);
        TextView fontStyle3 = dialog.findViewById(R.id.fontStyle3);
        TextView fontStyle4 = dialog.findViewById(R.id.fontStyle4);
        TextView fontStyle5 = dialog.findViewById(R.id.fontStyle5);
        TextView fontStyle6 = dialog.findViewById(R.id.fontStyle6);
        TextView fontStyle7 = dialog.findViewById(R.id.fontStyle7);
        TextView fontStyle8 = dialog.findViewById(R.id.fontStyle8);
        TextView fontStyle9 = dialog.findViewById(R.id.fontStyle9);

        Button cancelButton = dialog.findViewById(R.id.cancelButton);
        Button resetButton = dialog.findViewById(R.id.resetButton);

        fontStyle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.style1);
            }
        });
        fontStyle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.style2);
            }
        });
        fontStyle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.style3);
            }
        });
        fontStyle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.style4);
            }
        });
        fontStyle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.style5);
            }
        });
        fontStyle6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.style6);
            }
        });
        fontStyle7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.style7);
            }
        });
        fontStyle8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.style8);
            }
        });
        fontStyle9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.style9);
            }
        });


        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(R.font.defaultstyle);
                headerBox.setBackgroundColor(getColor(R.color.splash));
                contentBox.setBackground(getDrawable(R.color.white));
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        blackColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headerBox.setBackgroundColor(getColor(R.color.black));
            }
        });
        splashColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headerBox.setBackgroundColor(getColor(R.color.splash));
            }
        });
        beaverColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headerBox.setBackgroundColor(getColor(R.color.beaver));
            }
        });
        darkPurpleColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headerBox.setBackgroundColor(getColor(R.color.darkPurple));
            }
        });
        rosePinkColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headerBox.setBackgroundColor(getColor(R.color.rosePink));
            }
        });
        pacificCyanColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headerBox.setBackgroundColor(getColor(R.color.pacificCyan));
            }
        });

        bg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentBox.setBackground(getDrawable(R.drawable.bg1));
            }
        });

        bg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentBox.setBackground(getDrawable(R.drawable.bg2));
            }
        });
        bg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentBox.setBackground(getDrawable(R.drawable.bg3));
            }
        });
        bg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentBox.setBackground(getDrawable(R.drawable.bg4));
            }
        });
        bg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentBox.setBackground(getDrawable(R.drawable.bg5));
            }
        });
        bg6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentBox.setBackground(getDrawable(R.drawable.bg6));
            }
        });

        dialog.show();
    }
    void setText(int font ){
        fullNameTextview.setTypeface(ResourcesCompat.getFont(EditDataScreen.this,font));
        designationTextview.setTypeface(ResourcesCompat.getFont(EditDataScreen.this,font));
        companyText.setTypeface(ResourcesCompat.getFont(EditDataScreen.this,font));

    }
}
