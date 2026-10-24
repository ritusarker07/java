
import javax.swing.*;
import java.awt.*;

public class StudentForm extends JFrame {

    JTextField nameField, idField, emailField, phoneField;
    JComboBox<String> departmentBox;
    JRadioButton male, female, other;

    StudentForm() {
        setTitle("Student Registration Form");
        setSize(550, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel
        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(Color.WHITE);

        // Header
        JPanel header = new JPanel();
        header.setBackground(new Color(35, 55, 95));
        header.setLayout(new GridLayout(2, 1));
        header.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JLabel title = new JLabel("STUDENT REGISTRATION", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 23));
        title.setForeground(Color.WHITE);

        JLabel subtitle = new JLabel("Enter your academic information",
                JLabel.CENTER);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(new Color(220, 225, 240));

        header.add(title);
        header.add(subtitle);

        // Form panel
        JPanel form = new JPanel(new GridLayout(6, 2, 12, 18));
        form.setBackground(Color.WHITE);
        form.setBorder(BorderFactory.createEmptyBorder(25, 30, 20, 30));

        Font font = new Font("Arial", Font.PLAIN, 15);

        nameField = new JTextField();
        idField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();

        departmentBox = new JComboBox<>(new String[]{
            "Select Department", "ICE", "CSE", "EEE",
            "Civil Engineering", "Business Administration"
        });

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        male.setBackground(Color.WHITE);
        female.setBackground(Color.WHITE);
        other.setBackground(Color.WHITE);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        genderPanel.setBackground(Color.WHITE);
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(other);

        addField(form, "Full Name:", nameField, font);
        addField(form, "Student ID:", idField, font);
        addField(form, "Email Address:", emailField, font);
        addField(form, "Phone Number:", phoneField, font);
        addField(form, "Department:", departmentBox, font);
        addField(form, "Gender:", genderPanel, font);

        // Buttons
        JButton submit = new JButton("Submit");
        JButton reset = new JButton("Reset");
        JButton exit = new JButton("Exit");

        JButton[] buttons = {submit, reset, exit};
        Color[] colors = {
            new Color(35, 125, 85),
            new Color(220, 155, 45),
            new Color(190, 65, 65)
        };

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setFont(new Font("Arial", Font.BOLD, 14));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setBackground(colors[i]);
            buttons[i].setFocusPainted(false);
            buttons[i].setBorderPainted(false);
            buttons[i].setOpaque(true);
            buttons[i].setPreferredSize(new Dimension(110, 38));
        }

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(submit);
        buttonPanel.add(reset);
        buttonPanel.add(exit);

        // Submit action
        submit.addActionListener(e -> {
            if (nameField.getText().trim().isEmpty()
                    || idField.getText().trim().isEmpty()
                    || emailField.getText().trim().isEmpty()
                    || phoneField.getText().trim().isEmpty()
                    || departmentBox.getSelectedIndex() == 0
                    || (!male.isSelected() && !female.isSelected()
                    && !other.isSelected())) {

                JOptionPane.showMessageDialog(this,
                        "Please complete all fields!",
                        "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String gender = male.isSelected() ? "Male"
                    : female.isSelected() ? "Female" : "Other";

            JOptionPane.showMessageDialog(this,
                    "STUDENT REGISTRATION SUCCESSFUL!\n\n"
                    + "Name: " + nameField.getText()
                    + "\nStudent ID: " + idField.getText()
                    + "\nEmail: " + emailField.getText()
                    + "\nPhone: " + phoneField.getText()
                    + "\nDepartment: " + departmentBox.getSelectedItem()
                    + "\nGender: " + gender,
                    "Registration Details",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        // Reset action
        reset.addActionListener(e -> {
            nameField.setText("");
            idField.setText("");
            emailField.setText("");
            phoneField.setText("");
            departmentBox.setSelectedIndex(0);
            genderGroup.clearSelection();
        });

        // Exit action
        exit.addActionListener(e -> dispose());

        main.add(header, BorderLayout.NORTH);
        main.add(form, BorderLayout.CENTER);
        main.add(buttonPanel, BorderLayout.SOUTH);

        add(main);
        setVisible(true);
    }

    void addField(JPanel panel, String label,
                  JComponent field, Font font) {
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("Arial", Font.BOLD, 14));
        field.setFont(font);

        if (field instanceof JTextField) {
            field.setPreferredSize(new Dimension(200, 30));
        }

        panel.add(jLabel);
        panel.add(field);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentForm());
    }
}
