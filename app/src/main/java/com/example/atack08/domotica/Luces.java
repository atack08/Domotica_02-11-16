package com.example.atack08.domotica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class Luces extends AppCompatActivity {

    private ImageView imgLuzSalon,imgLuzCocina,imgLuzHall,imgLuzBaño;
    private boolean estadoLuzSalon,estadoLuzCocina,estadoLuzHall,estadoLuzBaño;
    private Switch switchSalon,switchCocina,switchBaño,switchHall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luces);

        switchBaño = (Switch)findViewById(R.id.switchLuzBaño);
        switchCocina = (Switch)findViewById(R.id.switchLuzCocina);
        switchHall = (Switch)findViewById(R.id.switchLuzHall);
        switchSalon = (Switch)findViewById(R.id.switchLuzSalon);

        imgLuzSalon = (ImageView)findViewById(R.id.imagenLuzSalon);
        imgLuzCocina = (ImageView)findViewById(R.id.imagenLuzCocina);
        imgLuzBaño = (ImageView)findViewById(R.id.imagenLuzBaño);
        imgLuzHall = (ImageView)findViewById(R.id.imagenLuzHall);

        Bundle bundle = this.getIntent().getExtras();
        estadoLuzSalon = bundle.getBoolean("luzSalon");
        estadoLuzBaño = bundle.getBoolean("luzBaño");
        estadoLuzCocina = bundle.getBoolean("luzCocina");
        estadoLuzHall = bundle.getBoolean("luzHall");

        configurarEstadoInicial();


        //ESCUCHADORES DE EVENTOS
        switchSalon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                estadoLuzSalon = isChecked;
                if(isChecked)
                    imgLuzSalon.setImageResource(R.mipmap.ic_bombilla_encendia);
                else
                    imgLuzSalon.setImageResource(R.mipmap.ic_bombilla_apagada);

            }
        });

        switchCocina.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                estadoLuzCocina = isChecked;
                if(isChecked)
                    imgLuzCocina.setImageResource(R.mipmap.ic_bombilla_encendia);
                else
                    imgLuzCocina.setImageResource(R.mipmap.ic_bombilla_apagada);
            }
        });

        switchHall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                estadoLuzHall = isChecked;
                if(isChecked)
                    imgLuzHall.setImageResource(R.mipmap.ic_bombilla_encendia);
                else
                    imgLuzHall.setImageResource(R.mipmap.ic_bombilla_apagada);

            }
        });

        switchBaño.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                estadoLuzBaño = isChecked;
                if(isChecked)
                    imgLuzBaño.setImageResource(R.mipmap.ic_bombilla_encendia);
                else
                    imgLuzBaño.setImageResource(R.mipmap.ic_bombilla_apagada);
            }
        });

    }

    //CONFIGURAMOS EL ESTADO INICIAL DE LAS LUCES
    public void configurarEstadoInicial(){

        switchSalon.setChecked(estadoLuzSalon);
        if(estadoLuzSalon) {
            imgLuzSalon.setImageResource(R.mipmap.ic_bombilla_encendia);
        }
        else {
            imgLuzSalon.setImageResource(R.mipmap.ic_bombilla_apagada);
        }

        switchCocina.setChecked(estadoLuzCocina);
        if(estadoLuzCocina) {
            imgLuzCocina.setImageResource(R.mipmap.ic_bombilla_encendia);
        }
        else {
            imgLuzCocina.setImageResource(R.mipmap.ic_bombilla_apagada);
        }

        switchBaño.setChecked(estadoLuzBaño);
        if(estadoLuzBaño) {
            imgLuzBaño.setImageResource(R.mipmap.ic_bombilla_encendia);
        }
        else {
            imgLuzBaño.setImageResource(R.mipmap.ic_bombilla_apagada);
        }

        switchHall.setChecked(estadoLuzHall);
        if(estadoLuzHall) {
            imgLuzHall.setImageResource(R.mipmap.ic_bombilla_encendia);
        }
        else {
            imgLuzHall.setImageResource(R.mipmap.ic_bombilla_apagada);
        }

    }

    //CONFIGURAMOS INTENT DE RESPUESTA CON LOS ESTADOS DE LAS LUCES Y CERRAMOS VENTANAS
    public void cerrarVentanaLuces(View v){

        this.setResult(1,configurarRespuesta());
        finish();

    }

    public Intent configurarRespuesta(){

        Intent respuesta = new Intent(this,MainActivity.class);
        Bundle b = new Bundle();
        b.putBoolean("estadoLuzSalon",estadoLuzSalon);
        b.putBoolean("estadoLuzCocina",estadoLuzCocina);
        b.putBoolean("estadoLuzBaño",estadoLuzBaño);
        b.putBoolean("estadoLuzHall",estadoLuzHall);

        respuesta.putExtras(b);

        return respuesta;
    }


}
