package org.bedu.postwork.javase2project.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "cursos")
public class Curso {
    @Transient
    public final Integer NO_CALIFICADO = -100;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "materias_fk", referencedColumnName = "id")
    private Materia materia;
    @Size(max = 4)
    private String ciclo;

    @ElementCollection
    @CollectionTable(name = "cursos_has_estudiantes", joinColumns = @JoinColumn(name = "cursos_fk"))
    @MapKeyJoinColumn(name = "estudiantes_fk")
    @Column(name = "calificacion")
    private Map<Estudiante, Integer> calificaciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Map<Estudiante, Integer> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Map<Estudiante, Integer> calificaciones) {
        this.calificaciones = calificaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return id.equals(curso.id) &&
                Objects.equals(materia, curso.materia) &&
                Objects.equals(ciclo, curso.ciclo) &&
                Objects.equals(calificaciones, curso.calificaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, materia, ciclo, calificaciones);
    }
}
