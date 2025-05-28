package com.example.primbonapp;


import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResult = findViewById(R.id.tvResult);

        String nama = getIntent().getStringExtra("NAMA");
        String tanggal = getIntent().getStringExtra("TANGGAL");
        String weton = getIntent().getStringExtra("WETON");

        String ramalan = getRamalan(weton);

        String hasil = "Nama: " + nama + "\n" +
                "Tanggal Lahir: " + tanggal + "\n" +
                "Weton: " + weton + "\n\n" +
                "Ramalan:\n" + ramalan;

        tvResult.setText(hasil);
    }

    private String getRamalan(String weton) {
        switch (weton) {
            case "Legi":
                return "Orangnya rajin, cerdas dan punya banyak rezeki.";
            case "Pahing":
                return "Bijaksana dan disegani orang banyak.";
            case "Pon":
                return "Tegas dan pekerja keras.";
            case "Wage":
                return "Pendiam, tapi tajam dalam berpikir.";
            case "Kliwon":
                return "Berwibawa dan memiliki aura pemimpin.";
            default:
                return "Tidak diketahui.";
        }
    }
}
