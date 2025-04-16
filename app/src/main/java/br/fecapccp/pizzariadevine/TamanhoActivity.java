package br.fecapccp.pizzariadevine;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import br.fecapccp.pizzariadevine.R;

public class TamanhoActivity extends AppCompatActivity {

    RadioGroup groupTamanho, groupPagamento;
    Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamanho);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        groupTamanho = findViewById(R.id.groupTamanho);
        groupPagamento = findViewById(R.id.groupPagamento);
        btnConfirmar = findViewById(R.id.btnConfirmar);

        ArrayList<String> saboresSelecionados = getIntent().getStringArrayListExtra("sabores");

        btnConfirmar.setOnClickListener(v -> {
            int tamanhoSelecionado = groupTamanho.getCheckedRadioButtonId();
            int pagamentoSelecionado = groupPagamento.getCheckedRadioButtonId();

            if (tamanhoSelecionado == -1 || pagamentoSelecionado == -1) {
                Toast.makeText(this, "Selecione o tamanho e o pagamento", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton radioTamanho = findViewById(tamanhoSelecionado);
            RadioButton radioPagamento = findViewById(pagamentoSelecionado);

            String tamanho = radioTamanho.getText().toString();
            String pagamento = radioPagamento.getText().toString();

            double valor = 0;
            if (tamanho.contains("Pequena")) valor = 30.00;
            else if (tamanho.contains("Média")) valor = 40.00;
            else if (tamanho.contains("Grande")) valor = 00.00;

            Intent intent = new Intent(TamanhoActivity.this, br.fecapccp.pizzariadevine.ResumoActivity.class);
            intent.putStringArrayListExtra("sabores", saboresSelecionados);
            intent.putExtra("tamanho", tamanho);
            intent.putExtra("pagamento", pagamento);
            intent.putExtra("valor", valor);
            startActivity(intent);
        });
    }
}