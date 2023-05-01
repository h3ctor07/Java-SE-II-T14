package org.bedu.postwork.javase2project.async;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InscripcionAlumnos {
    public static void main(String[] args) {
        Random random = new Random();

        ReceptorSolicitudes eventLoop = new ReceptorSolicitudes(solicitud -> {
           if (solicitud.getEstudiante() == null || solicitud.getCurso() == null) {
               System.out.println("Solicitude rechazaad por datos incompletos");
           }
            System.out.println("El estudiante: [" + solicitud.getEstudiante().getNombreCompleto()
                    + "] se ha inscrito a la materia" + solicitud.getCurso().getMateria().getNombre());
        });

        eventLoop.iniciar();
        SolicitudEstudiante[] solicitudes = crearSolicitudes();

        for (SolicitudEstudiante solicitud: solicitudes) {
            eventLoop.registrarEvento(solicitud);
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        eventLoop.detener();
    }

    private static SolicitudEstudiante[] crearSolicitudes(){
        Random random = new Random();
        Curso[] cursos = new Curso[]{
          crearCurso(random, "Curso A", 1),
          crearCurso(random, "Curso B", 2),
          crearCurso(random, "Curso C", 3),
          crearCurso(random, "Curso D", 4)
        };

        SolicitudEstudiante[] solictudes = new SolicitudEstudiante[20];

        for (int i = 0; i < 20; i++) {
            Estudiante estudiante = new Estudiante();
            estudiante.setNombreCompleto("Estudiante " + i);
            estudiante.setId((long) i);

            solictudes[i] = new SolicitudEstudiante(estudiante, cursos[random.nextInt(cursos.length)]);
        }

        return solictudes;
    }

    private static Curso crearCurso(Random random, String nombreMateria, long idCurso){
        Materia materia = new Materia();
        materia.setNombre(nombreMateria);

        Curso curso = new Curso();
        curso.setId(idCurso);
        curso.setMateria(materia);
        return curso;
    }
}
