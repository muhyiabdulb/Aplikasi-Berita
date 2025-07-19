package com.example.aplikasiberita;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasiberita.helper.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    Button btnDaftar, btnMasuk;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtEmail = findViewById(R.id.regEmail);
        edtPassword = findViewById(R.id.regPassword);
        btnDaftar = findViewById(R.id.regbtnRegister);
        btnMasuk = findViewById(R.id.regbtnLogin);
        dbHelper = new DatabaseHelper(this);

        btnDaftar.setOnClickListener(v -> {
            String email = edtEmail.getText().toString();
            String password = edtPassword.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Isi semua field!", Toast.LENGTH_SHORT).show();
            } else if (dbHelper.isUserExists(email)) {
                Toast.makeText(this, "Email sudah terdaftar!", Toast.LENGTH_SHORT).show();
            } else {
                boolean result = dbHelper.registerUser(email, password);
                if (result) {
                    Toast.makeText(this, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show();
                    finish(); // Kembali ke Login
                } else {
                    Toast.makeText(this, "Registrasi Gagal!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMasuk.setOnClickListener(v ->
                startActivity(new Intent(this, LoginActivity.class)));

    }
}

