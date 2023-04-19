package org.bedu.postwork.javase2project.tools;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;

import java.util.*;

public class PostWork3 {
    private static Curso generaCurso(Random random, String nomMateria, long IdCurso) {

        Curso curso1 = new Curso();
        curso1.setId(IdCurso);
        Materia materia1 = new Materia();
        materia1.setNombre(nomMateria);

        curso1.setMateria(materia1);
        Map<Estudiante, Integer> calificaciones = new HashMap<>();

        for (int i = 0; i < 20; i++) {
            Estudiante estudiante = new Estudiante();
            estudiante.setId((long) i);
            estudiante.setNombreCompleto("Estudiante " + i);
            calificaciones.put(estudiante, random.nextInt(50) + 51);
            System.out.println("Curso: " + curso1.getId() + " Nombre: " + estudiante.getNombreCompleto() + " " + materia1.getNombre() + " Calificación: " + calificaciones.get(estudiante));
        }
        curso1.setCalificaciones(calificaciones);
        return curso1;
    }
    public static void main(String[] args) {
        Random random = new Random();
        List<Curso> cursos = new ArrayList<>();

        cursos.add(generaCurso(random, "Gestión de base de datos",2));
        cursos.add(generaCurso(random, "Programación Funcional",3));
        cursos.add(generaCurso(random, "Multihilos y procesos recurrentes",1));


        List<String> reporte = ReporteCalificaciones.obtenerReporte(cursos);


        System.out.println("Reporte de calificaciones:");
        reporte.forEach(System.out::println);
    }
}