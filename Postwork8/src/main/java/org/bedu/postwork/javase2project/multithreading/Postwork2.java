package org.bedu.postwork.javase2project.multithreading;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.bedu.postwork.javase2project.model.CursoFactory;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Postwork2 {

    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService pool = Executors.newCachedThreadPool();
        ///////////////////////////////////
/*Se implementa una clase con ese código que se repite tambien en inscripción de alumnos*/
        ////////////////////////////
        Curso[] cursos = new Curso[]{
                CursoFactory.crearCurso(1),
                CursoFactory.crearCurso(2),
                CursoFactory.crearCurso(3),
                CursoFactory.crearCurso(4),
                CursoFactory.crearCurso(5),
                CursoFactory.crearCurso(6),
                CursoFactory.crearCurso(7),
                CursoFactory.crearCurso(8)
                /*generaCurso(random, "Gestión de base de datos",1),
                generaCurso(random, "Multihilos y procesos recurrentes",2),
                generaCurso(random, "Programación Funcional",3),
                generaCurso(random, "Procesos Asincronos",4),
                generaCurso(random, "Stream Reactivos",5)*/

        }; //fin cursos
        ResultadoPromedio resultadoPromedio = new ImprimeResultadoConsola();
        for (Curso curso : cursos){
          pool.execute(new CalculadorPromedioCurso(curso,resultadoPromedio));
        }//fin for
        pool.shutdown();

     }//fin main


 /* private static Curso generaCurso(Random random, String nomMateria, long IdCurso){

        Curso curso1 = new Curso();
        curso1.setId(IdCurso);
        Materia materia1 = new Materia();
        materia1.setNombre(nomMateria);

        curso1.setMateria(materia1);
        Map<Estudiante, Integer> calificaciones = new HashMap<>();

        for (int i = 0; i<20; i++){
            Estudiante estudiante = new Estudiante();
            estudiante.setId((long)i);
            estudiante.setNombreCompleto("Estudiante "+i);
            calificaciones.put(estudiante, random.nextInt(50) + 51);
            System.out.println("Curso: "+curso1.getId() + " Nombre: " + estudiante.getNombreCompleto()+  " " + materia1.getNombre() + " Calificación: " + calificaciones.get(estudiante));
        }
        curso1.setCalificaciones(calificaciones);

        return curso1;

    }//fin genera curso*/
}//fin de clase
