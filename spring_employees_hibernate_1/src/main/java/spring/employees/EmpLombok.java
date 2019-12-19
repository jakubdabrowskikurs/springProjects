package spring.employees;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmpLombok {
    private int id;
    private String name;
    private float salary;
    private String designation;

    private EmpLombok(){}
}
