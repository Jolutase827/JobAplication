package es.ieslavereda.myrecicleviewexample;

import java.util.List;

public class UsuarioRepository {

    private List<Usuario> usuarios;
    private static UsuarioRepository instance;

    private UsuarioRepository(){



    }

    public static UsuarioRepository getInstance(){
        if(instance==null)
            instance = new UsuarioRepository();

        return instance;
    }
}
