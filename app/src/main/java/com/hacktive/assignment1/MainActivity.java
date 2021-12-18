package com.hacktive.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText komentar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        komentar = findViewById(R.id.et_teks);
    }

    // Ambil data yang tersimpan di onResume()
    // saat aplikasi terbuka kembali

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String input = sh.getString("komentar", "");
        komentar.setText(input);
    }

    // Simpan data di SharedPreference dalam metode onPause()
    // saat pengguna menutup aplikasi

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("komentar", komentar.getText().toString());
        myEdit.apply();
    }
}