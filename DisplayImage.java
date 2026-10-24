import javax.swing.*;

public class DisplayImage {
    public static void main(String[] args) {
        JFrame f = new JFrame("Display Image");

        ImageIcon img = new ImageIcon("D:\\3-2\\Java\\Java lab\\images.jpeg");
        JLabel l = new JLabel(img);

        f.add(l);
        f.setSize(500, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}