package org.bedu.postwork.javase2project.multithreading;
//Esta clase se agrega para que solo tenga una sola responsabilidad
public class ImprimeResultadoConsola implements ResultadoPromedio{
    @Override
    public void imprimeResultado(long id, String nomMateria, double promedio){
        System.out.println("Promedio: " + id + " " + nomMateria + " = " + promedio);
    }
}
