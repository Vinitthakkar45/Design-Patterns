import java.util.*;

interface DeptOfMinistry {
   void function();
}

class MinistryOfDefence implements DeptOfMinistry {

   @Override
   public void function() {
      System.out.println("\nWELCOME TO MINISTRY OF DEFENCE\nWorks with coordinating and supervising all agencies and functions of the government relating directly to national security and the Indian Armed Forces.\n");
   }
}

class MinistryOfFinance implements DeptOfMinistry {

   @Override
   public void function() {
      System.out.println("\nWELCOME TO MINISTRY OF FINANCE\nWorks with taxation, financial legislation, financial institutions, capital markets, centre and state finances, and the Union Budget.\n");
   }
}
class MinistryOfExternalAffairs implements DeptOfMinistry {

   @Override
   public void function() {
      System.out.println("\nWELCOME TO MINISTRY OF EXTERNAL AFFAIRS\nWorks with formulating and implementing the country's foreign policy, maintaining diplomatic relations with other countries, representing the country in international organizations, and protecting the interests of its citizens abroad.\n");
   }
}

class FactoryOfMinistry {
	
   public DeptOfMinistry getMinistry(String DeptOfMinistryType){
      if(DeptOfMinistryType == null){
         return null;
      }
      switch (DeptOfMinistryType) {


         case "Defence":
            return new MinistryOfDefence();
         case "Navy":
            return new MinistryOfDefence();
         case "Airforce":
            return new MinistryOfDefence();
         case "Border Protection":
            return new MinistryOfDefence();
         case "National Security":
            return new MinistryOfDefence();
         case "Army":
            return new MinistryOfDefence();


         case "Finance":
            return new MinistryOfFinance();
         case "Budget":
            return new MinistryOfFinance();
         case "Taxation":
            return new MinistryOfFinance();
         case "Capital Markets":
            return new MinistryOfFinance();
         case "Asset Management":
            return new MinistryOfFinance();
         case "Cash Flow":
            return new MinistryOfFinance();
         case "Inflation":
            return new MinistryOfFinance();
            
         case "External Affairs":
            return new MinistryOfExternalAffairs();
         case "Foreign Policy":
            return new MinistryOfExternalAffairs();
         case "International Relations":
            return new MinistryOfExternalAffairs();
         case "Diplomatic Initiatives":
            return new MinistryOfExternalAffairs();
         case "Overseas Affairs":
            return new MinistryOfExternalAffairs();
         case "Embassy":
            return new MinistryOfExternalAffairs();

         default:
            System.out.println("\nNo Ministry works with the queried function.\n");
            break;

      }
      return null;
   }
}

public class FactoryDemo {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.println("\n\n============Welcome to Council of Ministries============");
      System.out.println("\nWhat do you need assistance with ?");
      String keyword = sc.nextLine();

      FactoryOfMinistry MinistryManager = new FactoryOfMinistry();

      DeptOfMinistry Task = MinistryManager.getMinistry(keyword);
      if (Task!=null){
         Task.function();
      }    
      sc.close();
   }
}
