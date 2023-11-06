import ui.UserInterface;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Angiver vores metode fra vores nye Java Class kaldet Ui.UserInterface
        UserInterface ui = new UserInterface();
        ui.startProgram();
    }

}
