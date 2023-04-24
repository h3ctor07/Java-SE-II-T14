package org.bedu.postwork.javase2project.tools;

import org.aspectj.lang.annotation.Before;
import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReporteCalificacionesTest {
    private Map<Estudiante, Integer> getCalificaciones() {
        // Creamos tres estudiantes
        Estudiante est1 = new Estudiante();
        est1.setNombreCompleto("Juan Pérez");
        Estudiante est2 = new Estudiante();
        est2.setNombreCompleto("María Gómez");
        Estudiante est3 = new Estudiante();
        est3.setNombreCompleto("Pedro Hernández");

        // Creamos un mapa con las calificaciones de los estudiantes en un curso
        Map<Estudiante, Integer> calificaciones = new HashMap<>();
        calificaciones.put(est1, 80);
        calificaciones.put(est2, 90);
        calificaciones.put(est3, 75);

        return calificaciones;
    }

    private Curso getCurso() {
        // Creamos un curso con las calificaciones
        Curso curso = new Curso();
        curso.setCiclo("2022-1");
        curso.setCalificaciones(getCalificaciones());

        return curso;
    }

    @Test
    @DisplayName("Orden alfabetico por curso")
    public void testAlfabetico() {
        // Creamos un curso con las calificaciones
        Curso curso = getCurso();

        // Creamos un reporte y lo ordenamos alfabéticamente por curso
        ReporteCalificaciones reporte = new ReporteCalificaciones();
        List<Reporte> lista = reporte.alfabetico(curso);

        // Comprobamos que la lista esté ordenada correctamente
        assertEquals(lista.get(0).getNombreEstudiante(), "Juan Pérez");
        assertEquals(lista.get(1).getNombreEstudiante(), "María Gómez");
        assertEquals(lista.get(2).getNombreEstudiante(), "Pedro Hernández");

    }

    @Test
    @DisplayName("Orden descendente por calificación")
    public void testCalificacion() {
        // Creamos un curso con las calificaciones
        Curso curso = getCurso();

        // Creamos un reporte y lo ordenamos por calificaciones descendentes
        ReporteCalificaciones reporte = new ReporteCalificaciones();
        List<Reporte> lista = reporte.calificacion(curso);

        // Comprobamos que la lista esté ordenada correctamente
        assertEquals(lista.get(0).getNombreEstudiante(), "María Gómez");
        assertEquals(lista.get(1).getNombreEstudiante(), "Juan Pérez");
        assertEquals(lista.get(2).getNombreEstudiante(), "Pedro Hernández");
    }
}