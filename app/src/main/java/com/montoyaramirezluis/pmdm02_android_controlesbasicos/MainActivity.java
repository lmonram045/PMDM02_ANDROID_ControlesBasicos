package com.montoyaramirezluis.pmdm02_android_controlesbasicos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Localizamos el control dentro del activity por ID.
        Button boton = findViewById(R.id.btEnviar);
        onClick(boton);
    }

    public void onClick(Button boton) {
        boton.setOnClickListener(view -> {

            // Localizamos los controles dentro del activity por ID.
            EditText etNombre = findViewById(R.id.etNombre);
            RadioGroup rg = findViewById(R.id.grupo_opciones);
            RadioButton rb = findViewById(rg.getCheckedRadioButtonId()); // aquí obtenemos el botón seleccionado.
            CheckBox ck = findViewById(R.id.ckAdaptacion);
            SwitchCompat sw = findViewById(R.id.swNotificaciones);
            EditText numero = findViewById(R.id.etNumero);
            EditText observaciones = findViewById(R.id.etObservaciones);
            Double valor2 = Double.parseDouble(numero.getText().toString());

            String opcion = "";
            // Si el botón está seleccionado (no es nulo), se obtiene el texto del botón.
            if (rb != null)
                opcion = rb.getText().toString();

            Boolean adaptacion = ck.isChecked(); // Si el checkbox está seleccionado, guarda true.
            Boolean notificaciones = sw.isChecked(); // Si el switch está seleccionado, guarda true.

            // Creamos un string con todos los valores leidos de los controles
            String resultado = "Nombre: " + etNombre.getText()
                    + ", opción: " + opcion
                    + ", adaptación: " + adaptacion
                    + ", notificaciones: " + notificaciones
                    + ", número: " + valor2
                    + ", observaciones: " + observaciones.getText();

            // Mostramos el resultado en un Toast.
            Toast.makeText(this, resultado, Toast.LENGTH_LONG).show();
        });
    }
}