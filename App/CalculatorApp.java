package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame implements ActionListener {

    private JTextField display;
    private JLabel operationLabel;
    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    // Enhanced color scheme
    private static final Color BACKGROUND_COLOR = new Color(245, 245, 247);
    private static final Color DISPLAY_BG = Color.WHITE;
    private static final Color NUMBER_COLOR = new Color(255, 255, 255);
    private static final Color OPERATOR_COLOR = new Color(255, 159, 10);
    private static final Color EQUALS_COLOR = new Color(255, 159, 10);
    private static final Color FUNCTION_COLOR = new Color(165, 165, 165);
    private static final Color CLEAR_COLOR = new Color(165, 165, 165);
    private static final Color TEXT_DARK = new Color(60, 60, 67);
    private static final Color TEXT_WHITE = Color.WHITE;
    private static final Color BORDER_COLOR = new Color(220, 220, 220);

    public CalculatorApp() {
        // Setup the main window
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380, 520);
        setLocationRelativeTo(null);
        setResizable(false);

        // Initialize components
        initComponents();

        // Make window visible
        setVisible(true);
    }

    private void initComponents() {
        // Main panel with border layout
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        mainPanel.setBackground(BACKGROUND_COLOR);

        // Create display panel
        JPanel displayPanel = createDisplayPanel();

        // Create button panel
        JPanel buttonPanel = createButtonPanel();

        // Add components to main panel
        mainPanel.add(displayPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add main panel to frame
        add(mainPanel);
    }

    private JPanel createDisplayPanel() {
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        displayPanel.setBackground(BACKGROUND_COLOR);

        // Operation label (shows current operation)
        operationLabel = new JLabel(" ");
        operationLabel.setFont(new Font("SF Pro Display", Font.PLAIN, 16));
        operationLabel.setForeground(new Color(142, 142, 147));
        operationLabel.setHorizontalAlignment(JLabel.RIGHT);
        operationLabel.setPreferredSize(new Dimension(320, 25));

        // Main display field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 48));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(DISPLAY_BG);
        display.setForeground(TEXT_DARK);
        display.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR, 1),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));
        display.setPreferredSize(new Dimension(320, 80));
        display.setText("0");

        displayPanel.add(Box.createVerticalStrut(5));
        displayPanel.add(operationLabel);
        displayPanel.add(Box.createVerticalStrut(8));
        displayPanel.add(display);

        return displayPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 12, 12));
        buttonPanel.setBackground(BACKGROUND_COLOR);

        // Enhanced button layout with better organization
        String[][] buttonLabels = {
                {"AC", "⌫", "±", "÷"},
                {"7", "8", "9", "×"},
                {"4", "5", "6", "−"},
                {"1", "2", "3", "+"},
                {"0", ".", "√", "="}
        };

        // Create buttons with improved styling
        for (String[] row : buttonLabels) {
            for (String label : row) {
                JButton button = createStyledButton(label);
                buttonPanel.add(button);
            }
        }

        return buttonPanel;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);

        // Enhanced font
        if (text.equals("0")) {
            button.setFont(new Font("SF Pro Display", Font.ITALIC, 28));
        } else {
            button.setFont(new Font("SF Pro Display", Font.ITALIC, 24));
        }

        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.addActionListener(this);

        // Enhanced color scheme and styling
        if (isOperator(text)) {
            styleButton(button, OPERATOR_COLOR, TEXT_WHITE);
        } else if (text.equals("=")) {
            styleButton(button, EQUALS_COLOR, TEXT_WHITE);
        } else if (text.equals("AC") || text.equals("⌫")) {
            styleButton(button, CLEAR_COLOR, TEXT_DARK);
        } else if (text.equals("±") || text.equals("√")) {
            styleButton(button, FUNCTION_COLOR, TEXT_DARK);
        } else {
            styleButton(button, NUMBER_COLOR, TEXT_DARK);
        }

        // Add hover effect
        addHoverEffect(button);

        // Set consistent size
        button.setPreferredSize(new Dimension(70, 70));

        return button;
    }

    private void styleButton(JButton button, Color bgColor, Color textColor) {
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 0, 20), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        // Add subtle shadow effect
        button.setBorder(BorderFactory.createCompoundBorder(
                button.getBorder(),
                BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 0, 0, 30))
        ));
    }

    private void addHoverEffect(JButton button) {
        Color originalColor = button.getBackground();

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(originalColor.brighter());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(originalColor);
            }
        });
    }

    private boolean isOperator(String text) {
        return text.equals("+") || text.equals("−") || text.equals("×") || text.equals("÷");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        handleButtonClick(command);
    }

    private void handleButtonClick(String text) {
        switch (text) {
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                handleDigit(text);
                break;
            case ".":
                handleDecimal();
                break;
            case "+": case "−": case "×": case "÷":
                handleOperator(text);
                break;
            case "=":
                calculate();
                break;
            case "AC":
                clear();
                break;
            case "⌫":
                backspace();
                break;
            case "±":
                toggleSign();
                break;
            case "√":
                squareRoot();
                break;
        }
    }

    private void updateOperationLabel() {
        if (!operator.isEmpty()) {
            String opSymbol = operator;
            // Convert internal operators to display symbols
            switch (operator) {
                case "*": opSymbol = "×"; break;
                case "/": opSymbol = "÷"; break;
                case "-": opSymbol = "−"; break;
            }
            operationLabel.setText(formatResult(firstNumber) + " " + opSymbol);
        } else {
            operationLabel.setText(" ");
        }
    }

    private void handleDigit(String digit) {
        if (startNewNumber) {
            display.setText(digit);
            startNewNumber = false;
        } else {
            String currentText = display.getText();
            if (currentText.equals("0")) {
                display.setText(digit);
            } else if (currentText.length() < 15) { // Limit display length
                display.setText(currentText + digit);
            }
        }
    }

    private void handleDecimal() {
        if (startNewNumber) {
            display.setText("0.");
            startNewNumber = false;
        } else if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
        }
    }

    private void handleOperator(String op) {
        if (!operator.isEmpty() && !startNewNumber) {
            calculate();
        }
        try {
            firstNumber = Double.parseDouble(display.getText());
            // Convert display operators to internal operators
            switch (op) {
                case "×": operator = "*"; break;
                case "÷": operator = "/"; break;
                case "−": operator = "-"; break;
                default: operator = op; break;
            }
            updateOperationLabel();
            startNewNumber = true;
        } catch (NumberFormatException e) {
            display.setText("Error");
            operationLabel.setText(" ");
            startNewNumber = true;
        }
    }

    private void calculate() {
        if (operator.isEmpty()) return;

        try {
            double secondNumber = Double.parseDouble(display.getText());
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        display.setText("Cannot divide by zero");
                        operationLabel.setText(" ");
                        operator = "";
                        startNewNumber = true;
                        return;
                    }
                    break;
            }

            // Format result nicely
            display.setText(formatResult(result));

        } catch (NumberFormatException e) {
            display.setText("Error");
        }

        operator = "";
        operationLabel.setText(" ");
        startNewNumber = true;
    }

    private String formatResult(double result) {
        // Handle very large or very small numbers
        if (Math.abs(result) >= 1e15 || (Math.abs(result) <= 1e-10 && result != 0)) {
            return String.format("%.3e", result);
        }

        if (result == (long) result) {
            return String.valueOf((long) result);
        } else {
            // Limit to 10 decimal places and remove trailing zeros
            String formatted = String.format("%.10f", result);
            formatted = formatted.replaceAll("0*$", "").replaceAll("\\.$", "");

            // Limit total display length
            if (formatted.length() > 15) {
                formatted = String.format("%.6e", result);
            }

            return formatted;
        }
    }

    private void clear() {
        display.setText("0");
        operationLabel.setText(" ");
        firstNumber = 0;
        operator = "";
        startNewNumber = true;
    }

    private void backspace() {
        String currentText = display.getText();
        if (!currentText.equals("0") && !currentText.equals("Error") && !currentText.contains("Cannot")) {
            if (currentText.length() > 1) {
                display.setText(currentText.substring(0, currentText.length() - 1));
            } else {
                display.setText("0");
                startNewNumber = true;
            }
        }
    }

    private void toggleSign() {
        try {
            double value = Double.parseDouble(display.getText());
            value = -value;
            display.setText(formatResult(value));
        } catch (NumberFormatException e) {
            display.setText("Error");
            operationLabel.setText(" ");
        }
    }

    private void squareRoot() {
        try {
            double value = Double.parseDouble(display.getText());
            if (value >= 0) {
                double result = Math.sqrt(value);
                display.setText(formatResult(result));
                startNewNumber = true;
            } else {
                display.setText("Invalid input");
                startNewNumber = true;
            }
        } catch (NumberFormatException e) {
            display.setText("Error");
        }
        operationLabel.setText(" ");
    }

    public static void main(String[] args) {
        // Set system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Fallback to default look and feel
        }

        // Use SwingUtilities to ensure thread safety
        SwingUtilities.invokeLater(CalculatorApp::new);
    }
}