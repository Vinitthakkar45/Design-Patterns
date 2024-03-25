import java.util.HashMap;
import java.util.Map;

abstract class GovernanceRole implements Cloneable {
    protected String roleName;
    protected String country;
    protected int termInOffice;
    protected String responsibilities;

    abstract void performRole();

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}

class President extends GovernanceRole {
    public President(String country, int termInOffice, String responsibilities) {
        this.roleName = "President";
        this.country = country;
        this.termInOffice = termInOffice;
        this.responsibilities = responsibilities;
    }

    @Override
    void performRole() {
        System.out.println("President of " + country + " is performing duties");
        System.out.println("Term in office: " + termInOffice + " years");
        System.out.println("Responsibilities: " + responsibilities);
    }
}

class PrimeMinister extends GovernanceRole {
    public PrimeMinister(String country, int termInOffice, String responsibilities) {
        this.roleName = "Prime Minister";
        this.country = country;
        this.termInOffice = termInOffice;
        this.responsibilities = responsibilities;
    }

    @Override
    void performRole() {
        System.out.println("Prime Minister of " + country + " is performing duties");
        System.out.println("Term in office: " + termInOffice + " years");
        System.out.println("Responsibilities: " + responsibilities);
    }
}

class GovernanceRoleStore {
    private static Map<String, GovernanceRole> roleMap = new HashMap<>();

    static {
        roleMap.put("President", new President("India", 5, "Head of State, Commander-in-Chief"));
        roleMap.put("Prime Minister", new PrimeMinister("India", 5, "Head of Government, Legislative Leader"));
    }

    public static GovernanceRole getRole(String roleName) {
        return (GovernanceRole) roleMap.get(roleName).clone();
    }
}


class GovernancePrototype {
    public static void main(String[] args) {
        GovernanceRole presidentA = GovernanceRoleStore.getRole("President");
        presidentA.performRole();

        GovernanceRole primeMinisterB = GovernanceRoleStore.getRole("Prime Minister");
        primeMinisterB.performRole();


        ((President) presidentA).termInOffice = 4;
        presidentA.performRole(); 
    }
}