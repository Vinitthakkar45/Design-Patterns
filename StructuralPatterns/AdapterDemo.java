// Financial Governance Service Interface
interface FinancialGovernanceService {
    void auditFinancialTransaction();
}

// Legacy Financial Governance System
class LegacyFinancialGovernanceSystem {
    void auditLegacyFinancialTransaction() {
        System.out.println("\nLegacy Financial Governance System is auditing a financial transaction.\n");
    }
}

// Adapter
class FinancialGovernanceServiceAdapter implements FinancialGovernanceService {
    private LegacyFinancialGovernanceSystem legacySystem;

    public FinancialGovernanceServiceAdapter(LegacyFinancialGovernanceSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public void auditFinancialTransaction() {
        legacySystem.auditLegacyFinancialTransaction();
    }
}

// Client Code
public class AdapterDemo {
    public static void main(String[] args) {
        // Using the Adapter
        LegacyFinancialGovernanceSystem legacySystem = new LegacyFinancialGovernanceSystem();
        FinancialGovernanceService adapter = new FinancialGovernanceServiceAdapter(legacySystem);
        adapter.auditFinancialTransaction();
    }
}
