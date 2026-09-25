import java.awt.*;
import java.awt.event.*;

class Calculator extends Frame implements ActionListener {
    
    TextField screen;
    Button[] numberB;
    Button badd, bsub, bmul, bdiv, bdeci, bequal; 
    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char op = ' ';
    Boolean isOpPressed = false;
    
    Calculator() {
        setTitle("Calculator");
        setSize(320, 450);
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(112, 117, 122));
        
        screen = new TextField("0");
        screen.setEditable(false);
        screen.setBackground(new Color(214, 222, 224));
        screen.setFont(new Font("Monospaced", Font.BOLD, 28));
        
        Panel display = new Panel();
        display.setLayout(new BorderLayout());
        display.add(screen, BorderLayout.CENTER);
        
        Panel buttonP = new Panel();
        buttonP.setLayout(new GridLayout(4, 4, 10, 10));
        
        badd = createButton("+", Color.WHITE);
        bsub = createButton("-", Color.WHITE);
        bmul = createButton("x", Color.WHITE);
        bdeci = createButton(".", Color.WHITE);
        bdiv = createButton("÷", Color.WHITE);
        bequal = createButton("=", new Color(243, 142, 43));
        
        numberB = new Button[10];
        for (int i = 0; i < 10; i++) {
            numberB[i] = createButton(String.valueOf(i), Color.WHITE);
        }
        
        buttonP.add(numberB[7]);
        buttonP.add(numberB[8]);
        buttonP.add(numberB[9]);
        buttonP.add(bdiv);
        
        buttonP.add(numberB[4]);
        buttonP.add(numberB[5]);
        buttonP.add(numberB[6]);
        buttonP.add(bmul);
        
        buttonP.add(numberB[1]);
        buttonP.add(numberB[2]);
        buttonP.add(numberB[3]);
        buttonP.add(bsub);
        
        buttonP.add(numberB[0]);
        buttonP.add(bdeci);
        buttonP.add(badd);
        buttonP.add(bequal);
        
        add(display, BorderLayout.NORTH);
        add(buttonP, BorderLayout.CENTER);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        setLocationRelativeTo(null);
    }
    
    public Button createButton(String text, Color bg) {
        Button b = new Button(text);
        b.setBackground(bg);
        b.setFont(new Font("SansSerif", Font.BOLD, 20));
        b.setForeground(new Color(33, 37, 41));
        b.addActionListener(this);
        return b;
    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();         
        for (int i = 0; i < 10; i++) {
            if (source == numberB[i]) {
                if (isOpPressed || screen.getText().equals("0")) {
                    screen.setText(String.valueOf(i));
                    isOpPressed = false;
                } else {
                    screen.setText(screen.getText() + i);
                }
                return;
            }
        }
        
        if (source == bdeci) {
            if (isOpPressed) {
                screen.setText("0.");
                isOpPressed = false;
            } else if (!screen.getText().contains(".")) {
                screen.setText(screen.getText() + ".");
            }
        } 
        else if (source == badd || source == bsub || source == bmul || source == bdiv) {
            num1 = Double.parseDouble(screen.getText());
            if (source == badd) op = '+';
            if (source == bsub) op = '-';
            if (source == bmul) op = 'x';
            if (source == bdiv) op = '÷';
            isOpPressed = true;
        } 
        else if (source == bequal) {
            num2 = Double.parseDouble(screen.getText());
            
            switch (op) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case 'x': result = num1 * num2; break;
                case '÷': 
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        screen.setText("Error");
                        return;
                    }
                    break;
            }
            
            if (result == (long) result) {
                screen.setText(String.valueOf((long) result));
            } else {
                screen.setText(String.valueOf(result));
            }
            isOpPressed = true;
        }
    }
    
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.setVisible(true);
    }
}