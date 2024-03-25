interface MinistryOfFinance {
    void Budget();
 }
 
 interface MinistryOfEducation {
    void information();
 }
 
 interface MinistryOfRoadTransport {
    void RoadMaintainance();
 }
 
 class GujaratMinistryOfEducation implements MinistryOfEducation {
     public void information(){
         System.out.println("\n\nWELCOME TO MINISTRY OF EDUCATION, GUJARAT!!\nTo know more about us visit : https://www.gseb.org/");
     }
 }
 
 class RajasthanMinistryOfEducation implements MinistryOfEducation {
     public void information(){
         System.out.println("\n\nWELCOME TO MINISTRY OF EDUCATION, RAJASTHAN!!\nTo know more about us visit : https://rajeduboard.rajasthan.gov.in/");
     }
 }
 
 class GujaratMinistryOfFinance implements MinistryOfFinance {
     public void Budget(){
         System.out.println("\n\nWELCOME TO MINISTRY OF FINANCE, GUJARAT!!\nTo know more BUDGET visit : https://financedepartment.gujarat.gov.in/Budget.html");
     }
 }
 
 
 
 class RajasthanMinistryOfFinance implements MinistryOfFinance {
     public void Budget(){
         System.out.println("\n\nWELCOME TO MINISTRY OF FINANCE, RAJASTHAN!!\nTo know more BUDGET visit : https://budget.rajasthan.gov.in/pages/department-page/712");
     }
 }
 
 class GujaratMinistryOfRoadTransport implements MinistryOfRoadTransport {
     public void RoadMaintainance(){
         System.out.println("\n\nWELCOME TO MINISTRY OF ROAD TRANSPORT, GUJARAT!!\nhttps://gujrosa.gujarat.gov.in/road-safety-in-gujarat");
     }
 }
 
 class RajasthanMinistryOfRoadTransport implements MinistryOfRoadTransport {
     public void RoadMaintainance(){
         System.out.println("\n\nWELCOME TO MINISTRY OF ROAD TRANSPORT, RAJASTHAN!!\nhttps://rajasthanpuc.in/");
     }
 }
 
 interface AbstractFactory{
     MinistryOfFinance createMinistryOfFinance();
     MinistryOfRoadTransport createMinistryOfRoadTransport();
     MinistryOfEducation createMinistryOfEducation();
 }
 
 class GujaratStateFactory implements AbstractFactory{
 
     @Override
     public MinistryOfFinance createMinistryOfFinance() {
         return new GujaratMinistryOfFinance();
         
     }
 
     @Override
     public MinistryOfRoadTransport createMinistryOfRoadTransport() {
         return new GujaratMinistryOfRoadTransport();
     }
 
     @Override
     public MinistryOfEducation createMinistryOfEducation() {
         return new GujaratMinistryOfEducation();
     }
 
 }
 
 class RajasthanStateFactory implements AbstractFactory{
 
     @Override
     public MinistryOfFinance createMinistryOfFinance() {
         return new RajasthanMinistryOfFinance();
         
     }
 
     @Override
     public MinistryOfRoadTransport createMinistryOfRoadTransport() {
         return new RajasthanMinistryOfRoadTransport();
     }
 
     @Override
     public MinistryOfEducation createMinistryOfEducation() {
         return new RajasthanMinistryOfEducation();
     }
 
 }
 
 public class AbstractDemo {
     public static void main(String[] args) {
         //here args[0] is State
 
         switch (args[0]) {
             case "Gujarat":
                 AbstractFactory FactoryGj = new GujaratStateFactory();
                 MinistryOfEducation GjMoE=FactoryGj.createMinistryOfEducation();
                 GjMoE.information();
 
                 MinistryOfRoadTransport GjMoRT=FactoryGj.createMinistryOfRoadTransport();
                 GjMoRT.RoadMaintainance();
 
                 MinistryOfFinance GjMoF=FactoryGj.createMinistryOfFinance();
                 GjMoF.Budget();
                 break;
             
             case "Rajasthan":
                 AbstractFactory FactoryRj = new RajasthanStateFactory();
                 MinistryOfEducation RjMoE=FactoryRj.createMinistryOfEducation();
                 RjMoE.information();
 
                 MinistryOfRoadTransport RjMoRT=FactoryRj.createMinistryOfRoadTransport();
                 RjMoRT.RoadMaintainance();
 
                 MinistryOfFinance RjMoF=FactoryRj.createMinistryOfFinance();
                 RjMoF.Budget();
                 break;
 
             default:
                 System.out.println("State not found!!");
                 break;
         }
 
     }
 }
 