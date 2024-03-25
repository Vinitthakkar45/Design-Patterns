import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface PolicyObserver {
    void updatePolicy(String policyUpdate);
}

// Subject Interface
interface GovernmentBody {
    void addObserver(PolicyObserver observer);
    void removeObserver(PolicyObserver observer);
    void notifyObservers();
}

// ConcreteSubject Class
class LegislativeAssembly implements GovernmentBody {
    private List<PolicyObserver> observers = new ArrayList<>();
    private String policyUpdate;

    @Override
    public void addObserver(PolicyObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(PolicyObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (PolicyObserver observer : observers) {
            observer.updatePolicy(policyUpdate);
        }
    }

    public void setPolicyUpdate(String newPolicyUpdate) {
        this.policyUpdate = newPolicyUpdate;
        notifyObservers();
    }
}

// ConcreteObserver Class
class Citizen implements PolicyObserver {
    private String policyUpdate;

    @Override
    public void updatePolicy(String policyUpdate) {
        this.policyUpdate = policyUpdate;
        display();
    }

    private void display() {
        System.out.println("Citizen: Policy update - " + policyUpdate);
    }
}

// ConcreteObserver Class
class Business implements PolicyObserver {
    private String policyUpdate;

    @Override
    public void updatePolicy(String policyUpdate) {
        this.policyUpdate = policyUpdate;
        display();
    }

    private void display() {
        System.out.println("Business: Policy update - " + policyUpdate);
    }
}

// ConcreteObserver Class
class NonGovernmentOrganization implements PolicyObserver {
    private String policyUpdate;

    @Override
    public void updatePolicy(String policyUpdate) {
        this.policyUpdate = policyUpdate;
        display();
    }

    private void display() {
        System.out.println("NGO: Policy update - " + policyUpdate);
    }
}

// Usage Class
public class ObserverDemo {
    public static void main(String[] args) {
        LegislativeAssembly legislature = new LegislativeAssembly();

        PolicyObserver citizen1 = new Citizen();
        PolicyObserver business1 = new Business();
        PolicyObserver ngo1 = new NonGovernmentOrganization();

        legislature.addObserver(citizen1);
        legislature.addObserver(business1);
        legislature.addObserver(ngo1);

        // policy update
        legislature.setPolicyUpdate("New tax regulation introduced.");

    }
}
