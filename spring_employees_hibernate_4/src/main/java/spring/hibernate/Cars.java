package spring.hibernate;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Cars")
@Data
@AllArgsConstructor
public class Cars implements HibernateEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false, referencedColumnName="ID")
    @Getter @Setter
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public Employees employees;

    @Column(name = "Name")
    private String name;

    @Column(name = "Model")
    private String model;

    @Column(name = "RegistrationDate")
    @ToString.Exclude
    private Date registrationDate;

    public Cars() {}
}
