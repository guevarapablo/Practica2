package com.pabloguevara.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText val1;
    private EditText val2;
    private Button bCalcular;
    private TextView tv;
    private RadioGroup radio;
    private RadioButton suma;
    private RadioButton resta;
    private RadioButton multiplicacion;
    private RadioButton division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1 = (EditText) findViewById(R.id.val1);
        val2 = (EditText) findViewById(R.id.val2);
        bCalcular = (Button) findViewById(R.id.bCalcular);
        tv = (TextView) findViewById(R.id.tv);
        radio = (RadioGroup) findViewById(R.id.radio);
        suma = (RadioButton) findViewById(R.id.suma);
        resta = (RadioButton) findViewById(R.id.resta);
        multiplicacion = (RadioButton) findViewById(R.id.multiplicacion);
        division = (RadioButton) findViewById(R.id.division);

        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double valor1 = Double.parseDouble(val1.getText().toString());
                double valor2 = Double.parseDouble(val2.getText().toString());
                double resultado=0;
                String mensaje;

                    switch (radio.getCheckedRadioButtonId()) {

                        case R.id.suma:
                                resultado = valor1 + valor2;
                            break;
                        case R.id.resta:
                                resultado = valor1 - valor2;
                            break;
                        case R.id.multiplicacion:
                                resultado = valor1 * valor2;

                            break;
                        case R.id.division:
                                resultado = valor1 / valor2;
                            break;
                    }

                mensaje = String.valueOf(resultado);
                tv.setText("El resultado es: "+mensaje);

            }
        });

    }

}
