package com.example.primbonapp;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    DatePicker datePicker;
    Spinner spinnerWeton;
    Button btnRamalkan;

    String[] wetonList = {"Legi", "Pahing", "Pon", "Wage", "Kliwon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        datePicker = findViewById(R.id.datePicker);
        spinnerWeton = findViewById(R.id.spinnerWeton);
        btnRamalkan = findViewById(R.id.btnRamalkan);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, wetonList);
        spinnerWeton.setAdapter(adapter);

        btnRamalkan.setOnClickListener(v -> {
            String nama = etName.getText().toString();
            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth() + 1;
            int year = datePicker.getYear();
            String weton = spinnerWeton.getSelectedItem().toString();

            String tanggal = day + "-" + month + "-" + year;

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("NAMA", nama);
            intent.putExtra("TANGGAL", tanggal);
            intent.putExtra("WETON", weton);
            startActivity(intent);
        });
    }
}
