package spring.hibernate;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Phones")
@Data
@RequiredArgsConstructor
public class Phones implements HibernateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false, referencedColumnName="ID")
    @NonNull
    public Employees employees;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "model")
    @NonNull
    private String model;

    public Phones(){};
}

