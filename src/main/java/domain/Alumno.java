package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    private String nombreAlu;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombreAlu){
        this.nombreAlu = nombreAlu;
        this.materiasAprobadas = new ArrayList<>();
    }

    public Boolean puedeCursar(Materia materia) {
        return materia.puedeSerCursada(this.materiasAprobadas);
    }

    public void agregarMateriasAprob(Materia ... materias) {
        Collections.addAll(this.materiasAprobadas, materias);
    }
}
