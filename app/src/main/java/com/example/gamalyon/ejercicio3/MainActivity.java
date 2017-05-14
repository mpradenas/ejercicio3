package com.example.gamalyon.ejercicio3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner sp;
    private EditText edt1;
    private EditText edt2;
    private TextView txtV;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=(EditText) findViewById(R.id.edT1);
        edt2=(EditText) findViewById(R.id.edT2);
        txtV=(TextView) findViewById(R.id.tv3);
        sp=(Spinner)findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(!TextUtils.isEmpty(edt1.getText().toString()) && !TextUtils.isEmpty(edt2.getText().toString())) {
            String N1 = edt1.getText().toString();
            String N2 = edt2.getText().toString();
            int n1 = Integer.parseInt(N1);
            int n2 = Integer.parseInt(N2);
            int indice = position;
            if (n1 != 0 || n2 != 0) {
                int resul = 0;
                String resp = "";
                switch (indice) {
                    case 1:
                        resul = n1 + n2;
                        resp = String.valueOf(resul);
                        break;
                    case 2:
                        resul = n1 - n2;
                        resp = String.valueOf(resul);
                        break;
                    case 3:
                        resul = n1 * n2;
                        resp = String.valueOf(resul);
                        break;
                    case 4:
                        if (n2 == 0) {
                            Toast.makeText(this, "Error, no se puede dividir por 0", Toast.LENGTH_SHORT).show();

                        } else {

                            resul = n1 / n2;
                            resp = String.valueOf(resul);
                        }
                        break;
                }
                Toast.makeText(this,"Resultado es :"+resp, Toast.LENGTH_SHORT).show();
                txtV.setText(resp);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
