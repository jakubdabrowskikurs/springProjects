package spring.hibernate;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Printer")
@ToString
@RequiredArgsConstructor
public class Printer implements HibernateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "model")
    @Getter @Setter
    @NonNull
    private String model;


    @Column(name = "producer")
    @Getter @Setter
    @NonNull
    private String producer;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false, referencedColumnName = "ID")
    @Getter @Setter
    @NonNull
    public Employees employees;

    public Printer(){}

}
