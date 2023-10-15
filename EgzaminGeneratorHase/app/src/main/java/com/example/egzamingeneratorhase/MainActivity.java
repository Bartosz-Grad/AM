package com.example.egzamingeneratorhase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    String[] stanowiska = {"Kierownik", "Starszy programista", "Młodszy programista", "Tester"};
    String bigLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String specialCharacters = " !@#$%^&*()_+-=";
    String numbers = "1234567890";
    String password;
    String message;
    private EditText editName;
    private EditText editForename;
    private Spinner stanowisko;
    private EditText editZnaki;
    private CheckBox checkBigSmall;
    private CheckBox checkNumbers;
    private CheckBox checkSpecial;
    private Button buttonGenerate;
    private Button buttonConfirm;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.stanowisko);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, stanowiska);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        editName = findViewById(R.id.editName);
        editForename = findViewById(R.id.editForename);
        stanowisko = findViewById(R.id.stanowisko); //spinner
        editZnaki = findViewById(R.id.editZnaki);
        checkBigSmall = findViewById(R.id.checkBigSmall);
        checkNumbers = findViewById(R.id.checkNumbers);
        checkSpecial = findViewById(R.id.checkSpecial);
        buttonGenerate = findViewById(R.id.buttonGenerate);
        buttonConfirm = findViewById(R.id.buttonConfirm);

        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String allowedCharacters = "abcdefghijklmnopqrstuvwxyz";
                String imie = editName.getText().toString();
                String nazwisko = editForename.getText().toString();
                String selectedValue = stanowisko.getSelectedItem().toString();
                int number = Integer.parseInt(editZnaki.getText().toString());
                boolean isCheckedLetters = checkBigSmall.isChecked();
                boolean isCheckedNumbers = checkNumbers.isChecked();
                boolean isCheckedSpecial= checkSpecial.isChecked();

                if (isCheckedLetters)
                    allowedCharacters += bigLetters;
                if (isCheckedNumbers)
                    allowedCharacters += numbers;
                if (isCheckedSpecial)
                    allowedCharacters += specialCharacters;

                char[] generatePassword = generatePassword(allowedCharacters, 8);
                password = String.valueOf(generatePassword);
                message = "Dane pracownika: " + imie + " " + nazwisko + " " + selectedValue + " Hasło: " +  password;

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Haslo")
                        .setMessage(password)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                dialog = builder.create();
                dialog.show();
            }
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(message)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                dialog = builder.create();
                dialog.show();
            }
        });
        }


    public static char[] generatePassword(String allowedCharacters, int length) {
        String characters = allowedCharacters;
        Random random = new Random();
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            password[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return password;
    }
}