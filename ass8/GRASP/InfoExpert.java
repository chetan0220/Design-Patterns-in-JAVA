// DRState interface defines polymorphic behavior
interface DRState {
    void diagnoseAndGenerateReport(String image);
}

// Concrete implementation of DRState: Mild DR
class MildDRState implements DRState {
    @Override
    public void diagnoseAndGenerateReport(String image) {
        System.out.println("Mild DR Report generated: Early stage of diabetic retinopathy detected for image: " + image);
    }
}

// Concrete implementation of DRState: Severe DR
class SevereDRState implements DRState {
    @Override
    public void diagnoseAndGenerateReport(String image) {
        System.out.println("Severe DR Report generated: Advanced diabetic retinopathy detected with high risk for image: " + image);
    }
}

// Concrete implementation of DRState: Moderate DR
class ModerateDRState implements DRState {
    @Override
    public void diagnoseAndGenerateReport(String image) {
        System.out.println("Moderate DR Report generated: Diabetic retinopathy detected with moderate severity for image: " + image);
    }
}

// Concrete implementation of DRState: No DR
class NoDRState implements DRState {
    @Override
    public void diagnoseAndGenerateReport(String image) {
        System.out.println("No DR Report generated: Diabetic retinopathy not detected for image: " + image);
    }
}

// Concrete implementation of DRState: Proliferative DR
class ProliferativeDRState implements DRState {
    @Override
    public void diagnoseAndGenerateReport(String image) {
        System.out.println("Proliferative DR Report generated: Diabetic retinopathy detected with advanced complications for image: " + image);
    }
}

// DiagnosisSystem class is the Information Expert
class DiagnosisSystem {
    private DRState currentState; // Information that the class uses to make decisions
    private String image;

    // Constructor determines the state based on the image or other initial conditions
    public DiagnosisSystem(String image) {
        this.image = image;  // The image is information the system will work with
        this.currentState = determineState(image);  // Automatically determine the initial state based on the image
    }

    // Method to automatically determine the state based on the image or other factors
    private DRState determineState(String image) {
        // Using match-case to determine state
        return switch (image) {
            case String s when s.contains("mild") -> new MildDRState();
            case String s when s.contains("moderate") -> new ModerateDRState();
            case String s when s.contains("severe") -> new SevereDRState();
            case String s when s.contains("proliferative") -> new ProliferativeDRState();
            default -> new NoDRState();  // Default state
        };
    }

    // Delegate diagnosis and report generation to the current state
    public void diagnoseAndGenerateReport() {
        currentState.diagnoseAndGenerateReport(image);  // Information Expert will use its information (the image) to generate the report
    }
}

public class Main {
    public static void main(String[] args) {
        // The DiagnosisSystem has the necessary information (image) to process the diagnosis
        DiagnosisSystem diagnosisSystem = new DiagnosisSystem("retina_image_mild_dr.png");

        // Perform diagnosis with the initial state (automatically set by the constructor)
        System.out.println("Diagnosis Process for Mild DR:");
        diagnosisSystem.diagnoseAndGenerateReport();

        // Change state to Severe DR and diagnose again
        // diagnosisSystem = new DiagnosisSystem("retina_image_severe_dr.png"); // Creating a new instance with a different image
        // System.out.println("\nDiagnosis Process for Severe DR:");
        // diagnosisSystem.diagnoseAndGenerateReport();

        // Change state to Moderate DR and diagnose
        // diagnosisSystem = new DiagnosisSystem("retina_image_moderate_dr.png"); // Creating a new instance with a different image
        // System.out.println("\nDiagnosis Process for Moderate DR:");
        // diagnosisSystem.diagnoseAndGenerateReport();
    }
}
