package org.bedu.postwork.javase2project.reactive;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CalculaPromedioCursoRxTest {

    private static final Curso CURSO = new Curso();

    static {
        Estudiante estudiante1 = new Estudiante();
        Estudiante estudiante2 = new Estudiante();
        Estudiante estudiante3 = new Estudiante();

        estudiante1.setNombreCompleto("Estudiante 1");
        estudiante2.setNombreCompleto("Estudiante 2");
        estudiante3.setNombreCompleto("Estudiante 3");

        Materia materia = new Materia();
        materia.setNombre("Materia");

        CURSO.setCiclo("2023");
        CURSO.setMateria(materia);

        Map<Estudiante, Integer> calificaciones = new HashMap<>();
        calificaciones.put(estudiante1, 6);
        calificaciones.put(estudiante2, 8);
        calificaciones.put(estudiante3, 9);

        CURSO.setCalificaciones(calificaciones);
    }
    @Test
    @DisplayName("Postwork 5")
    void calcularPromedio () {
        CalculaPromedioCursoRx calc = new CalculaPromedioCursoRx();

        calc.calculaPromedio(CURSO)
                .subscribe(s -> assertThat(s).isEqualTo(7.66, within(0.1)));
    }

}