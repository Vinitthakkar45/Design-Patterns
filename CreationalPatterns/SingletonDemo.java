public class SingletonDemo {
    public static void main(String[] args) {
        // Get the instance of PolicyTracker
        PolicyTracker policyTracker1 = PolicyTracker.getInstance();
        PolicyTracker policyTracker2 = PolicyTracker.getInstance();

        // Both instances point to the same object
        System.out.println(policyTracker1 == policyTracker2); // Output: true

        // Adding and removing policies
        policyTracker1.addPolicy("Tax Reform Policy");
        policyTracker2.addPolicy("Healthcare Policy");
        policyTracker1.removePolicy("Tax Reform Policy");

        // Displaying current policies
        policyTracker2.displayPolicies();
    }
}