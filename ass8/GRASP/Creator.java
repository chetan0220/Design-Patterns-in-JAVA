// The Image class
class Image {
    private String imageData;
    
    public Image(String imageData) {
        this.imageData = imageData;
    }

    public void displayImage() {
        System.out.println("Displaying image data: " + imageData);
    }
}

// The Patient class, which is responsible for creating Image objects
class Patient {
    private String name;
    private String imageData;

    public Patient(String name, String imageData) {
        this.name = name;
        this.imageData = imageData;
    }

    // The Creator responsibility: Patient creates an Image
    public Image createImage() {
        return new Image(imageData);
    }
}

// Main class to simulate the creation
public class Main {
    public static void main(String[] args) {
        // Create a Patient
        Patient patient = new Patient("John Doe", "Retina Image Data");

        // Patient creates the Image object
        Image patientImage = patient.createImage();

        // Display the Image
        patientImage.displayImage();
    }
}
