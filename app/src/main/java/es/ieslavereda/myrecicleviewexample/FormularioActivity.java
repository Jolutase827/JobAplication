package es.ieslavereda.myrecicleviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class FormularioActivity extends AppCompatActivity {
    private Button aceptar;
    private Button cancelar;
    private Spinner spinner;
    private EditText nombre;
    private EditText apellido;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        aceptar = findViewById(R.id.buttonAceptar);
        cancelar = findViewById(R.id.botonCancelar);
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        aceptar.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("Nombre",nombre.getText().toString());
            intent.putExtra("Apellido", apellido.getText().toString());
            intent.putExtra("Oficio",spinner.getBaseline());
            setResult(RESULT_OK,intent);
            finish();
        });
        cancelar.setOnClickListener(view -> {
            Intent intent = new Intent();
            setResult(RESULT_CANCELED,intent);
            finish();
        });

    }
}