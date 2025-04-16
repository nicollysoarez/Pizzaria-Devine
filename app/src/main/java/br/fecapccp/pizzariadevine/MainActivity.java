package br.fecapccp.pizzariadevine;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import br.fecapccp.pizzariadevine.R;

public class MainActivity extends AppCompatActivity {

    CheckBox checkFrango, checkQueijos, checkPepperoni, checkPortuguesa, checkVegetariana;
    Button btnAvancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkFrango = findViewById(R.id.checkFrango);
        checkQueijos = findViewById(R.id.checkQueijos);
        checkPepperoni = findViewById(R.id.checkPepperoni);
        checkPortuguesa = findViewById(R.id.checkPortuguesa);
        checkVegetariana = findViewById(R.id.checkVegetariana);
        btnAvancar = findViewById(R.id.btnAvancar);

        btnAvancar.setOnClickListener(view -> {
            ArrayList<String> saboresSelecionados = new ArrayList<>();

            if (checkFrango.isChecked()) saboresSelecionados.add("Frango com Catupiry");
            if (checkQueijos.isChecked()) saboresSelecionados.add("Quatro Queijos");
            if (checkPepperoni.isChecked()) saboresSelecionados.add("Pepperoni");
            if (checkPortuguesa.isChecked()) saboresSelecionados.add("Portuguesa");
            if (checkVegetariana.isChecked()) saboresSelecionados.add("Vegetariana");

            Intent intent = new Intent(MainActivity.this, br.fecapccp.pizzariadevine.TamanhoActivity.class);
            intent.putStringArrayListExtra("sabores", saboresSelecionados);
            startActivity(intent);
        });
    }
}