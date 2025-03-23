import java.util.Arrays;

class Employee {
    int id;
    String name;
    double salary;
    String[] skill;

    public Employee(int id, String name, double salary, String[] skill1) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.skill = skill1;
    }

    public double yearlySalary() {
        return salary * 12;
    }

    public double yearlySalary(int bonus) {
        return salary * 12 + bonus;
    }

    public void display() {
        System.out.println("ID: " + id + "\nName: " + name + "\nMonthly Salary: $" + salary +
                "\nYearly Salary without bonus : $" + yearlySalary() + "\nSkill: " + Arrays.toString(this.skill));
    }
}
public class BasicTask {
    public static void main(String[] args) {
        String []skill1={"java","Spring","SQL"};
        Employee emp1=new Employee(12345,"John doe",5500,skill1);
        emp1.display();
        String []skill2={"java","Spring","SQL","C++","CSS","Html","Java Script"};
        Employee emp2=new Employee(67891,"Ali",99900,skill2);
        emp2.display();


    }
}