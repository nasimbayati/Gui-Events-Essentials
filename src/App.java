package src;

import src.swing.SwingTracker;
import src.awt.AwtTracker;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -cp bin src.App <swing|awt> [name]");
            return;
        }
        String mode = args[0].toLowerCase();
        String name = (args.length >= 2) ? args[1] : "Nasim Bayati";

        switch (mode) {
            case "swing": SwingTracker.launch(name); break;
            case "awt":   AwtTracker.launch(name);   break;
            default: System.out.println("Unknown mode: " + mode);
        }
    }
}
