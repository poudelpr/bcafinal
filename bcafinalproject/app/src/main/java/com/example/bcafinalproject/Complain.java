package com.example.bcafinalproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Complain extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView uploadArea;
    private Uri imageUri;

    private EditText titleEditText;
    private Spinner typeSpinner;
    private EditText descriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);

        // Initialize form fields
        titleEditText = findViewById(R.id.titleview);
        typeSpinner = findViewById(R.id.type_spinner);
        descriptionEditText = findViewById(R.id.descriptionbox);

        // Set up the Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);

        // Set up the upload button
        ImageView uploadBtn = findViewById(R.id.uploadbtn);
        uploadArea = findViewById(R.id.uploadarea);
        uploadBtn.setOnClickListener(v -> openFileChooser());

        // Set up the Next button
        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(v -> {
            if (validateForm()) {
                Intent intent = new Intent(Complain.this, NextComplain.class);
                startActivity(intent);
            }
        });
    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            uploadArea.setImageURI(imageUri);
        }
    }

    private boolean validateForm() {
        String title = titleEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();

        if (TextUtils.isEmpty(title)) {
            titleEditText.setError("Title is required");
            titleEditText.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(description)) {
            descriptionEditText.setError("Description is required");
            descriptionEditText.requestFocus();
            return false;
        }

        if (imageUri == null) {
            Toast.makeText(this, "Please upload an image", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}

