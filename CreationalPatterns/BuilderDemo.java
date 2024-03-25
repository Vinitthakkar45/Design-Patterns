interface ProfilePlan 
{ 
    public void setRoles(String Roles); 
    public void setResponsibilities(String Responsibilities);  
    public void setPermissions(String Permissions);   
} 

class Profile implements ProfilePlan 
{   
    private String Roles; 
    private String Responsibilities; 
    private String Permissions; 
  
    public void setRoles(String Roles)  
    { 
        this.Roles = Roles; 
    }   
    public void setResponsibilities(String Responsibilities)  
    { 
        this.Responsibilities = Responsibilities; 
    }   
    public void setPermissions(String Permissions)  
    { 
        this.Permissions = Permissions; 
    }   

    @Override
    public String toString() {
        return "Roles: " + Roles + "\n\nResponsibilities: " + Responsibilities + "\n\nPermissions: " + Permissions;
    }
    
} 
  
  
interface ProfileBuilder 
{ 
    public void buildRoles(); 
    public void buildResponsibilities(); 
    public void buildRights(); 
    public Profile getProfile(); 
} 
  
class PresidentProfileBuilder implements ProfileBuilder 
{ 
    private Profile Profile; 
    public PresidentProfileBuilder()  
    { 
        this.Profile = new Profile(); 
    } 
  
    public void buildRoles()  
    { 
        Profile.setRoles("1. Head of the Union Government\n2. Formation of the Council of Ministers\n3. Power to appoint and remove the high dignitaries of the state\n4. Administration of Union Territories\n"); 
    } 
  
    public void buildResponsibilities()  
    { 
        Profile.setResponsibilities("Preserve, Protect and Defend the constitution and the law of India"); 
    }
  
    public void buildRights()  
    { 
        Profile.setPermissions("Supreme Commander of the Indian Armed Forces\n Can declare war or conclude peace, on the advice of the Union Council of Ministers headed by the prime minister."); 
    } 
  
    public Profile getProfile()  
    { 
        return this.Profile; 
    } 
} 
  
class PrimeMinisterProfileBuilder implements ProfileBuilder 
{ 
    private Profile Profile; 
    public PrimeMinisterProfileBuilder()  
    { 
        this.Profile = new Profile(); 
    } 
    public void buildRoles()  
    { 
        Profile.setRoles("The head of government"); 
    } 
  
    public void buildResponsibilities()  
    { 
        Profile.setResponsibilities("Holding Meetings\nSelection of Members\nDecide Government Policy\nSpokesperson of the country"); 
    } 
  
    public void buildRights()  
    { 
        Profile.setPermissions("Right to be a member of the Lok Sabha or of the Rajya Sabha, the upper house of the parliament\nRight to control the selection and dismissal of members of the Union Council of Ministers\nRight to allocate the posts to members within the government."); 
    } 
  
    public Profile getProfile()  
    { 
        return this.Profile; 
    } 
  
} 
  
class ProfileManager  
{ 
  
    private ProfileBuilder ProfileBuilder; 
  
    public ProfileManager(ProfileBuilder ProfileBuilder) 
    { 
        this.ProfileBuilder = ProfileBuilder; 
    } 
  
    public Profile getProfile() 
    { 
        return this.ProfileBuilder.getProfile(); 
    } 
  
    public void constructProfile() 
    { 
        this.ProfileBuilder.buildRoles(); 
        this.ProfileBuilder.buildResponsibilities(); 
        this.ProfileBuilder.buildRights(); 
    } 
} 
  
public class BuilderDemo
{ 
    public static void main(String[] args) 
    { 
        ProfileBuilder PDprofile = new PresidentProfileBuilder(); 
        ProfileManager Manager = new ProfileManager(PDprofile); 
  
        Manager.constructProfile(); 
  
        Profile Profile = Manager.getProfile(); 
  
        System.out.println("Builder constructed: "+ Profile); 
    } 
} 