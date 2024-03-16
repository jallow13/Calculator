import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Calculator extends JFrame implements ActionListener, KeyListener {
    double num1=0,num2=0,result=0;
    char operator;
    JButton[]numberJButtons=new JButton[10];
    JButton[]functionalJButttons=new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton equButton,decButton,delButton,clrButton,negButton;
Font f=new Font("Italic",Font.BOLD,30);
    JTextField jTextField;
    JPanel jPanel;

  public   Calculator(){

      super("Calculator");
      setLayout(null);


      jTextField=new JTextField();
      jTextField.setBounds(50,25,300,50);
      jTextField.setFont(f);
      jTextField.setEditable(false);


      addButton=new JButton("+");
      subButton=new JButton("-");
      mulButton=new JButton("*");
      divButton=new JButton("/");
      equButton=new JButton("=");
      clrButton=new JButton("Clr..");
      delButton=new JButton("Del..");
      decButton=new JButton(".");
      negButton=new JButton("(-)");


     functionalJButttons[0]=addButton;
      functionalJButttons[1]=subButton;
      functionalJButttons[2]=mulButton;
      functionalJButttons[3]=divButton;
      functionalJButttons[4]=equButton;
      functionalJButttons[5]=clrButton;
      functionalJButttons[6]=delButton;
      functionalJButttons[7]=decButton;
      functionalJButttons[8]=negButton;

      //this.addKeyListener(this);
      jTextField.addKeyListener(this);
      for (int i=0;i<functionalJButttons.length;i++){
          functionalJButttons[i].addActionListener(this);
          functionalJButttons[i].setFont(f);
          functionalJButttons[i].setFocusable(false);
      }
      for (int i=0;i<numberJButtons.length;i++){
          numberJButtons[i]=new JButton(String.valueOf(i));
          numberJButtons[i].addActionListener(this);
          numberJButtons[i].setFont(f);
          numberJButtons[i].setFocusable(false);
      }

      negButton.setBounds(50,430,100,50);
      delButton.setBounds(150,430,100,50);
      clrButton.setBounds(250,430,100,50);

      jPanel=new JPanel();
      jPanel.setBounds(50,100,300,300);
      jPanel.setLayout(new GridLayout(4,4,10,10));


      jPanel.add(numberJButtons[1]);
      jPanel.add(numberJButtons[2]);
      jPanel.add(numberJButtons[3]);
      jPanel.add(addButton);

      jPanel.add(numberJButtons[4]);
      jPanel.add(numberJButtons[5]);
      jPanel.add(numberJButtons[6]);
      jPanel.add(subButton);

      jPanel.add(numberJButtons[7]);
      jPanel.add(numberJButtons[8]);
      jPanel.add(numberJButtons[9]);
      jPanel.add(mulButton);
      jPanel.add(decButton);
      jPanel.add(numberJButtons[0]);
      jPanel.add(equButton);
      jPanel.add(divButton);

      add(jPanel);

      add(jTextField);
      add(negButton);
      add(delButton);
      add(clrButton);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(450,550);
      setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

      for (int i=0;i<numberJButtons.length;i++){
          if (e.getSource()==numberJButtons[i]){
              jTextField.setText(jTextField.getText().concat(String.valueOf(i)));
          }
      }

        if (e.getSource()==decButton){
            if (jTextField.getText().indexOf('.')==-1) {
                jTextField.setText(jTextField.getText().concat(String.valueOf(".")));
            }
        }
        if (e.getSource()==addButton){
            num1=Double.parseDouble(jTextField.getText());
            operator='+';
            jTextField.setText("");
        }

        if (e.getSource()==subButton){
            num1=Double.parseDouble(jTextField.getText());
            operator='-';

            jTextField.setText("");
        }

        if (e.getSource()==mulButton){
            num1=Double.parseDouble(jTextField.getText());
            operator='*';
            jTextField.setText("");
        }

        if (e.getSource()==divButton){
            num1=Double.parseDouble(jTextField.getText());
            operator='/';
            jTextField.setText("");
        }
        if (e.getSource()==equButton){
            num2=Double.parseDouble(jTextField.getText());
            switch (operator){
                case '+': result=num1+num2;
                break;
                case '-': result=num1-num2;
                    break;
                case '*': result=num1*num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "Error: Division by zero", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = num1 / num2;
                    break;
            }
            jTextField.setText(String.valueOf(result));
            num1=result;

        }
        if (e.getSource()==clrButton){
            jTextField.setText("");
        }
        if (e.getSource()==delButton){
           String s=jTextField.getText();
            jTextField.setText("");
            for (int i=0;i<s.length()-1;i++){
                jTextField.setText(jTextField.getText()+s.charAt(i));
            }
        }
        if (e.getSource()==negButton){
           double temp=Double.parseDouble(jTextField.getText());
           temp*=-1;
           jTextField.setText(String.valueOf(temp));
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

      char keyChar=e.getKeyChar();
      if(Character.isDigit(keyChar)){
          jTextField.setText(jTextField.getText()+keyChar);

      }
      else if (keyChar=='.') {
          if (jTextField.getText().indexOf('.')==-1){
              //jTextField.setText(jTextField.getText()+keyChar);
              decButton.doClick();
          }
          
      }
      else if (keyChar=='+') {
          addButton.doClick();
      }
      else if (keyChar=='-') {
          subButton.doClick();
      }
      else if (keyChar=='*') {
          mulButton.doClick();
      }
      else if (keyChar=='/') {
          divButton.doClick();
      }
      else if (keyChar== '=') {
          equButton.doClick();
          
      }
      else if (keyChar==KeyEvent.VK_BACK_SPACE) {
          String text = jTextField.getText();
          if (!text.isEmpty()){
              jTextField.setText(text.substring(0,text.length()-1));
          }
      }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
