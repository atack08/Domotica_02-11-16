package com.example.atack08.domotica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;

public class Persianas extends AppCompatActivity {

    private ImageView imgPersianaSalon,imgPersianaCocina,imgPersianaBaño,imgPersianaHall;
    private int estadoPersianaSalon,estadoPersianaCocina,estadoPersianaBaño,estadoPersianaHall;
    private NumberPicker npPersianaSalon,npPersianaCocina,npPersianaBaño,npPersianaHall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persianas);

        imgPersianaSalon = (ImageView)findViewById(R.id.imgPersianaSalon);
        imgPersianaCocina = (ImageView)findViewById(R.id.imgPersianaCocina);
        imgPersianaBaño = (ImageView)findViewById(R.id.imgPersianaBaño);
        imgPersianaHall = (ImageView)findViewById(R.id.imgPersianaHall);


        npPersianaSalon = (NumberPicker)findViewById(R.id.selectorPersianaSalon);
        npPersianaSalon.setMinValue(0);
        npPersianaSalon.setMaxValue(4);

        npPersianaCocina = (NumberPicker)findViewById(R.id.selectorPersianaCocina);
        npPersianaCocina.setMinValue(0);
        npPersianaCocina.setMaxValue(4);

        npPersianaBaño = (NumberPicker)findViewById(R.id.selectorPersianaBaño);
        npPersianaBaño.setMinValue(0);
        npPersianaBaño.setMaxValue(4);

        npPersianaHall = (NumberPicker)findViewById(R.id.selectorPersianaHall);
        npPersianaHall.setMinValue(0);
        npPersianaHall.setMaxValue(4);


        //RECOGEMOS EL ESTADO INICIAL DE LAS PERSIANAS DEL MAIN ACTIVITY
        Bundle bundle = this.getIntent().getExtras();
        estadoPersianaSalon = bundle.getInt("persianaSalon");
        estadoPersianaCocina = bundle.getInt("persianaCocina");
        estadoPersianaBaño = bundle.getInt("persianaBaño");
        estadoPersianaHall = bundle.getInt("persianaHall");

        configurarEstadoInicial();

        //ESCUCHADORES DE EVENTOS
        npPersianaSalon.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                estadoPersianaSalon = picker.getValue();
                configurarPersianaSalon();
            }
        });

        npPersianaCocina.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                estadoPersianaCocina = picker.getValue();
                configurarPersianaCocina();
            }
        });

        npPersianaBaño.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                estadoPersianaBaño = picker.getValue();
                configurarPersianaBaño();
            }
        });

        npPersianaHall.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                estadoPersianaHall = picker.getValue();
                configurarPersianaHall();
            }
        });

    }

    //CONFIGURAMOS EL ESTADO INICIAL DE LASPERSIANAS
    public void configurarEstadoInicial(){

        configurarPersianaSalon();
        configurarPersianaCocina();
        configurarPersianaBaño();
        configurarPersianaHall();
    }

    public void configurarPersianaSalon(){

        npPersianaSalon.setValue(this.estadoPersianaSalon);
        switch (this.estadoPersianaSalon){
            case 0:
                imgPersianaSalon.setImageResource(R.mipmap.ic_persiana0);
                break;
            case 1:
                imgPersianaSalon.setImageResource(R.mipmap.ic_persiana25);
                break;
            case 2:
                imgPersianaSalon.setImageResource(R.mipmap.ic_persiana50);
                break;
            case 3:
                imgPersianaSalon.setImageResource(R.mipmap.ic_persiana75);
                break;
            default:
                imgPersianaSalon.setImageResource(R.mipmap.ic_persiana100);
        }
    }

    public void configurarPersianaCocina(){

        npPersianaCocina.setValue(this.estadoPersianaCocina);
        switch (this.estadoPersianaCocina){
            case 0:
                imgPersianaCocina.setImageResource(R.mipmap.ic_persiana0);
                break;
            case 1:
                imgPersianaCocina.setImageResource(R.mipmap.ic_persiana25);
                break;
            case 2:
                imgPersianaCocina.setImageResource(R.mipmap.ic_persiana50);
                break;
            case 3:
                imgPersianaCocina.setImageResource(R.mipmap.ic_persiana75);
                break;
            default:
                imgPersianaCocina.setImageResource(R.mipmap.ic_persiana100);
        }
    }

    public void configurarPersianaBaño(){

        npPersianaBaño.setValue(this.estadoPersianaBaño);
        switch (this.estadoPersianaBaño){
            case 0:
                imgPersianaBaño.setImageResource(R.mipmap.ic_persiana0);
                break;
            case 1:
                imgPersianaBaño.setImageResource(R.mipmap.ic_persiana25);
                break;
            case 2:
                imgPersianaBaño.setImageResource(R.mipmap.ic_persiana50);
                break;
            case 3:
                imgPersianaBaño.setImageResource(R.mipmap.ic_persiana75);
                break;
            default:
                imgPersianaBaño.setImageResource(R.mipmap.ic_persiana100);
        }
    }

    public void configurarPersianaHall(){

        npPersianaHall.setValue(this.estadoPersianaHall);
        switch (this.estadoPersianaHall){
            case 0:
                imgPersianaHall.setImageResource(R.mipmap.ic_persiana0);
                break;
            case 1:
                imgPersianaHall.setImageResource(R.mipmap.ic_persiana25);
                break;
            case 2:
                imgPersianaHall.setImageResource(R.mipmap.ic_persiana50);
                break;
            case 3:
                imgPersianaHall.setImageResource(R.mipmap.ic_persiana75);
                break;
            default:
                imgPersianaHall.setImageResource(R.mipmap.ic_persiana100);
        }
    }

    //CONFIGURAMOS INTENT DE RESPUESTA CON LOS ESTADOS DE LAS PERSIANAS Y CERRAMOS VENTANA
    public void cerrarVentanaPersianas(View v){

        this.setResult(4,configurarRespuesta());
        finish();

    }

    public Intent configurarRespuesta(){

        Intent respuesta = new Intent(this,MainActivity.class);
        Bundle b = new Bundle();
        b.putInt("persianaSalon",this.estadoPersianaSalon);
        b.putInt("persianaCocina",this.estadoPersianaCocina);
        b.putInt("persianaBaño",this.estadoPersianaBaño);
        b.putInt("persianaHall",this.estadoPersianaHall);

        respuesta.putExtras(b);

        return respuesta;
    }
}
