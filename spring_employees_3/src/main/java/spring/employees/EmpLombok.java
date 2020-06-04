package spring.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpLombok {
    private int id;
    private String name;
    private float salary;
    private String designation;

}
