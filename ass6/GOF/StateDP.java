// State Interface
interface DRState {
    void GenerateReport(String image);
}

class MildDRState implements DRState {
    @Override
    public void GenerateReport(String image) {
        System.out.println("Generating Mild DR report for image: " + image);
       }
}

class ModerateDRState implements DRState {
    @Override
    public void GenerateReport(String image) {
        System.out.println("Generating Moderate DR report for image: " + image);
    }
}

class SevereDRState implements DRState {
    @Override
    public void GenerateReport(String image) {
        System.out.println("Generating Severe DR report for image: " + image);
    }
}

class ProliferativeDRState implements DRState {
    @Override
    public void GenerateReport(String image) {
        System.out.println("Generating Proliferative DR report for image: " + image);
    }
}

class DiagnosisSystem {
    private DRState currentState;

    // Set initial state
    public DiagnosisSystem() {
        this.currentState = new MildDRState(); // Default state
    }

    // Set a new state at runtime
    public void setState(DRState state) {
        this.currentState = state;
    }

    // Perform diagnosis and report generation using the current state
    public void GenerateReport(String image) {
        currentState.GenerateReport(image);
    }
}

public class Main {
    public static void main(String[] args) {
        DiagnosisSystem diagnosisSystem = new DiagnosisSystem();

        // Classify as Mild DR and generate report
        diagnosisSystem.GenerateReport("retina_image_mild_dr.png");

        // Change state to Moderate DR and generate report
        diagnosisSystem.setState(new ModerateDRState());
        diagnosisSystem.GenerateReport("retina_image_moderate_dr.png");

        // Change state to Severe DR and generate report
        diagnosisSystem.setState(new SevereDRState());
        diagnosisSystem.GenerateReport("retina_image_severe_dr.png");

        // Change state to Proliferative DR and generate report
        diagnosisSystem.setState(new ProliferativeDRState());
        diagnosisSystem.GenerateReport("retina_image_proliferative_dr.png");
    }
}
