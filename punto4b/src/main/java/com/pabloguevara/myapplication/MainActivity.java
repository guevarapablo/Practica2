package com.pabloguevara.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText loggin;
    private EditText password;
    private EditText password2;
    private EditText email;
    private Spinner ciudades;
    private DatePicker date;
    private CheckBox musica;
    private CheckBox deporte;
    private CheckBox cine;
    private CheckBox literatura;
    private Button bAceptar;
    private TextView tv;
    private RadioGroup group;
    private RadioButton femenino;
    private RadioButton masculino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loggin = (EditText) findViewById(R.id.loggin);
        password = (EditText) findViewById(R.id.password);
        password2 = (EditText) findViewById(R.id.password2);
        email = (EditText) findViewById(R.id.email);
        group = (RadioGroup) findViewById(R.id.group);
        masculino = (RadioButton) findViewById(R.id.masculino);
        femenino = (RadioButton) findViewById(R.id.femenino);
        ciudades = (Spinner) findViewById(R.id.ciudades);
        date = (DatePicker) findViewById(R.id.date);
        musica = (CheckBox) findViewById(R.id.musica);
        deporte = (CheckBox) findViewById(R.id.deporte);
        cine = (CheckBox) findViewById(R.id.cine);
        literatura = (CheckBox) findViewById(R.id.literatura);
        bAceptar = (Button) findViewById(R.id.bAceptar);
        tv = (TextView) findViewById(R.id.tv);

        //Bloque para el Spinner
        String[] datos = new String[]{"Armenia", "Barranquilla", "Bogotá", "Bucaramanga", "Buenaventura", "Cali", "Cartagena", "Cúcuta", "Ibagué", "Leticia", "Manizales", "Medellín", "Montería", "Neiva", "Pasto", "Pereira", "San Andrés", "Santa Marta", "Soledad", "Tunja", "Valledupar", "Villavicencio", "Yopal"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
        ciudades = (Spinner) findViewById(R.id.ciudades);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ciudades.setAdapter(adaptador);

        bAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                String dloggin = loggin.getText().toString();
                String dpass = password.getText().toString();
                String dpass2 = password2.getText().toString();
                String demail = email.getText().toString();
                String dsexo="";
                String dciu = ciudades.getSelectedItem().toString();

                //Bloque para el RadioGroup
                switch (group.getCheckedRadioButtonId()) {

                    case R.id.masculino:
                        dsexo = "Masculino";
                        break;
                    case R.id.femenino:
                        dsexo = "Femenino";
                        break;
                }

                //Bloque para el DatePicker
                int y,m,d;
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                month = month + 1;
                int day = c.get(Calendar.DAY_OF_MONTH);

                y = date.getYear();
                m = date.getMonth();
                m = m+1;
                d = date.getDayOfMonth();

                String cbox_musica=" ";
                String cbox_deporte=" ";
                String cbox_cine=" ";
                String cbox_literatura=" ";

                if(musica.isChecked())
                    cbox_musica="Musica";

                if(deporte.isChecked())
                    cbox_deporte="Deporte";

                if(cine.isChecked())
                    cbox_cine="Cine";

                if(literatura.isChecked())
                    cbox_literatura="Literatura";

                if(dpass.equals(dpass2))
                    tv.setText("El ID es: "+dloggin+"\nEl password es: "+dpass+"\nEl email es: "+demail+"\nEl sexo es: "+dsexo+"\nLa fecha de nacimiento es: "+d+"/"+m+"/"+y+"\nEl lugar de nacimiento es: "+dciu+"\nLos Hobies son: "+cbox_musica+" "+cbox_deporte+" "+cbox_cine+" "+cbox_literatura);
                else
                    tv.setText("Los passwords no coinciden\nIntente de nuevo");

                //Validación de campos vacíos
                if((TextUtils.isEmpty(dloggin))||(TextUtils.isEmpty(dpass))||(TextUtils.isEmpty(dpass2))||(TextUtils.isEmpty(demail))||(TextUtils.isEmpty(dsexo)))
                    tv.setText("Por favor llene todoslos campos");

            }

        });
    }
}