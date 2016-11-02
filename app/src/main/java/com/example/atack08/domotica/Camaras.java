package com.example.atack08.domotica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class Camaras extends AppCompatActivity {

    private ImageView imgCamSalon,imgCamCocina,imgCamHall,imgCamBaño;
    private boolean estadoCamSalon,estadoCamCocina,estadoCamHall,estadoCamBaño;
    private Switch switchSalon,switchCocina,switchBaño,switchHall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camaras);

        switchBaño = (Switch)findViewById(R.id.switchCamaraBaño);
        switchCocina = (Switch)findViewById(R.id.switchCamaraCocina);
        switchHall = (Switch)findViewById(R.id.switchCamaraHall);
        switchSalon = (Switch)findViewById(R.id.switchCamaraSalon);

        imgCamSalon = (ImageView)findViewById(R.id.imagenCamaraSalon);
        imgCamCocina = (ImageView)findViewById(R.id.imagenCamaraCocina);
        imgCamBaño = (ImageView)findViewById(R.id.imagenCamaraBaño);
        imgCamHall = (ImageView)findViewById(R.id.imagenCamaraHall);

        Bundle bundle = this.getIntent().getExtras();
        estadoCamSalon = bundle.getBoolean("camSalon");
        estadoCamCocina = bundle.getBoolean("camCocina");
        estadoCamBaño = bundle.getBoolean("camBaño");
        estadoCamHall = bundle.getBoolean("camHall");

        configurarEstadoInicial();

        //ESCUCHADORES DE EVENTOS
        switchSalon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                estadoCamSalon = isChecked;
                if(isChecked)
                    imgCamSalon.setImageResource(R.mipmap.ic_camaras);
                else
                    imgCamSalon.setImageResource(R.mipmap.ic_camara_off);

            }
        });

        switchCocina.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                estadoCamCocina = isChecked;
                if(isChecked)
                    imgCamCocina.setImageResource(R.mipmap.ic_camaras);
                else
                    imgCamCocina.setImageResource(R.mipmap.ic_camara_off);
            }
        });

        switchHall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                estadoCamHall = isChecked;
                if(isChecked)
                    imgCamHall.setImageResource(R.mipmap.ic_camaras);
                else
                    imgCamHall.setImageResource(R.mipmap.ic_camara_off);

            }
        });

        switchBaño.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                estadoCamBaño = isChecked;
                if(isChecked)
                    imgCamBaño.setImageResource(R.mipmap.ic_camaras);
                else
                    imgCamBaño.setImageResource(R.mipmap.ic_camara_off);
            }
        });
    }

    //CONFIGURAMOS EL ESTADO INICIAL DE LAS CÁMARAS
    public void configurarEstadoInicial(){

        switchSalon.setChecked(estadoCamSalon);
        if(estadoCamSalon) {
            imgCamSalon.setImageResource(R.mipmap.ic_camaras);
        }
        else {
            imgCamSalon.setImageResource(R.mipmap.ic_camara_off);
        }

        switchCocina.setChecked(estadoCamCocina);
        if(estadoCamCocina) {
            imgCamCocina.setImageResource(R.mipmap.ic_camaras);
        }
        else {
            imgCamCocina.setImageResource(R.mipmap.ic_camara_off);
        }

        switchBaño.setChecked(estadoCamBaño);
        if(estadoCamBaño) {
            imgCamBaño.setImageResource(R.mipmap.ic_camaras);
        }
        else {
            imgCamBaño.setImageResource(R.mipmap.ic_camara_off);
        }

        switchHall.setChecked(estadoCamHall);
        if(estadoCamHall) {
            imgCamHall.setImageResource(R.mipmap.ic_camaras);
        }
        else {
            imgCamHall.setImageResource(R.mipmap.ic_camara_off);
        }

    }

    //CONFIGURAMOS INTENT DE RESPUESTA CON LOS ESTADOS DE LAS CÁMARAS Y CERRAMOS VENTANA
    public void cerrarVentanaCamaras(View v){

        this.setResult(2,configurarRespuesta());
        finish();

    }

    public Intent configurarRespuesta(){

        Intent respuesta = new Intent(this,MainActivity.class);
        Bundle b = new Bundle();
        b.putBoolean("estadoCamSalon",estadoCamSalon);
        b.putBoolean("estadoCamCocina",estadoCamCocina);
        b.putBoolean("estadoCamBaño",estadoCamBaño);
        b.putBoolean("estadoCamHall",estadoCamHall);

        respuesta.putExtras(b);

        return respuesta;
    }



}
