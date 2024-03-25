import java.util.Random;
import java.util.HashMap;

// A common interface for all government officials
interface Official {
    public void assignTask(String task);
    public void executeTask();
}

// Government official responsible for maintaining security
class SecurityOfficial implements Official {
    // Intrinsic Attribute     //which is common to all objects
    private final String DEPARTMENT;

    // Extrinsic Attribute     //which is different for each objects
    private String task;

    public SecurityOfficial() {
        DEPARTMENT = "Security Department";
    }

    public void assignTask(String task) {
        // Assign a task
        this.task = task;
    }

    public void executeTask() {
        // Work on the assigned task
        System.out.println("Security Official from " + DEPARTMENT + " performing task: " + task);
    }
}

// Government official responsible for public services
class ServiceOfficial implements Official {
    // Intrinsic Attribute
    private final String DEPARTMENT;

    // Extrinsic Attribute
    private String task;

    public ServiceOfficial() {
        DEPARTMENT = "Service Department";
    }

    public void assignTask(String task) {
        // Assign a task
        this.task = task;
    }

    public void executeTask() {
        // Work on the assigned task
        System.out.println("Service Official from " + DEPARTMENT + " performing task: " + task);
    }
}

// Class used to get an official using HashMap (Returns
// an existing official if an official of given type exists.
// Else creates a new official and returns it.
class OfficialFactory {
    /* HashMap stores the reference to the object
       of SecurityOfficial(SO) or ServiceOfficial(SO). */
    private static HashMap<String, Official> hm =
            new HashMap<String, Official>();

    // Method to get an official
    public static Official getOfficial(String type) {
        Official official = null;

        /* If an object for SO or SA has already been
           created simply return its reference */
        if (hm.containsKey(type))
            official = hm.get(type);
        else {
            /* create an object of SO/SA */
            switch (type) {
                case "SecurityOfficial":
                    System.out.println("Security Official Created");
                    official = new SecurityOfficial();
                    break;
                case "ServiceOfficial":
                    System.out.println("Service Official Created");
                    official = new ServiceOfficial();
                    break;
                default:
                    System.out.println("Unreachable code!");
            }

            // Once created, insert it into the HashMap
            hm.put(type, official);
        }
        return official;
    }
}


public class FlyWeightDemo {
    // All official types and tasks
    private static String[] officialTypes = {"SecurityOfficial", "ServiceOfficial"};
    private static String[] tasks = {"Maintain Public Safety", "Deliver Public Services", "Regulate"};


    public static void main(String args[]) {
        /* Assume that we have a total of 10 officials in the government. */
        for (int i = 0; i < 10; i++) {
            /* getOfficial() is called simply using the class
               name since the method is a static one */
            Official official = OfficialFactory.getOfficial(getRandomOfficialType());

            /* Assign a task chosen randomly uniformly
               from the task array */
            official.assignTask(getRandomTask());

            // Execute the assigned task
            official.executeTask();
        }
    }

    // Utility methods to get a random official type and task
    public static String getRandomOfficialType() {
        Random random = new Random();

        // Will return an integer between [0, 2)
        int randInt = random.nextInt(officialTypes.length);

        // Return the official type stored at index 'randInt'
        return officialTypes[randInt];
    }

    public static String getRandomTask() {
        Random random = new Random();

        // Will return an integer between [0, 3)
        int randInt = random.nextInt(tasks.length);

        // Return the task stored at index 'randInt'
        return tasks[randInt];
    }
}
