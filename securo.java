import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import hashingalgo.sha256;
public class securo {
    public static void main(String[] args) {
        // Create the frame
         
         sha256.main("hi hello");// Hashcoverter to convert to SHA 256 Algorithms and its types
        JFrame frame = new JFrame("Securo Filer");
        
        // Set the icon image
        try {
            Image icon = ImageIO.read(new File("download.png")); // Make sure the path is correct
            frame.setIconImage(icon);
        } catch (IOException e) {
            System.err.println("Icon image not found: " + e.getMessage());
        }

        // Set frame size and close operation
        frame.setSize(200, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set layout (optional, depending on your needs)
        frame.setLayout(new FlowLayout());

        // Make the frame visible
        frame.setVisible(true);
    }
}