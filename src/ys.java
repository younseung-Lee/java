
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;

public class ys extends JFrame implements ActionListener, KeyListener {
private static final long serialVersionUID = 7273877133342886980L;
JPanel mainP, text, num, sign, misc; 
JButton[] number;
JButton add, sub, mul, div, equal; 
JTextField output; 
JMenu file;

String op; 
double num1, num2; 
boolean go = true;
NumberFormat f9 = new DecimalFormat("0.#########");

public ys() { 
super("°è»ê±â"); 

mainP = new JPanel(); 
text = new JPanel();
num = new JPanel(); 
number = new JButton[15]; 

for (int i = 0; i < 10; i++) {
number[i] = new JButton(i + ""); 
number[i].addActionListener(this); 
}

number[10] = new JButton("+");
number[11] = new JButton("-");
number[12] = new JButton("*");
number[13] = new JButton("/");
number[14] = new JButton("=");
number[10].addActionListener(this);
number[11].addActionListener(this);
number[12].addActionListener(this);
number[13].addActionListener(this);
number[14].addActionListener(this);

output = new JTextField("0");
output.setHorizontalAlignment(JTextField.RIGHT); 
output.setEditable(false); 
Container stuff = getContentPane(); 
BoxLayout Lay = new BoxLayout(stuff, BoxLayout.Y_AXIS); 

GridLayout tLay = new GridLayout(1, 1, 5, 5); 
GridLayout nLay = new GridLayout(5, 3, 5, 5); 

stuff.setLayout(Lay); 
text.setLayout(tLay);

num.setLayout(nLay);
text.add(output); 
for (int i = 9; i > -1; i--)
num.add(number[i]);

num.add(number[10]);
num.add(number[11]);
num.add(number[12]);
num.add(number[13]);
num.add(number[14]);

mainP.add(num);

stuff.add(text);

stuff.add(mainP);
pack();
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
addKeyListener(this); 
setVisible(true);
}

public void actionPerformed(ActionEvent e) { 
Object evt = e.getSource(); 
System.out.println(go + "");
if (evt == number[10]) { 
op = "+"; 
num1 = Double.parseDouble(output.getText()); 
output.setText("0"); 
go = true; 

} else if (evt == number[11]) { 
op = "-";
num1 = Double.parseDouble(output.getText());
output.setText("0");
go = true;
} else if (evt == number[12]) {
op = "*";
num1 = Double.parseDouble(output.getText());
output.setText("0");
go = true;
} else if (evt == number[13]) {
op = "/";
num1 = Double.parseDouble(output.getText());
output.setText("0");
go = true;
} else if (evt == number[14]) {
if (go) { 
num2 = Double.parseDouble(output.getText());
if (op.equals("+"))
output.setText(f9.format(num1 + num2) + ""); 
if (op.equals("-"))
output.setText(f9.format(num1 - num2) + "");
if (op.equals("*"))
output.setText(f9.format(num1 * num2) + "");
if (op.equals("/"))
output.setText(f9.format(num1 / num2) + "");
go = false; 
}
}
for (int i = 0; i < 10; i++)
if (evt == number[i]) { 
if (output.getText().substring(0, 1).equals("0"))
eraseNum(); 
addNum(i + "");
}
}

public static void main(String[] args) {

new ys();
}

public void keyPressed(KeyEvent e) {
int key = e.getKeyCode();
String txt = KeyEvent.getKeyText(key);
addNum(txt);
}

public void addNum(String s) {
String tmp = output.getText();
tmp += s;
output.setText(tmp);
}

public void eraseNum() { 
String tmp = output.getText();
tmp = tmp.substring(0, tmp.length() - 1);
output.setText(tmp);
}

public void keyReleased(KeyEvent e) { 
}

public void keyTyped(KeyEvent e) {
}
}