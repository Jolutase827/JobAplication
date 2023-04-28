package es.ieslavereda.myrecicleviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import es.ieslavereda.myrecicleviewexample.model.Profesion;
import es.ieslavereda.myrecicleviewexample.model.ProfesionRepository;
import es.ieslavereda.myrecicleviewexample.model.Usuario;

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
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<Profesion> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, ProfesionRepository.getInstance().getAll());
        spinner.setAdapter(adapter);
        aceptar.setOnClickListener(view -> {
            Intent intent = new Intent();
            Usuario usuario = new Usuario(nombre.getText().toString(),apellido.getText().toString(), adapter.getItem(spinner.getSelectedItemPosition()).getImagen());
            intent.putExtra("usuario",usuario);
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