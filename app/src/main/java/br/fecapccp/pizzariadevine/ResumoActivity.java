package br.fecapccp.pizzariadevine;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import br.fecapccp.pizzariadevine.R;

public class ResumoActivity extends AppCompatActivity {

    TextView textDetalhes;
    Button btnNovoPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        textDetalhes = findViewById(R.id.textDetalhes);
        btnNovoPedido = findViewById(R.id.btnNovoPedido);

        ArrayList<String> sabores = getIntent().getStringArrayListExtra("sabores");
        String tamanho = getIntent().getStringExtra("tamanho");
        String pagamento = getIntent().getStringExtra("pagamento");
        double valor = getIntent().getDoubleExtra("valor", 0.0);

        StringBuilder resumo = new StringBuilder();
        resumo.append(" Sabores: ");
        if (sabores != null && !sabores.isEmpty()) {
            for (String sabor : sabores) {
                resumo.append("\n• ").append(sabor);
            }
        } else {
            resumo.append("Nenhum");
        }

        resumo.append("\n\n Tamanho: ").append(tamanho);
        resumo.append("\n Pagamento: ").append(pagamento);
        resumo.append(String.format("\n\n Total: R$ %.2f", valor));

        textDetalhes.setText(resumo.toString());

        btnNovoPedido.setOnClickListener(v -> {
            Intent intent = new Intent(ResumoActivity.this, br.fecapccp.pizzariadevine.MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // limpa a pilha
            startActivity(intent);
        });
    }
}
