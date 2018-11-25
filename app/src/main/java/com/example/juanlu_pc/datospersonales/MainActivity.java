package com.example.juanlu_pc.datospersonales;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner lstEstados;
    String[] estados;
    EditText et1, et2, et3;
    RadioGroup rdSexo;
    RadioButton rb1, rb2;
    Switch sw1;
    Button btn1;
    ImageButton btnEliminar;
    TextView txtMostrado;
    String sexo, mayoriaEdad, tieneHijos;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstEstados = findViewById(R.id.lstEstados);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        rdSexo = findViewById(R.id.rdSexo);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        sw1 = findViewById(R.id.sw1);
        btn1 = findViewById(R.id.btn1);
        btnEliminar = findViewById(R.id.btnEliminar);
        txtMostrado = findViewById(R.id.txtMostrado);
        tieneHijos = getResources().getString(R.string.hijosNo);

        estados = new String[] {getResources().getString(R.string.vacio),getResources().getString(R.string.soltero), getResources().getString(R.string.casado),
                getResources().getString(R.string.viudo), getResources().getString(R.string.otro)};
        ArrayAdapter adaptadorEstados = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, estados);
        lstEstados.setAdapter(adaptadorEstados);
        rdSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb1) sexo = getResources().getString(R.string.rb1);
                if (checkedId == R.id.rb2) sexo = getResources().getString(R.string.rb2);
            }
        });
        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sw1.isChecked())
                {
                    tieneHijos = getResources().getString(R.string.hijosSi);
                }
                else
                {
                    tieneHijos = getResources().getString(R.string.hijosNo);
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (et1.getText().toString().isEmpty() ){
                    txtMostrado.setText(getResources().getString(R.string.faltaNombre));
                    txtMostrado.setTextColor(getResources().getColor(R.color.colorAccent));
                } else {
                    if (et2.getText().toString().isEmpty()){
                        txtMostrado.setText(getResources().getString(R.string.faltaApellidos));
                        txtMostrado.setTextColor(getResources().getColor(R.color.colorAccent));
                    } else {
                        if (et3.getText().toString().isEmpty()){
                            txtMostrado.setText(getResources().getString(R.string.faltaEdad));
                            txtMostrado.setTextColor(getResources().getColor(R.color.colorAccent));
                        } else {
                            if (Integer.parseInt(et3.getText().toString()) <= 17){
                                mayoriaEdad = getResources().getString(R.string.menorEdad);
                            } else {
                                mayoriaEdad = getResources().getString(R.string.mayorEdad);
                            }
                            txtMostrado.setText(et2.getText().toString() + " , " + et1.getText().toString() + " , " + mayoriaEdad + " , " + sexo + " " +
                                    lstEstados.getSelectedItem().toString() + " y " + tieneHijos );
                            txtMostrado.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                        }
                    }

                }

            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                et1.setText("");
                et2.setText("");
                et3.setText("");
                rb1.setChecked(false);
                rb2.setChecked(false);
                lstEstados.setSelection(0);
                sw1.setChecked(false);
            }
        });
    }
}
