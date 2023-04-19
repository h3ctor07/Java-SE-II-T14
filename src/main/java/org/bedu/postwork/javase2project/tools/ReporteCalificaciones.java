package org.bedu.postwork.javase2project.tools;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReporteCalificaciones {
    public static List<String> obtenerReporte(List<Curso> cursos) {

        // Ordenar cursos alfabéticamente por nombre de materia
        cursos.sort(Comparator.comparing(c -> c.getMateria().getNombre()));

        List<String> reporte = new ArrayList<>();

        // Recorrer cada curso y obtener el reporte de calificaciones
        cursos.forEach(curso -> {
            Map<Estudiante, Integer> calificaciones = curso.getCalificaciones();
            String nombreMateria = curso.getMateria().getNombre();

            List<String> reporteCurso = calificaciones.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .map(entry -> entry.getKey().getNombreCompleto() + " - " + nombreMateria + " - " + entry.getValue())
                    .collect(Collectors.toList());

            reporte.addAll(reporteCurso);
        });

        return reporte;
    }
}


