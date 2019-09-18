import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ObjectToStringTutor extends Tutor {
    class Employee {
        public String name;
        public String surname;
        public int age;

        public Employee(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }
    }

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("John", "Smith", 35));
        employees.add(new Employee("John", "Smith", 30));
        employees.add(new Employee("John", "Jones", 25));
        employees.add(new Employee("John", "James", 25));
        return employees;
    }

    @Test
    public void testEmployees() {
        List<Employee> employees = getEmployees();
        int index=0;
        for (Employee employee: employees) {
            log("emp"+ index++ +"="+employee);
        }
    }

}
