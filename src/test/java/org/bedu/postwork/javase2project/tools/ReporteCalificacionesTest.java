package org.bedu.postwork.javase2project.tools;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReporteCalificacionesTest {
    //declaramos las variables de los datos
    private static final Materia materia = new Materia();
    private static final Curso curso   = new Curso();
    private static final Estudiante est1 = new Estudiante();
    private static final Estudiante est2 = new Estudiante();
    private static final Estudiante est3 = new Estudiante();

    // declaramos 3 reportes donde guardaremos los reportes que esperamos reibir en las pruebas
    private static Reporte reporte1 = new Reporte();
    private static Reporte reporte2 = new Reporte();
    private static Reporte reporte3 = new Reporte();

    //inicializamos los estudiantes, curso, materia y calificaciones, asi como los reportes que esperamos obtener
    @BeforeAll
    public static void init() {
        materia.setNombre("Programacion");
        est1.setNombreCompleto("Juan Pérez");
        est2.setNombreCompleto("María Gómez");
        est3.setNombreCompleto("Pedro Hernández");

        curso.setMateria(materia);
        curso.setCiclo("2023");

        Map<Estudiante, Integer> calificaciones = new HashMap<>();
        calificaciones.put(est1, 80);
        calificaciones.put(est2, 90);
        calificaciones.put(est3, 75);

        curso.setCalificaciones(calificaciones);

        reporte1.setNombreEstudiante("Pedro Hernández");
        reporte2.setNombreEstudiante("María Gómez");
        reporte3.setNombreEstudiante("Juan Pérez");
    }

    @Test
    @DisplayName("Orden alfabetico por curso")
    public void testAlfabetico() {
        // Creamos un reporte y lo ordenamos alfabeticamente por nombre
        ReporteCalificaciones reporteCalificaciones = new ReporteCalificaciones();
        List<Reporte> lista = reporteCalificaciones.alfabetico(curso);

        // Comprobamos que la lista esté ordenada correctamente
        assertEquals(lista.get(0).getNombreEstudiante(), "Juan Pérez");
        assertEquals(lista.get(1).getNombreEstudiante(), "María Gómez");
        assertEquals(lista.get(2).getNombreEstudiante(), "Pedro Hernández");
    }

    @Test
    @DisplayName("Orden descendente por calificación")
    public void testCalificacion() {
        // Creamos un reporte y lo ordenamos por calificaciones descendentes
        ReporteCalificaciones reporteCalificaciones = new ReporteCalificaciones();
        List<Reporte> lista = reporteCalificaciones.calificacion(curso);

        // Comprobamos que la lista esté ordenada correctamente
        assertEquals(lista.get(0).getNombreEstudiante(), "María Gómez");
        assertEquals(lista.get(1).getNombreEstudiante(), "Juan Pérez");
        assertEquals(lista.get(2).getNombreEstudiante(), "Pedro Hernández");
    }
}