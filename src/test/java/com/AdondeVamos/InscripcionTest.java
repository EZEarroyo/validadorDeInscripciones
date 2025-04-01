package com.AdondeVamos;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class InscripcionTest {

    private Materia am1;
    private Materia algebra;
    private Materia discreta;
    private Materia am2;
    private Materia paradigma;

    @BeforeEach
    public void MateriasInit(){
        //Materias del primer año
        am1 = new Materia("Analisis Matematico 1");
        algebra = new Materia ("Álgebra y Geometría Analítica");
        discreta = new Materia("Matematica discreta");

        //Materias del segundo año
        am2 = new Materia("Analisis Matematico 2");
        am2.agregarCorrelativas(am1,algebra);
        paradigma = new Materia("Paradigmas de Programación");
        paradigma.agregarCorrelativas(discreta);
    }



    @Test
    @DisplayName("El Alumno se pudo inscribir correctamente a la materia AM1")
    public void InscripcionAUnaMateriaSinCorrelativaAprobada(){

        Alumno alumnoConCorrelativasAprobadas = new Alumno("Ezequiel");

        Inscripcion inscripcion = new Inscripcion(alumnoConCorrelativasAprobadas);
        inscripcion.agregarMateriasALaInscripcion(am1);

        Assertions.assertEquals(true, inscripcion.aprobada());

    }

    @Test
    @DisplayName("El Alumno se inscribio correctamente a la materia AM2 y paradigma")
    public void InscripcionDosMateriasAprobada(){

        Alumno alumnoConCorrelativasAprobadas = new Alumno("Ezequiel");
        alumnoConCorrelativasAprobadas.agregarMateriasAprobadas(am1,algebra,discreta);

        Inscripcion inscripcion = new Inscripcion(alumnoConCorrelativasAprobadas);
        inscripcion.agregarMateriasALaInscripcion(am2,paradigma);

        Assertions.assertEquals(true, inscripcion.aprobada());

    }

    @Test
    @DisplayName("El alumno fue rechazado porque no tiene discreta aprovada")
    public void InscripcionDosMateriasRechazada(){

        Alumno alumnoSinCorrelativasAprobadas = new Alumno("Ezequiel");
        alumnoSinCorrelativasAprobadas.agregarMateriasAprobadas(am1,algebra);

        Inscripcion inscripcion = new Inscripcion(alumnoSinCorrelativasAprobadas);
        inscripcion.agregarMateriasALaInscripcion(am2,paradigma);

        Assertions.assertEquals(false, inscripcion.aprobada());

    }

    @Test
    @DisplayName("El alumno fue rechazado porque las materias solicitadas es vacia")
    public void InscripcionANingunaMateria(){

        Alumno alumnoConCorrelativasAprobadas = new Alumno("Ezequiel");
        alumnoConCorrelativasAprobadas.agregarMateriasAprobadas(am1,algebra);

        Inscripcion inscripcion = new Inscripcion(alumnoConCorrelativasAprobadas);

        Assertions.assertEquals(false, inscripcion.aprobada());

    }
}