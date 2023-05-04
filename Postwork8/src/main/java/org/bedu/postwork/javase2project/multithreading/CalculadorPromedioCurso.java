package org.bedu.postwork.javase2project.multithreading;

import org.bedu.postwork.javase2project.model.Curso;
//Se divide la clase en dos
/*
    Una que calcula el promedio con solo una responsabilidad
    ImprimeeResultadoConsola que se encarga de imprimir los resultados
    además se aplica el pincipio de segregación de interfaz al dividir en dos clases
 */
public class CalculadorPromedioCurso implements Runnable{
    private Curso curso;
    private double promedio;
    private ResultadoPromedio resultadoPromedio;

    public CalculadorPromedioCurso(Curso curso, ResultadoPromedio resultadoPromedio) {
        this.curso = curso;
        this.resultadoPromedio=resultadoPromedio;
    }

    @Override
    public void run(){
        int alumnos =0;
        for(int calificacion :curso.getCalificaciones().values()){
            promedio += calificacion;
            alumnos++;
        }
        promedio=promedio/alumnos;
        resultadoPromedio.imprimeResultado(curso.getId(),curso.getMateria().getNombre(),promedio);
        //System.out.println("Promedio: " + curso.getId()+" " + curso.getMateria().getNombre()+ " = "+promedio);
    }
}
