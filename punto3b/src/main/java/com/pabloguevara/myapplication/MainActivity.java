package com.pabloguevara.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends AppCompatActivity{

    private EditText base;
    private EditText altura;
    private EditText radio;
    private EditText lado;
    private Button bCalcular;
    private TextView tv;
    private RadioGroup group;
    private RadioButton cuadro;
    private RadioButton triangulo;
    private RadioButton rectangulo;
    private RadioButton circulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        base = (EditText) findViewById(R.id.base);
        altura = (EditText) findViewById(R.id.altura);
        radio = (EditText) findViewById(R.id.radio);
        lado = (EditText) findViewById(R.id.lado);
        group = (RadioGroup) findViewById(R.id.group);
        cuadro = (RadioButton) findViewById(R.id.cuadro);
        triangulo = (RadioButton) findViewById(R.id.triangulo);
        rectangulo = (RadioButton) findViewById(R.id.rectangulo);
        circulo = (RadioButton) findViewById(R.id.circulo);
        bCalcular = (Button) findViewById(R.id.bCalcular);
        tv = (TextView) findViewById(R.id.tv);

        lado.setVisibility(View.INVISIBLE);
        base.setVisibility(View.INVISIBLE);
        altura.setVisibility(View.INVISIBLE);
        radio.setVisibility(View.INVISIBLE);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (group.getCheckedRadioButtonId()) {

                    case R.id.cuadro:
                        lado.setVisibility(View.VISIBLE);
                        base.setVisibility(View.INVISIBLE);
                        altura.setVisibility(View.INVISIBLE);
                        radio.setVisibility(View.INVISIBLE);
                        break;

                    case R.id.triangulo:
                        lado.setVisibility(View.INVISIBLE);
                        base.setVisibility(View.VISIBLE);
                        altura.setVisibility(View.VISIBLE);
                        radio.setVisibility(View.INVISIBLE);
                        break;

                    case R.id.rectangulo:
                        lado.setVisibility(View.INVISIBLE);
                        base.setVisibility(View.VISIBLE);
                        altura.setVisibility(View.VISIBLE);
                        radio.setVisibility(View.INVISIBLE);
                        break;

                    case R.id.circulo:
                        lado.setVisibility(View.INVISIBLE);
                        base.setVisibility(View.INVISIBLE);
                        altura.setVisibility(View.INVISIBLE);
                        radio.setVisibility(View.VISIBLE);
                        break;

                }
            }
        });

        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double resultado = 0;

                switch (group.getCheckedRadioButtonId()) {

                    case R.id.cuadro:
                        double vlado = Double.parseDouble(lado.getText().toString());
                        resultado = vlado * vlado;
                        break;

                    case R.id.triangulo:
                        double vbase = Double.parseDouble(base.getText().toString());
                        double valtura = Double.parseDouble(altura.getText().toString());
                        resultado = (vbase * valtura) / 2;
                        break;

                    case R.id.rectangulo:
                        vbase = Double.parseDouble(base.getText().toString());
                        valtura = Double.parseDouble(altura.getText().toString());
                        resultado = (vbase * valtura);
                        break;

                    case R.id.circulo:
                        double vradio = Double.parseDouble(radio.getText().toString());
                        resultado = Math.PI * Math.pow(vradio, 2);
                        break;
                }

                String mensaje = " ";
                mensaje = String.valueOf(resultado);

                tv.setText("El área es: " + mensaje);

                if ((cuadro.isChecked() == false)&&(triangulo.isChecked() == false)&&(rectangulo.isChecked() == false)&&(circulo.isChecked() == false))
                    tv.setText("Por favor seleccione una figura");

            }
        });
    }
}

