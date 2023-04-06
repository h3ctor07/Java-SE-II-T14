package org.bedu.postwork.javase2project.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Map;

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
}
