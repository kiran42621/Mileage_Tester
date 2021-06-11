package com.example.mileagetester;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button Check,Clear,Useage;
    private EditText OldReading,NewReading,RefuelPrice,FuelPrice;
    public Double Mileage;
    public String Text = "ABCD\nEFGH\nIJKL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Check = (Button) findViewById(R.id.btnCheck);
        Clear = (Button)findViewById(R.id.btnClear);
        Useage = (Button)findViewById(R.id.btnUse);

        OldReading = (EditText)findViewById(R.id.txtOldReading);
        NewReading = (EditText)findViewById(R.id.txtNewReading);
        RefuelPrice = (EditText)findViewById(R.id.txtRefuledAmount);
        FuelPrice = (EditText)findViewById(R.id.txtFuelAmount);

        Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (OldReading.getText().toString().equals("") || NewReading.getText().toString().equals("") || RefuelPrice.getText().toString().equals("") || FuelPrice.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "All Fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    OldReading.getText().toString();
                    NewReading.getText().toString();
                    RefuelPrice.getText().toString();
                    FuelPrice.getText().toString();
                    Double kms1 = Double.valueOf(OldReading.getText().toString());
                    Double kms2 = Double.valueOf(NewReading.getText().toString());
                    Double kms;
                    kms = kms2 - kms1;

                    Double price = Double.valueOf(RefuelPrice.getText().toString());
                    Double fprice = Double.valueOf(FuelPrice.getText().toString());

                    Mileage = (fprice * kms) / price;

                    showResult();
                }
            }



            public void showResult() {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Information")
                        .setMessage("The Approximate Mileage of your vehicle is " + Mileage + ".")
                        .setPositiveButton("OK", null)
                        .show();

                Button PositiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                PositiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Thanks for using our app", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

            }





        });

        Useage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }

            public void showDialog() {
                AlertDialog dialogs = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Information")
                        .setMessage(Text)
                        .setPositiveButton("OK", null)
                        .show();

                Button PositiveButton = dialogs.getButton(AlertDialog.BUTTON_POSITIVE);
                PositiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Thanks for using our app", Toast.LENGTH_SHORT).show();
                        dialogs.dismiss();
                    }
                });

            }
        });

        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OldReading.setText("");
                NewReading.setText("");
                FuelPrice.setText("");
                RefuelPrice.setText("");
            }
        });


    }
}