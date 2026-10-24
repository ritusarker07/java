// Calculator

import javax.swing.*;

public class calc {
    public static void main(String[] args) {

        JFrame f = new JFrame("Calculator");

        JTextField t = new JTextField();
        t.setBounds(30, 30, 320, 40);
        t.setEditable(false);

        JButton b1 = new JButton("7");
        b1.setBounds(30, 90, 70, 45);

        JButton b2 = new JButton("8");
        b2.setBounds(110, 90, 70, 45);

        JButton b3 = new JButton("9");
        b3.setBounds(190, 90, 70, 45);

        JButton b4 = new JButton("/");
        b4.setBounds(270, 90, 70, 45);

        JButton b5 = new JButton("4");
        b5.setBounds(30, 145, 70, 45);

        JButton b6 = new JButton("5");
        b6.setBounds(110, 145, 70, 45);

        JButton b7 = new JButton("6");
        b7.setBounds(190, 145, 70, 45);

        JButton b8 = new JButton("*");
        b8.setBounds(270, 145, 70, 45);

        JButton b9 = new JButton("1");
        b9.setBounds(30, 200, 70, 45);

        JButton b10 = new JButton("2");
        b10.setBounds(110, 200, 70, 45);

        JButton b11 = new JButton("3");
        b11.setBounds(190, 200, 70, 45);

        JButton b12 = new JButton("-");
        b12.setBounds(270, 200, 70, 45);

        JButton b13 = new JButton("C");
        b13.setBounds(30, 255, 70, 45);

        JButton b14 = new JButton("0");
        b14.setBounds(110, 255, 70, 45);

        JButton b15 = new JButton("=");
        b15.setBounds(190, 255, 70, 45);

        JButton b16 = new JButton("+");
        b16.setBounds(270, 255, 70, 45);

        final double[] num1 = {0};
        final String[] op = {""};

        

        b1.addActionListener(e -> t.setText(t.getText() + "7"));
        b2.addActionListener(e -> t.setText(t.getText() + "8"));
        b3.addActionListener(e -> t.setText(t.getText() + "9"));
        b5.addActionListener(e -> t.setText(t.getText() + "4"));
        b6.addActionListener(e -> t.setText(t.getText() + "5"));
        b7.addActionListener(e -> t.setText(t.getText() + "6"));
        b9.addActionListener(e -> t.setText(t.getText() + "1"));
        b10.addActionListener(e -> t.setText(t.getText() + "2"));
        b11.addActionListener(e -> t.setText(t.getText() + "3"));
        b14.addActionListener(e -> t.setText(t.getText() + "0"));

        b4.addActionListener(e -> {
            num1[0] = Double.parseDouble(t.getText());
            op[0] = "/";
            t.setText("");
        });

        b8.addActionListener(e -> {
            num1[0] = Double.parseDouble(t.getText());
            op[0] = "*";
            t.setText("");
        });

        b12.addActionListener(e -> {
            num1[0] = Double.parseDouble(t.getText());
            op[0] = "-";
            t.setText("");
        });

        b16.addActionListener(e -> {
            num1[0] = Double.parseDouble(t.getText());
            op[0] = "+";
            t.setText("");
        });

        b15.addActionListener(e -> {
            double num2 = Double.parseDouble(t.getText());
            double result = 0;

            if (op[0].equals("+"))
                result = num1[0] + num2;
            else if (op[0].equals("-"))
                result = num1[0] - num2;
            else if (op[0].equals("*"))
                result = num1[0] * num2;
            else if (op[0].equals("/")) {
                if (num2 == 0) {
                    t.setText("Cannot divide by zero");
                    return;
                }
                result = num1[0] / num2;
            }

            t.setText(String.valueOf(result));
        });

        b13.addActionListener(e -> {
            t.setText("");
            num1[0] = 0;
            op[0] = "";
        });

        f.add(t);
        f.add(b1); f.add(b2); f.add(b3); f.add(b4);
        f.add(b5); f.add(b6); f.add(b7); f.add(b8);
        f.add(b9); f.add(b10); f.add(b11); f.add(b12);
        f.add(b13); f.add(b14); f.add(b15); f.add(b16);

        f.setSize(400, 370);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}