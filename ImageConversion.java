import javax.imageio.ImageIO;
import javax.swing.*;
// import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageConversion {

    public static void main(String[] args) {
        // Replace with your image file name in the same folder as your Java file
        String inputImagePath = "eagle_color.jpg";

        // Convert image to grayscale
        convertToGray(inputImagePath);

        // Convert grayscale image back to color
        convertToColor("albert-einstein.jpg");
    }

    private static void convertToGray(String inputImagePath) {
        try {
            // Read the original image
            BufferedImage originalImage = ImageIO.read(new File(inputImagePath));

            // Create a grayscale image
            BufferedImage grayImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
            grayImage.getGraphics().drawImage(originalImage, 0, 0, null);

            // Save the grayscale image
            ImageIO.write(grayImage, "jpg", new File("gray_image.jpg"));

            // Display the original and grayscale images
            displayImage(originalImage, "Original Image");
            displayImage(grayImage, "Gray Image");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void convertToColor(String grayImagePath) {
        try {
            // Read the grayscale image
            BufferedImage grayImage = ImageIO.read(new File(grayImagePath));

            // Create a color image
            BufferedImage colorImage = new BufferedImage(grayImage.getWidth(), grayImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            colorImage.getGraphics().drawImage(grayImage, 0, 0, null);

            // Save the color image
            ImageIO.write(colorImage, "jpg", new File("color_image.jpg"));

            // Display the grayscale and original color images
            displayImage(grayImage, "Gray Image");
            displayImage(colorImage, "Color Image");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayImage(BufferedImage image, String title) {
        // Use Swing to display the image in a JFrame
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame(title);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new JLabel(new ImageIcon(image)));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
