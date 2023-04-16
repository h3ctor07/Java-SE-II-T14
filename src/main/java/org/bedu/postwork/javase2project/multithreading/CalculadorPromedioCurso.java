package org.bedu.postwork.javase2project.multithreading;

import org.bedu.postwork.javase2project.model.Curso;

public class CalculadorPromedioCurso implements Runnable{
    private Curso curso;
    private double promedio;

    public CalculadorPromedioCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public void run(){
        int alumnos =0;
        for(int calificacion :curso.getCalificaciones().values()){
            promedio += calificacion;
            alumnos++;
        }
        promedio=promedio/alumnos;
        System.out.println("Promedio:" + curso.getId()+" " + curso.getMateria().getNombre()+ " = "+promedio);
    }
}
