import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;


/**
 * Implement the class Employee methods hashCode () and equals () so
 * Compared to the full name, but not the age of the employee.
 *
 */
public class ObjectEqualsTutor{
    enum EmployeeType {
        ByName, ByFullName, ByAge, Default
    }
    class Employee {
        public String name;
        public String surname;
        public int age;

        public Employee(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }
        public String getFullName() {
            return this.name+" "+this.surname;
        }

        public String toString() {
            return this.name+" "+this.surname+", age:"+age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Employee employee = (Employee) o;

            if (!name.equals(employee.name)) return false;
            return surname.equals(employee.surname);

        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + surname.hashCode();
            return result;
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

    public Set<Employee> getEmployeesSet(EmployeeType type) {
        Set<Employee> employeesSet = new HashSet<Employee>();
        employeesSet.addAll(getEmployees());
        return employeesSet;
    }

    @Test
    public void testEmployees() {
        List<Employee> employees = getEmployees();
        int index=0;
        for (Employee employee: employees) {
//            log("emp"+ index++ +"="+employee);
        }

//        log("***“Test equals: ***");
        employees = getEmployees();
        for (int i=0;i<3;i++) {
//            log("emp"+i+".equals(emp"+(i+1)+")="+
//                    employees.get(i).equals(employees.get(i+1)));
        }
        assertEquals(employees.get(0), employees.get(1));
        assertNotSame(employees.get(1), employees.get(2));
        assertNotSame(employees.get(2), employees.get(3));
    }

    @Test
    public void testEmployeesSet() {
        Set<Employee> employeesSet;
//        log("***Test HashSet: Employee");
        employeesSet = getEmployeesSet(EmployeeType.ByName);
        for (Employee employee: employeesSet) {
//            log(employee);
        }
        assertEquals(employeesSet.size(), 3);
    }
}
