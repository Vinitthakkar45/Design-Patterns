import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface EventObserver {
    void updateEvent(String eventUpdate);
}

// Subject Interface
interface CollegeClub {
    void addObserver(EventObserver observer);
    void removeObserver(EventObserver observer);
    void notifyObservers();
}

// ConcreteSubject Class
class ClubEvents implements CollegeClub {
    private List<EventObserver> observers = new ArrayList<>();
    private String eventUpdate;

    @Override
    public void addObserver(EventObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(EventObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (EventObserver observer : observers) {
            observer.updateEvent(eventUpdate);
        }
    }

    public void setEventUpdate(String newEventUpdate) {
        this.eventUpdate = newEventUpdate;
        notifyObservers();
    }
}

// ConcreteObserver Class
class Student implements EventObserver {
    private String eventUpdate;
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void updateEvent(String eventUpdate) {
        this.eventUpdate = eventUpdate;
        display();
    }

    private void display() {
        System.out.println("Student " + name + ": Event update - " + eventUpdate);
    }
}

// Usage Class
public class ObserverClubDemo {
    public static void main(String[] args) {
        ClubEvents clubEvents = new ClubEvents();

        EventObserver student1 = new Student("Brilliant Vibhor");
        EventObserver student2 = new Student("Intellectual Yash");
        EventObserver student3 = new Student("Silent Killer Achyut");
        EventObserver student4 = new Student("And Panchal 👍");

        clubEvents.addObserver(student1);
        clubEvents.addObserver(student2);
        clubEvents.addObserver(student3);
        clubEvents.addObserver(student4);

        // Event update
        clubEvents.setEventUpdate("New event: Coding Competition organized by Computer Science Club.");
    }
}
