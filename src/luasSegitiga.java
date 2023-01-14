import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

abstract class Shape {
    abstract double getArea();
}

class Triangle extends Shape {
    private double base;
    private double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double getArea() {
        return 0.5 * base * height;
    }
}

class GUI extends JFrame {
    private JLabel baseLabel;
    private JTextField baseField;
    private JLabel heightLabel;
    private JTextField heightField;
    private JButton calculateButton;
    private JLabel resultLabel;

    GUI() {
        setTitle("Triangle Area Calculator");
        setSize(400, 150);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        baseLabel = new JLabel("Base:");
        baseField = new JTextField();
        heightLabel = new JLabel("Height:");
        heightField = new JTextField();
        calculateButton = new JButton("Calculate");
        resultLabel = new JLabel();

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double base = Double.parseDouble(baseField.getText());
                    double height = Double.parseDouble(heightField.getText());
                    Triangle triangle = new Triangle(base, height);
                    double area = triangle.getArea();
                    resultLabel.setText("Area: " + area);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }
        });

        add(baseLabel);
        add(baseField);
        add(heightLabel);
        add(heightField);
        add(calculateButton);
        add(resultLabel);

        setVisible(true);
    }
}


