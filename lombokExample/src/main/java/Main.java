import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Lombok lombok = new Lombok();
        lombok.setName("Lombok Test");
        lombok.setAge(12);
        lombok.setDate(new Date());

        System.out.println(lombok);

        System.out.println("==========");

        Standard standard = new Standard();
        standard.setName("Standard Test");
        standard.setAge(15);
        standard.setDate(new Date());

        System.out.println(standard);

        LombokConstr lombokConstr = new LombokConstr(15, new Date());
        System.out.println(lombokConstr);


    }
}
