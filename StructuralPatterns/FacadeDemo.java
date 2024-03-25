// Define the Service interface
interface Service {
    void display();
}

// Implementation for AdministrativeService
class AdministrativeService implements Service {
    @Override
    public void display() {
        System.out.println("Administrative Service: // List of administrative services offered");
        // Display administrative services offered by the department
    }
}

// Implementation for CitizenService
class CitizenService implements Service {
    @Override
    public void display() {
        System.out.println("Citizen Service: // List of citizen services offered");
        // Display citizen services offered by the department
    }
}

// Implementation for BothService (Combines Administrative and Citizen Services)
class BothService implements Service {
    @Override
    public void display() {
        System.out.println("Administrative and Citizen Services: // List of all services offered");
        // Display both administrative and citizen services offered by the department
    }
}

// Interface for Department
interface Department {
    Service getService();
}

// Implementation for AdministrativeDepartment
class AdministrativeDepartment implements Department {
    @Override
    public Service getService() {
        return new AdministrativeService();
    }
}

// Implementation for CitizenDepartment
class CitizenDepartment implements Department {
    @Override
    public Service getService() {
        return new CitizenService();
    }
}

// Implementation for BothDepartment
class BothDepartment implements Department {
    @Override
    public Service getService() {
        return new BothService();
    }
}

// Interface for GovernmentServiceKeeper
interface GovernmentServiceKeeper {
    Service getAdministrativeService();
    Service getCitizenService();
    Service getBothService();
}

// Implementation for GovernmentServiceKeeper
class GovernmentServiceKeeperImplementation implements GovernmentServiceKeeper {
    @Override
    public Service getAdministrativeService() {
        return new AdministrativeDepartment().getService();
    }

    @Override
    public Service getCitizenService() {
        return new CitizenDepartment().getService();
    }

    @Override
    public Service getBothService() {
        return new BothDepartment().getService();
    }
}

// Main class
public class FacadeDemo {
    public static void main(String[] args) {
        GovernmentServiceKeeper keeper = new GovernmentServiceKeeperImplementation();

        Service administrativeService = keeper.getAdministrativeService();
        Service citizenService = keeper.getCitizenService();
        Service bothService = keeper.getBothService();

        // Display services offered by departments
        System.out.println("\nDisplaying services offered by departments:\n");
        administrativeService.display();
        citizenService.display();
        bothService.display();
    }
}
