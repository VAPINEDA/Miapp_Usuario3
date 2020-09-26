package com.example.victoralfonso.miapp_usuario;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextInputEditText et_nombre;
    TextInputEditText et_fecha;
    TextInputEditText et_telefono;
    EditText et_email;
    EditText et_descripcion;
    Calendar miCalendario=Calendar.getInstance();
    Button btn_siguiente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre=(TextInputEditText) findViewById(R.id.et_Nombre);
        et_fecha=(TextInputEditText) findViewById(R.id.et_fecha);
        et_telefono=(TextInputEditText)findViewById(R.id.et_telefono);
        et_email=findViewById(R.id.et_email);
        et_descripcion=findViewById(R.id.et_descripcion);
        btn_siguiente=findViewById(R.id.bt_siguiente);

        SharedPreferences preferencias=getSharedPreferences("Datos", Context.MODE_PRIVATE);
        et_nombre.setText(preferencias.getString("NOMBRE", ""));
        et_fecha.setText(preferencias.getString("FECHA", ""));
        et_telefono.setText(preferencias.getString("TELEFONO", ""));
        et_email.setText(preferencias.getString("EMAIL", ""));
        et_descripcion.setText(preferencias.getString("DESCRIPCION", ""));

        et_fecha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new DatePickerDialog(MainActivity.this, date, miCalendario.get(Calendar.YEAR), miCalendario.get(Calendar.MONTH), miCalendario.get(Calendar.DAY_OF_MONTH)).show();
                }
            });

            btn_siguiente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences pref=getSharedPreferences("Datos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=pref.edit();

                    editor.putString("NOMBRE", et_nombre.getText().toString());
                    editor.putString("FECHA", et_fecha.getText().toString());
                    editor.putString("TELEFONO", et_telefono.getText().toString());
                    editor.putString("EMAIL", et_email.getText().toString());
                    editor.putString("DESCRIPCION", et_descripcion.getText().toString());

                    String nombre = et_nombre.getText().toString();
                    String fecha = et_fecha.getText().toString();
                    String telefono = et_telefono.getText().toString();
                    String email = et_email.getText().toString();
                    String descripcion = et_descripcion.getText().toString();

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("NOMBRE", nombre);
                    intent.putExtra("FECHA", fecha);
                    intent.putExtra("TELEFONO", telefono);
                    intent.putExtra("EMAIL", email);
                    intent.putExtra("DESCRIPCION", descripcion);
                    startActivity(intent);
                    editor.commit();
                    finish();
                }
            });



    }

    DatePickerDialog.OnDateSetListener date= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            miCalendario.set(Calendar.DAY_OF_MONTH, day);
            miCalendario.set(Calendar.MONTH, month);
            miCalendario.set(Calendar.YEAR, year);
            final int mes=month+1;
            String diaFormateado=(day<10)? 0 + String.valueOf(day):String.valueOf(day);
            String mesFormateado=(month<10)?0+ String.valueOf(mes):String.valueOf(mes);
            et_fecha.setText(diaFormateado+"/"+mesFormateado+"/"+year);
        }
    };




}