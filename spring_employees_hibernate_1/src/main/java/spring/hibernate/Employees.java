package spring.hibernate;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Employees")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "LastName")
    @NonNull
    private String lastName;

    @Column(name = "FirstName")
    @NonNull
    private String firstName;

    @Column(name = "Address")
    @NonNull
    private String address;

    @Column(name = "City")
    @NonNull
    private String city;

    @Column(name = "Salary")
    @NonNull
    private int salary;

    @Column(name = "Age")
    @NonNull
    private int age;

    @Column(name = "StartJobDate")
    @NonNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date startJobDate;

    @Column(name = "Benefit")
    @NonNull
    private int benefit;

    @Column(name = "Email")
    @Getter @Setter
    private String email;

    public Employees(){}

}
