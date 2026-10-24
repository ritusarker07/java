// Student Registration Form

import javax.swing.*;

public class form {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Form");

        JLabel l1 = new JLabel("Name:");
        l1.setBounds(50, 50, 100, 30);

        JTextField t1 = new JTextField();
        t1.setBounds(160, 50, 200, 30);

        JLabel l2 = new JLabel("Student ID:");
        l2.setBounds(50, 100, 100, 30);

        JTextField t2 = new JTextField();
        t2.setBounds(160, 100, 200, 30);

        JLabel l3 = new JLabel("Department:");
        l3.setBounds(50, 150, 100, 30);

        String dept[] = {"CSE", "EEE", "ENG"};
        JComboBox<String> cb = new JComboBox<>(dept);
        cb.setBounds(160, 150, 200, 30);

        JLabel l4 = new JLabel("Gender:");
        l4.setBounds(50, 200, 100, 30);

        JRadioButton male = new JRadioButton("Male");
        male.setBounds(160, 200, 80, 30);

        JRadioButton female = new JRadioButton("Female");
        female.setBounds(250, 200, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JButton btn = new JButton("Submit");
        btn.setBounds(160, 260, 120, 35);

        // Result Section
        JLabel result = new JLabel("Submitted Information:");
        result.setBounds(50, 330, 250, 30);

        JLabel l5 = new JLabel();
        l5.setBounds(50, 370, 300, 30);

        JLabel l6 = new JLabel();
        l6.setBounds(50, 405, 300, 30);

        JLabel l7 = new JLabel();
        l7.setBounds(50, 440, 300, 30);

        JLabel l8 = new JLabel();
        l8.setBounds(50, 475, 300, 30);

        btn.addActionListener(e -> {

            String name = t1.getText();
            String id = t2.getText();
            String dp = (String) cb.getSelectedItem();

            String gender;

            if (male.isSelected()) {
                gender = "Male";
            } 
            else if (female.isSelected()) {
                gender = "Female";
            } 
            else {
                gender = "Not Selected";
            }

            l5.setText("Name: " + name);
            l6.setText("Student ID: " + id);
            l7.setText("Department: " + dp);
            l8.setText("Gender: " + gender);
        });

        frame.add(l1);
        frame.add(t1);
        frame.add(l2);
        frame.add(t2);
        frame.add(l3);
        frame.add(cb);
        frame.add(l4);
        frame.add(male);
        frame.add(female);
        frame.add(btn);
        frame.add(result);
        frame.add(l5);
        frame.add(l6);
        frame.add(l7);
        frame.add(l8);

        frame.setSize(450, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}