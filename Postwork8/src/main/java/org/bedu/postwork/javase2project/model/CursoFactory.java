package org.bedu.postwork.javase2project.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CursoFactory {

    private static final String[] MATERIAS = {
            "Gestión de base de datos",
            "Multihilos y procesos recurrentes",
            "Programación Funcional",
            "Procesos Asincronos",
            "Stream Reactivos",
            "Clases Genéricas",
            "Microservicios",
            "Buenas Practicas"
    };
    private static final int NUM_ESTUDIANTES = 20;

    public static Curso crearCurso(long idCurso) {
        Random random = new Random();

        Curso curso = new Curso();
        curso.setId(idCurso);

        Materia materia = new Materia();
        materia.setNombre(MATERIAS[random.nextInt(MATERIAS.length)]);

        curso.setMateria(materia);

        Map<Estudiante, Integer> calificaciones = new HashMap<>();
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            Estudiante estudiante = new Estudiante();
            estudiante.setId((long) i);
            estudiante.setNombreCompleto("Estudiante " + i);

            int calificacion = random.nextInt(50) + 51;
            calificaciones.put(estudiante, calificacion);

            System.out.printf("Curso: %d Nombre: %s %s Calificación: %d%n",
                    curso.getId(), estudiante.getNombreCompleto(), materia.getNombre(), calificacion);
        }

        curso.setCalificaciones(calificaciones);
        return curso;
    }
}