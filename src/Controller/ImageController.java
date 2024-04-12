package Controller;

import javax.swing.*;
import java.awt.*;

public class ImageController extends JFrame {

    public ImageController() {
        setTitle("Image Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imageIcon = new ImageIcon("1.png"); // Replace with your image path
        JLabel label = new JLabel(imageIcon);
        getContentPane().add(label, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }
    public static void executeImage()
    {
        SwingUtilities.invokeLater(ImageController::new);
    }
}
