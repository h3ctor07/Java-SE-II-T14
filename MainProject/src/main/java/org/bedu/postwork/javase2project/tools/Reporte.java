package org.bedu.postwork.javase2project.tools;

import java.util.Objects;

public class Reporte {
    private String nombreEstudiante;
    private int calificacion;


    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public int getCalificación() {
        return calificacion;
    }

    public void setCalificación(int calificación) {
        this.calificacion = calificación;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reporte reporte = (Reporte) o;
        return calificacion == reporte.calificacion && nombreEstudiante.equals(reporte.nombreEstudiante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreEstudiante, calificacion);
    }
}
