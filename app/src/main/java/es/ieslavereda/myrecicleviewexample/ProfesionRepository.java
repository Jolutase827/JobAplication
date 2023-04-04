package es.ieslavereda.myrecicleviewexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProfesionRepository {
    private List<Profesion> profesions;
    private static ProfesionRepository instance;

    private  ProfesionRepository(){
        profesions = new ArrayList<>();

        profesions.add(new Profesion("Actor", R.mipmap.ic_actor_foreground));
        profesions.add(new Profesion("Albanyil", R.mipmap.ic_albanyil_foreground));
        profesions.add(new Profesion( "Banquero", R.mipmap.ic_banquero_foreground));
        profesions.add(new Profesion( "Cocinero", R.mipmap.ic_cocinero_foreground));
        profesions.add(new Profesion("Estudiante", R.mipmap.ic_estudiante_foreground));
        profesions.add(new Profesion( "Instagramer", R.mipmap.ic_instagramer_foreground));
        profesions.add(new Profesion( "Pintor", R.mipmap.ic_pintor_foreground));
        profesions.add(new Profesion( "Policia", R.mipmap.ic_policia_foreground));
        profesions.add(new Profesion("Politico(activo)", R.mipmap.ic_politico_activo_foreground));
        profesions.add(new Profesion("Politico(retirado)", R.mipmap.ic_politico_retirado_foreground));
        profesions.add(new Profesion("Vendedor", R.mipmap.ic_vendedor_foreground));
        profesions.add(new Profesion( "Youtuber", R.mipmap.ic_youtuber_foreground));
    }
    public static ProfesionRepository getInstance(){
        if (instance==null)
            instance = new ProfesionRepository();

        return instance;
    }

    public List<Profesion> getAll(){
        return new ArrayList<>(profesions);
    }

    public Profesion getProfesionByImage(int image){
        Optional<Profesion> optionalProfesion= profesions.stream()
                .filter(p->p.getImagen()==image)
                .findFirst();

        if (optionalProfesion.isPresent())
            return optionalProfesion.get();

        return null;
    }

    public Profesion getProfesionByName(String name){
        Optional<Profesion> optionalProfesion= profesions.stream()
                .filter(p->p.getNombre().equalsIgnoreCase(name))
                .findFirst();

        if (optionalProfesion.isPresent())
            return optionalProfesion.get();

        return null;
    }

}
