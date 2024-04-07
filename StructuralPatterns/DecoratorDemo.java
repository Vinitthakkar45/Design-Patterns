// Interface representing a governance task in India
interface GovernanceTask {
    void perform();
}

// Concrete implementation of a bill drafting task
class BillDraftingTask implements GovernanceTask {

    @Override
    public void perform() {
        System.out.println("Performing bill drafting task");
    }
}

// Concrete implementation of a policy formulation task
class PolicyFormulationTask implements GovernanceTask {

    @Override
    public void perform() {
        System.out.println("Performing policy formulation task");
    }
}

// Abstract class for decorators in governance tasks
abstract class TaskDecorator implements GovernanceTask {
    protected GovernanceTask decoratedTask;

    TaskDecorator(GovernanceTask decoratedTask) {
        this.decoratedTask = decoratedTask;
    }

    @Override
    public void perform() {
        decoratedTask.perform();
    }
}

// Concrete decorator representing a task with a red label
class LabeledTaskDecorator extends TaskDecorator {

    LabeledTaskDecorator(GovernanceTask decoratedTask) {
        super(decoratedTask);
    }

    @Override
    public void perform() {
        decoratedTask.perform();
        setLabel();
    }

    private void setLabel() {
        System.out.println("Setting BUDGET for the task!");
    }
}

class DecoratorDemo {

    public static void main(String[] args) {
        // Creating a bill drafting task
        GovernanceTask billDraftingTask = new BillDraftingTask();

        // Creating a policy formulation task
        GovernanceTask policyFormulationTask = new PolicyFormulationTask();

        // Decorate the bill drafting task with a label
        GovernanceTask labeledBillDraftingTask = new LabeledTaskDecorator(billDraftingTask);

        // Decorate the policy formulation task with a label
        GovernanceTask labeledPolicyFormulationTask = new LabeledTaskDecorator(policyFormulationTask);

        // Perform the bill drafting task
        System.out.println("Performing bill drafting task:");
        billDraftingTask.perform();

        // Perform the bill drafting task with a label
        System.out.println("\nPerforming bill drafting task with BUDGET:");
        labeledBillDraftingTask.perform();

        // Perform the policy formulation task
        System.out.println("\nPerforming policy formulation task:");
        policyFormulationTask.perform();

        // Perform the policy formulation task with a label
        System.out.println("\nPerforming policy formulation task with BUDGET:");
        labeledPolicyFormulationTask.perform();

        System.out.println("\n");
    }
}
