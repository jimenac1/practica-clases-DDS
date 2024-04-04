package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materiasSolicitadas;

    public Inscripcion (Alumno alumno){
        this.alumno = alumno;
        this.materiasSolicitadas = new ArrayList<>();
    }
    public Boolean aprobada(){
        return materiasSolicitadas.stream().
                map(m -> this.alumno.puedeCursar(m)).
                allMatch(m-> m == true);
    }

    public void agregarMateriasSol(Materia ... materias) {
        Collections.addAll(this.materiasSolicitadas, materias);
    }

}
