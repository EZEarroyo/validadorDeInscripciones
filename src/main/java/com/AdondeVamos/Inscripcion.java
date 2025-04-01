package com.AdondeVamos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Inscripcion {
    @Setter
    private Alumno alumno;
    private List<Materia> materiasInscripcion;

    public Boolean aprobada() {
       if (materiasInscripcion.isEmpty()) {
           return false;
       } else {
           return this.materiasInscripcion.stream().allMatch(m -> m.cumpleCorrelativas(this.alumno));
       }
   }

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materiasInscripcion = new ArrayList<>();
    }

    public void agregarMateriasALaInscripcion(Materia ... materias){
        Collections.addAll(this.materiasInscripcion, materias);
    }

}
