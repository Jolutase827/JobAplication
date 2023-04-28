package es.ieslavereda.myrecicleviewexample.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UsuarioRepository {

    private List<Usuario> usuarios;
    private static UsuarioRepository instance;

    private UsuarioRepository(){
//        usuarios = new ArrayList<>();
//        usuarios.add(new Usuario("Manolo", "García Pérez",  R.mipmap.ic_actor_foreground));
//        usuarios.add(new Usuario("Luis", "García Pérez", R.mipmap.ic_albanyil_foreground));
//        usuarios.add(new Usuario("Carlos", "García Pérez",  R.mipmap.ic_banquero_foreground));
//        usuarios.add(new Usuario("Miguel", "García Pérez", R.mipmap.ic_cocinero_foreground));
//        usuarios.add(new Usuario("Pepe", "García Pérez",  R.mipmap.ic_estudiante_foreground));
//        usuarios.add(new Usuario("Alfonso", "García Pérez",  R.mipmap.ic_instagramer_foreground));
//        usuarios.add(new Usuario("Rubén", "García Pérez", R.mipmap.ic_pintor_foreground));
//        usuarios.add(new Usuario("Alejandro", "García Pérez",  R.mipmap.ic_policia_foreground));
//        usuarios.add(new Usuario("Ivan", "García Pérez",  R.mipmap.ic_politico_activo_foreground));
//        usuarios.add(new Usuario("Ramon", "García Pérez",  R.mipmap.ic_politico_retirado_foreground));
//        usuarios.add(new Usuario("Raul", "García Pérez",  R.mipmap.ic_vendedor_foreground));
//        usuarios.add(new Usuario("Javi", "García Pérez",  R.mipmap.ic_youtuber_foreground));
    }

    public void addUsuario(List<Usuario> usuarios){
        this.usuarios.addAll(usuarios);
    }

    public static UsuarioRepository getInstance(){
        if(instance==null)
            instance = new UsuarioRepository();

        return instance;
    }

    public Usuario getUsuario(int index) {
        return usuarios.get(index);
    }

    public int getSize(){
        return usuarios.size();
    }

    public void remove(Usuario u){
        usuarios.remove(u);
    }

    public void add(int position, Usuario u){
        usuarios.add(position, u);
    }
    public void add( Usuario u){
        usuarios.add(u);
    }

    public void sort(Comparator c){
        Collections.sort(usuarios,c);
    }
}
