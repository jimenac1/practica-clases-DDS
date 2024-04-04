package domain;


import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class InscripcionTest {

    @Test

    public void NoCumplenLaCorrelativaDeUnaMateriaSeRechazaLaInscripcion(){


        Materia syo = new Materia( "SYO");
        Materia mateDiscreta = new Materia("Matematica Discreta");
        Materia AYDE = new Materia("AYDE");
        Materia algebra = new Materia("Algebra");

        Materia ADS = new Materia("Analisis De Sistemas");;
        Materia PDP = new Materia("Paradigmas");

        ADS.agregarCorrelativas(syo, AYDE);
        PDP.agregarCorrelativas(mateDiscreta, AYDE);

        Alumno alu = new Alumno( "GABI");
        alu.agregarMateriasAprob(syo,AYDE);


        Inscripcion unaInscripcion = new Inscripcion(alu);
        unaInscripcion.agregarMateriasSol(ADS,PDP);

        Assert.assertEquals(false, unaInscripcion.aprobada().booleanValue());

    }
    @Test

    public void lasMateriasSolicitadasNoTienenCorrelativasLaInscripcionSeAprueba(){

        Materia syo = new Materia( "SYO");
        Materia am1 = new Materia( "AM1");
        Materia mateDiscreta = new Materia("Matematica Discreta");

        Alumno alu = new Alumno( "GABI");

        Inscripcion unaInscripcion = new Inscripcion(alu);
        unaInscripcion.agregarMateriasSol(syo, am1, mateDiscreta);

        Assert.assertEquals(true, unaInscripcion.aprobada().booleanValue());
    }

    @Test
    public void cumpleTodasLasCorrelativasLaInscripcionSeAprueba(){

        Materia syo = new Materia( "SYO");
        Materia mateDiscreta = new Materia("Matematica Discreta");
        Materia AYDE = new Materia("AYDE");

        Materia ADS = new Materia("Analisis De Sistemas");
        Materia SYSL = new Materia("Sintaxis");
        Materia PDP = new Materia("Paradigmas");

        ADS.agregarCorrelativas(syo, AYDE);
        SYSL.agregarCorrelativas(mateDiscreta, AYDE);
        PDP.agregarCorrelativas(mateDiscreta, AYDE);

        Alumno alu = new Alumno( "GABI");
        alu.agregarMateriasAprob(syo,AYDE,mateDiscreta);



        Inscripcion unaInscripcion = new Inscripcion(alu);
        unaInscripcion.agregarMateriasSol(ADS,PDP, SYSL);

        Assert.assertEquals(true, unaInscripcion.aprobada().booleanValue());
    }

    @Test

    public void noCumpleNingunaCorrelativaSeRechazaLaInscripcion(){


        Materia am1 = new Materia( "AM1");
        Materia mateDiscreta = new Materia("Matematica Discreta");
        Materia AYDE = new Materia("AYDE");
        Materia algebra = new Materia("Algebra");

        Materia SYSL = new Materia("Sintaxis");
        Materia PDP = new Materia("Paradigmas");

        SYSL.agregarCorrelativas(mateDiscreta, AYDE);
        PDP.agregarCorrelativas(mateDiscreta, AYDE);

        Alumno alu = new Alumno( "GABI");
        alu.agregarMateriasAprob(am1, algebra);


        Inscripcion unaInscripcion = new Inscripcion(alu);
        unaInscripcion.agregarMateriasSol(SYSL, PDP);

        Assert.assertEquals(false, unaInscripcion.aprobada().booleanValue());
    }



}
