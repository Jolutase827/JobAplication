package es.ieslavereda.myrecicleviewexample;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton addUser;
    private Switch aSwitchName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        addUser = findViewById(R.id.addUser);
        aSwitchName = findViewById(R.id.switchNombre);




        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(this);
        recyclerView.setAdapter(myRecyclerViewAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);




        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == RESULT_CANCELED)
                        Toast.makeText(this, "Cancelado por el usuario", Toast.LENGTH_LONG).show();
                    else if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        Usuario usuario = (Usuario) data.getExtras().getSerializable("usuario");
                        UsuarioRepository.getInstance().add(usuario);
                        myRecyclerViewAdapter.notifyDataSetChanged();
                        Toast.makeText(this, "Nuevo: " + usuario.getNombre() , Toast.LENGTH_LONG).show();
                    }
                });

        addUser.setOnClickListener(v->{
            Intent i = new Intent(this,FormularioActivity.class);
            someActivityResultLauncher.launch(i);
        });



        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

                int posTarget = target.getAdapterPosition();
                Usuario u = UsuarioRepository.getInstance().getUsuario(viewHolder.getAdapterPosition());
                UsuarioRepository.getInstance().remove(u);
                UsuarioRepository.getInstance().add(posTarget,u);

                recyclerView.getAdapter().notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();

                Usuario u = UsuarioRepository.getInstance().getUsuario(position);
                UsuarioRepository.getInstance().remove(u);
                myRecyclerViewAdapter.notifyItemRemoved(position);

                Snackbar.make(recyclerView, "Deleted " + u.getNombre(), Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                UsuarioRepository.getInstance().add(position, u);
                                myRecyclerViewAdapter.notifyItemInserted(position);
                            }
                        })
                        .show();
            }
        });

        itemTouchHelper.attachToRecyclerView(recyclerView);
        aSwitchName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    aSwitchName.setText("Profesion");
                    UsuarioRepository.getInstance().sort(Usuario.SORT_BY_PROFESION);
                }else {
                    aSwitchName.setText("Nombre");
                    UsuarioRepository.getInstance().sort(Usuario.SORT_BY_NAME);
                }
            }
        });

    }
}