package org.bedu.postwork.javase2project.tools;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ReporteCalificaciones {
    private List<Reporte> generaLista(Map<Estudiante, Integer> calificaciones, Comparator<Reporte> comparator) {
        return calificaciones.entrySet()
                .stream()
                .map(entry -> {
                    Reporte reporte = new Reporte();
                    reporte.setNombreEstudiante(entry.getKey().getNombreCompleto());
                    reporte.setCalificación(entry.getValue());
                    return reporte;
                })
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public List<Reporte> alfabetico(Curso curso) {
        Map<Estudiante, Integer> calificaciones = curso.getCalificaciones();
        Comparator<Reporte> comparator = Comparator.comparing(Reporte::getNombreEstudiante);
        return generaLista(calificaciones, comparator);
    }

    public List<Reporte> calificacion(Curso curso) {
        Map<Estudiante, Integer> calificaciones = curso.getCalificaciones();
        Comparator<Reporte> comparator = Comparator.comparing(Reporte::getCalificación).reversed();
        return generaLista(calificaciones, comparator);
    }

}


