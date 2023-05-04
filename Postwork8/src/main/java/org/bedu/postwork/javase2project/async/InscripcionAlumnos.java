package org.bedu.postwork.javase2project.async;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.CursoFactory;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InscripcionAlumnos {
    public static void main(String[] args) {
        Random random = new Random();

        ReceptorSolicitudes eventLoop = new ReceptorSolicitudes(solicitud -> {
           if (solicitud.getEstudiante() == null || solicitud.getCurso() == null) {
               System.out.println("Solicitude rechazada por datos incompletos");
           }
            System.out.println("El estudiante: [" + solicitud.getEstudiante().getNombreCompleto()
                    + "] se ha inscrito a la materia " + solicitud.getCurso().getMateria().getNombre());
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
                CursoFactory.crearCurso(1),
                CursoFactory.crearCurso(2),
                CursoFactory.crearCurso(3),
                CursoFactory.crearCurso(4),
                CursoFactory.crearCurso(5),
                CursoFactory.crearCurso(6),
                CursoFactory.crearCurso(7),
                CursoFactory.crearCurso(8)
         /* crearCurso(random, "Gestión de base de datos", 1),
          crearCurso(random, "Multihilos y procesos recurrentes", 2),
          crearCurso(random, "Procesos Asincronos", 3),
          crearCurso(random, "Procesos Asincronos", 4),
          crearCurso(random, "Stream Reactivos", 5)*/
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

/*    private static Curso crearCurso(Random random, String nombreMateria, long idCurso){
        Materia materia = new Materia();
        materia.setNombre(nombreMateria);

        Curso curso = new Curso();
        curso.setId(idCurso);
        curso.setMateria(materia);
        return curso;
    }*/
}
