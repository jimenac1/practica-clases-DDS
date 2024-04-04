package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Materia {
    private String nombre;
    private List<Materia> materiasCorrelativas;

    public Materia (String nombreMateria){
        this.nombre = nombreMateria;
        this.materiasCorrelativas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean puedeSerCursada(List<Materia> materiasAprobadas) {
        if(this.materiasCorrelativas.isEmpty())
            return true;
        else {
            List<String> aprobadas =
                    this.nombresMaterias(materiasAprobadas);
            List<String> correlativas =
                    this.nombresMaterias(materiasCorrelativas);

            return correlativas.stream().
                    map(c -> aprobadas.contains(c)).
                    allMatch(m -> m == true);
        }
    }

    public List<String> nombresMaterias(List<Materia> materias) {
        return materias.stream().
                map(m -> m.getNombre()).
                collect(Collectors.toList());
    }

    public void agregarCorrelativas(Materia ... materias) {
        Collections.addAll(this.materiasCorrelativas, materias);
    }
}


