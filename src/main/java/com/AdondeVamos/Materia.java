package com.AdondeVamos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Materia {

    @Setter
    private String nombre;
    private List<Materia> correlativas;

    public Boolean cumpleCorrelativas(Alumno alumno){
        return correlativas.stream().allMatch(alumno::materiaAprobada);
    }

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }

    public void agregarCorrelativas(Materia ... materias){
        Collections.addAll(this.correlativas, materias);
    }
}
