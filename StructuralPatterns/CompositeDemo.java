import java.util.ArrayList;
import java.util.List;

// Abstract class representing a component of a government department
abstract class DepartmentComponent {
    public abstract void display();
}

// Concrete class representing a service offered by a government department
class Service extends DepartmentComponent {
    private String name;

    public Service(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Service: " + name);
    }
}

// Concrete class representing a government department
class Department extends DepartmentComponent {
    private String name;
    private List<DepartmentComponent> components;

    public Department(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void display() {
        System.out.println("Department: " + name);
        for (DepartmentComponent component : components) {
            component.display();
        }
    }

    public void addComponent(DepartmentComponent component) {
        components.add(component);
    }
}

public class CompositeDemo {
    public static void main(String[] args) {
        // Create leaf objects (services)
        DepartmentComponent service1 = new Service("Taxation Service");
        DepartmentComponent service2 = new Service("Healthcare Service");

        // Create a composite object (department)
        Department department = new Department("Ministry of Governance");

        // Add leaf objects to the department
        department.addComponent(service1);
        department.addComponent(service2);

        // Display the department (including its services)
        department.display();
    }
}
