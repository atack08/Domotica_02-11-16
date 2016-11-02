package com.example.atack08.domotica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private boolean luzSalon, luzHall, luzCocina, luzBaño;
    private boolean camaraSalon, camaraHall, camaraCocina, camaraBaño;
    private int persianaSalon, persianaCocina, persianaBaño, persianaHall;
    private int temperaturaAmbiente;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        luzSalon = false;
        luzBaño = false;
        luzHall = false;
        luzCocina = false;
        configurarPanelLuces();

        camaraSalon = true;
        camaraCocina = true;
        camaraHall = true;
        camaraBaño = false;
        configurarPanelCamaras();

        //ESTADO INICIAL PERSIANAS
        persianaSalon = 4;
        persianaCocina = 4;
        persianaBaño = 4;
        persianaHall = 4;
        configurarPanelPersianas();

        temperaturaAmbiente = 22; //VALOR INICIAL

    }

    //ABRE LA ACTIVITY PARA CONFIGURAR LAS LUCES, LE PASA EL ESTADO DE LAS LUCES
    public void configurarLuces(View v) {

        Intent intent = new Intent(MainActivity.this, Luces.class);
        Bundle b = new Bundle();
        b.putBoolean("luzSalon", luzSalon);
        b.putBoolean("luzCocina", luzCocina);
        b.putBoolean("luzHall", luzHall);
        b.putBoolean("luzBaño", luzBaño);

        intent.putExtras(b);

        startActivityForResult(intent, 2);
    }

    //ABRE LA ACTIVITY PARA CONFIGURAR LAS CÁMARAS, LE PASA EL ESTADO DE LAS CÁMARAS
    public void configurarCamaras(View v) {

        Intent intent = new Intent(MainActivity.this, Camaras.class);
        Bundle b = new Bundle();
        b.putBoolean("camSalon", camaraSalon);
        b.putBoolean("camCocina", camaraCocina);
        b.putBoolean("camHall", camaraHall);
        b.putBoolean("camBaño", camaraBaño);

        intent.putExtras(b);

        startActivityForResult(intent, 2);
    }

    //ABRE LA ACTIVITY PARA CONFIGURAR LA TEMPERATURA AMBIENTE, LE PASA LA TEMPERATURA ACTUAL
    public void configurarTemperatura(View v) {

        Intent intent = new Intent(MainActivity.this, Temperatura.class);
        Bundle b = new Bundle();
        b.putInt("tempAmbiente", temperaturaAmbiente);


        intent.putExtras(b);

        startActivityForResult(intent, 2);
    }

    //ABRE LA ACTIVITY PARA CONFIGURAR LAS PERSIANAS, LE PASA EL ESTADO DE LAS PERSIANAS
    public void configurarPersianas(View v) {

        Intent intent = new Intent(MainActivity.this, Persianas.class);
        Bundle b = new Bundle();

        b.putInt("persianaSalon", this.persianaSalon);
        b.putInt("persianaCocina", this.persianaCocina);
        b.putInt("persianaBaño", this.persianaBaño);
        b.putInt("persianaHall", this.persianaHall);

        intent.putExtras(b);

        startActivityForResult(intent, 2);
    }



    @Override
    public void onActivityResult(int codigoRequest, int codigoResultado, Intent intentRespuesta) {

        super.onActivityResult(codigoResultado, codigoResultado, intentRespuesta);
        Bundle b = intentRespuesta.getExtras();

        switch (codigoResultado){

            case 1:
                //SI LA RESPUESTA VIENE DE LA ACTIVITY LUCES
                this.luzSalon = b.getBoolean("estadoLuzSalon");
                this.luzCocina = b.getBoolean("estadoLuzCocina");
                this.luzBaño = b.getBoolean("estadoLuzBaño");
                this.luzHall = b.getBoolean("estadoLuzHall");
                configurarPanelLuces();
                mostrarMensaje("LUCES ACTUALIZADAS");
                break;

            case 2:
                //SI LA RESPUESTA VIENE DE LA ACTIVITY CÁMARAS
                this.camaraSalon = b.getBoolean("estadoCamSalon");
                this.camaraCocina = b.getBoolean("estadoCamCocina");
                this.camaraBaño = b.getBoolean("estadoCamBaño");
                this.camaraHall = b.getBoolean("estadoCamHall");
                configurarPanelCamaras();
                mostrarMensaje("CÁMARAS ACTUALIZADAS");
                break;

            case 3:
                //SI LA RESPUESTA VIENE DE LA ACTIVITY TEMPERATURA
                this.temperaturaAmbiente = b.getInt("temperaturaAmbiente");
                configurarTemperaturaAmbiente();
                mostrarMensaje("TEMPERATURA ACTUALIZADA");
                break;

            case 4:
                //SI LA RESPUESTA VIENE DE LA ACTIVITY PERSIANAS
                this.persianaSalon = b.getInt("persianaSalon");
                this.persianaCocina = b.getInt("persianaCocina");
                this.persianaBaño = b.getInt("persianaBaño");
                this.persianaHall = b.getInt("persianaHall");
                configurarPanelPersianas();
                mostrarMensaje("PERSIANAS ACTUALIZADAS");
                break;
        }

    }

    //MÉTODO QUE CONFIGURA EL VISOR PRINCIPAL DE LUCES SEGÚN EL ESTADO
    public void configurarPanelLuces() {

        ImageView imgSalon = (ImageView)findViewById(R.id.mainLuzSalon);
        if(this.luzSalon)
            imgSalon.setImageResource(R.mipmap.ic_bombilla_encendia);
        else
            imgSalon.setImageResource(R.mipmap.ic_bombilla_apagada);

        ImageView imgCocina = (ImageView)findViewById(R.id.mainLuzCocina);
        if(this.luzCocina)
            imgCocina.setImageResource(R.mipmap.ic_bombilla_encendia);
        else
            imgCocina.setImageResource(R.mipmap.ic_bombilla_apagada);

        ImageView imgBaño = (ImageView)findViewById(R.id.mainLuzBaño);
        if(this.luzBaño)
            imgBaño.setImageResource(R.mipmap.ic_bombilla_encendia);
        else
            imgBaño.setImageResource(R.mipmap.ic_bombilla_apagada);

        ImageView imgHall = (ImageView)findViewById(R.id.mainLuzHall);
        if(this.luzHall)
            imgHall.setImageResource(R.mipmap.ic_bombilla_encendia);
        else
            imgHall.setImageResource(R.mipmap.ic_bombilla_apagada);

    }

    //MÉTODO QUE CONFIGURA EL VISOR PRINCIPAL DE CÁMARAS SEGÚN EL ESTADO
    public void configurarPanelCamaras() {

        ImageView imgSalon = (ImageView)findViewById(R.id.mainCamSalon);
        if(this.camaraSalon)
            imgSalon.setImageResource(R.mipmap.ic_camaras);
        else
            imgSalon.setImageResource(R.mipmap.ic_camara_off);

        ImageView imgCocina = (ImageView)findViewById(R.id.mainCamCocina);
        if(this.camaraCocina)
            imgCocina.setImageResource(R.mipmap.ic_camaras);
        else
            imgCocina.setImageResource(R.mipmap.ic_camara_off);

        ImageView imgBaño = (ImageView)findViewById(R.id.mainCamBaño);
        if(this.camaraBaño)
            imgBaño.setImageResource(R.mipmap.ic_camaras);
        else
            imgBaño.setImageResource(R.mipmap.ic_camara_off);

        ImageView imgHall = (ImageView)findViewById(R.id.mainCamHall);
        if(this.camaraHall)
            imgHall.setImageResource(R.mipmap.ic_camaras);
        else
            imgHall.setImageResource(R.mipmap.ic_camara_off);

    }

    //MÉTODO QUE CONFIGURA EL VISOR PRINCIPAL DE LAS PERSIANAS SEGÚN EL ESTADO
    public void configurarPanelPersianas() {

        ImageView imgSalon = (ImageView)findViewById(R.id.mainPersianaSalon);
        switch (this.persianaSalon){
            case 0:
                imgSalon.setImageResource(R.mipmap.ic_persiana0);
                break;
            case 1:
                imgSalon.setImageResource(R.mipmap.ic_persiana25);
                break;
            case 2:
                imgSalon.setImageResource(R.mipmap.ic_persiana50);
                break;
            case 3:
                imgSalon.setImageResource(R.mipmap.ic_persiana75);
                break;
            default:
                imgSalon.setImageResource(R.mipmap.ic_persiana100);
        }

        ImageView imgCocina = (ImageView)findViewById(R.id.mainPersianaCocina);
        switch (this.persianaCocina){
            case 0:
                imgCocina.setImageResource(R.mipmap.ic_persiana0);
                break;
            case 1:
                imgCocina.setImageResource(R.mipmap.ic_persiana25);
                break;
            case 2:
                imgCocina.setImageResource(R.mipmap.ic_persiana50);
                break;
            case 3:
                imgCocina.setImageResource(R.mipmap.ic_persiana75);
                break;
            default:
                imgCocina.setImageResource(R.mipmap.ic_persiana100);
        }

        ImageView imgBaño = (ImageView)findViewById(R.id.mainPersianaBaño);
        switch (this.persianaBaño){
            case 0:
                imgBaño.setImageResource(R.mipmap.ic_persiana0);
                break;
            case 1:
                imgBaño.setImageResource(R.mipmap.ic_persiana25);
                break;
            case 2:
                imgBaño.setImageResource(R.mipmap.ic_persiana50);
                break;
            case 3:
                imgBaño.setImageResource(R.mipmap.ic_persiana75);
                break;
            default:
                imgBaño.setImageResource(R.mipmap.ic_persiana100);
        }

        ImageView imgHall = (ImageView)findViewById(R.id.mainPersianaHall);
        switch (this.persianaHall){
            case 0:
                imgHall.setImageResource(R.mipmap.ic_persiana0);
                break;
            case 1:
                imgHall.setImageResource(R.mipmap.ic_persiana25);
                break;
            case 2:
                imgHall.setImageResource(R.mipmap.ic_persiana50);
                break;
            case 3:
                imgHall.setImageResource(R.mipmap.ic_persiana75);
                break;
            default:
                imgHall.setImageResource(R.mipmap.ic_persiana100);
        }

    }

    //MÉTODO PARA CONFIGURAR LA TEMPERATURA AMBIENTE
    public void configurarTemperaturaAmbiente(){

        TextView labelTemp = (TextView)findViewById(R.id.mainTempAmbiente);
        labelTemp.setText(String.valueOf(this.temperaturaAmbiente) + "ºC");

    }


    //MÉTODO PARA MOSTRAR MENSAJES
    public void mostrarMensaje(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}
