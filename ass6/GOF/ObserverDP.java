import java.util.*;
// Observer Interface
interface Observer {
    void update();
}

// Concrete Observer for Patient Records
class PatientRecordObserver implements Observer {
    public void update() {
        System.out.println("PatientRecordObserver: Patient records updated with diagnosis result");
    }
}

    // Concrete Observer for Alerting DB
class PatientHistoryObserver implements Observer {
    public void update() {
        System.out.println("PatientHistoryObserver: DB updated with diagnosis result");
    }
}

// Subject (Diagnosis System)
class DiagnosisSystem {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    // Simulate a new diagnosis result generation
    public void generateDiagnosis() {
        // Simulate diagnosis processing
        System.out.println("DiagnosisSystem: New diagnosis result generated");
        notifyObservers();
    }
}

// Main Simulation
public class Main {
    public static void main(String[] args) {
        DiagnosisSystem diagnosisSystem = new DiagnosisSystem();

        // Add observers
        diagnosisSystem.addObserver(new PatientRecordObserver());
        diagnosisSystem.addObserver(new PatientHistoryObserver());

        // Simulate diagnosis generation
        diagnosisSystem.generateDiagnosis();
    }
}
