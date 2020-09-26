package com.example.victoralfonso.miapp_usuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView tv_nombre;
    TextView tv_fecha;
    TextView tv_telefono;
    TextView tv_email;
    TextView tv_descripcion;
    Button btn_Editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extra=getIntent().getExtras();
        String nombre=extra.getString("NOMBRE");
        String fecha=extra.getString("FECHA");
        String tele=extra.getString("TELEFONO");
        String email=extra.getString("EMAIL");
        String desc=extra.getString("DESCRIPCION");


        tv_nombre=findViewById(R.id.nombre2);
        tv_fecha=findViewById(R.id.fecha2);
        tv_telefono=findViewById(R.id.et_telefono2);
        tv_email=findViewById(R.id.et_email2);
        tv_descripcion=findViewById(R.id.et_descripcion2);
        btn_Editar=findViewById(R.id.btn_editar);


        tv_nombre.setText(nombre);
        tv_fecha.setText(fecha);
        tv_telefono.setText(tele);
        tv_email.setText(email);
        tv_descripcion.setText(desc);

        btn_Editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }


}