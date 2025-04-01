package com.AdondeVamos;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
@Getter
public class Alumno {
    @Setter
    private String nombre;
    private List<Materia> materiasAprobadas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.materiasAprobadas = new ArrayList<>();
    }

    public void agregarMateriasAprobadas(Materia ... materias){
        Collections.addAll(this.materiasAprobadas, materias);
    }


    public Boolean materiaAprobada(Materia materia){
        return this.materiasAprobadas.contains(materia);
    }
}
