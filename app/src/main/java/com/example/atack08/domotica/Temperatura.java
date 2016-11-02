package com.example.atack08.domotica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

public class Temperatura extends AppCompatActivity {

    private NumberPicker np;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        np = (NumberPicker)findViewById(R.id.selectorTemperatura);
        np.setMaxValue(30);
        np.setMinValue(16);

        //RECOGEMOS EL VALOR ACTUAL DE LA TEMPERATURA
        temperaturaInicial();

    }


    //MÉTODO QUE RECOGE DEL INTENT LA TEMPERATURA INICIAL
    public void temperaturaInicial(){

        Bundle bundle = this.getIntent().getExtras();
        np.setValue(bundle.getInt("tempAmbiente"));

    }

    //CONFIGURAMOS INTENT DE RESPUESTA CON LA TEMPERATURA ELEGIDA CERRAMOS VENTANA
    public void cerrarVentanaTemperatura(View v){

        this.setResult(3,configurarRespuesta());
        finish();

    }

    public Intent configurarRespuesta(){

        Intent respuesta = new Intent(this,MainActivity.class);
        Bundle b = new Bundle();
        b.putInt("temperaturaAmbiente",np.getValue());

        respuesta.putExtras(b);

        return respuesta;
    }
}
