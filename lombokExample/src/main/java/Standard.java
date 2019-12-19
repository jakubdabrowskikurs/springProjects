import java.util.Date;

public class Standard {

    public Standard(){}

    public Standard(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    private String name;
    private int age;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Standard{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
}
