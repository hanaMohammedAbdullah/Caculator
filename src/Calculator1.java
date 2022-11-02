

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator1  implements ActionListener {

    JFrame   frame;

    JTextField textField;

    Font myFont = new Font("Gadugi 24",Font.BOLD,30);

    JTextField textfield;

    JButton[] numberBut=new JButton[10];
    JButton[] functionbut = new JButton[9];
    JButton add,sub,mul,div,dec,equ,clr,del,neg;

    double num1=0,num2=0,result=0;

    char operations;



    Calculator1(){

    }

    public void luncher(){
        frame = new JFrame();
        JPanel panel= new JPanel();



        frame.setTitle("Caculator");
        frame.setLayout(null);
        frame.setSize(420, 560);
        frame.setResizable(false);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        frame.add(textfield);



        add= new JButton("+");
        sub= new JButton("-");
        mul= new JButton("*");
        div= new JButton("/");
        dec= new JButton(".");
        equ= new JButton("=");
        del=new JButton("=>");
        clr=new JButton("C");
        neg=new JButton("(-)");

        functionbut[0]=add;
        functionbut[1]=sub;
        functionbut[2]=mul;
        functionbut[3]=div;
        functionbut[4]=dec;
        functionbut[5]=equ;
        functionbut[6]=clr;
        functionbut[7]=del;
        functionbut[8]=neg;

        for(int i=0 ; i<9 ; i++){
            functionbut[i].addActionListener(this);
            functionbut[i].setFont(myFont);
            functionbut[i].setFocusable(false);
        }
        for(int i=0 ; i<10 ; i++){
            numberBut[i] = new JButton(String.valueOf(i));
            numberBut[i].addActionListener(this);
            numberBut[i].setFont(myFont);
            numberBut[i].setFocusable(false);

        }

        equ.setBounds(50, 410, 94, 60);
        del.setBounds(154,410 ,94,60);
        clr.setBounds(255,410 ,94,60);
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4 , 4 , 10 , 10));


        panel.add(numberBut[1]);
        panel.add(numberBut[2]);
        panel.add(numberBut[3]);
        panel.add(add);
        panel.add(numberBut[4]);
        panel.add(numberBut[5]);
        panel.add(numberBut[6]);
        panel.add(sub);
        panel.add(numberBut[7]);
        panel.add(numberBut[8]);
        panel.add(numberBut[9]);
        panel.add(mul);
        panel.add(dec);
        panel.add(numberBut[0]);
        panel.add(neg);
        panel.add(div);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.add(equ);
        frame.add(del);
        frame.add(clr);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Calculator1 calu=new Calculator1(); //create  instance of our caculator
        calu.luncher();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for(int i=0 ; i<10 ; i++){
            if (ae.getSource() == numberBut[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if (ae.getSource() == dec){
            textfield.setText(textfield.getText().concat("."));
        }
        if (ae.getSource() == clr){
            num1=0;
            num2=0;
            textfield.setText("");
        }
        if (ae.getSource() == sub){
            num1 =Double.parseDouble(textfield.getText());
            operations ='-';
            textfield.setText("");
        }
        if (ae.getSource() == add){ 
            num1 =Double.parseDouble(textfield.getText());
            operations ='+';
            textfield.setText("");
        }
        if (ae.getSource() == mul){
            num1 =Double.parseDouble(textfield.getText());
            operations ='*';
            textfield.setText("");
        }
        if (ae.getSource() == div){
            num1 =Double.parseDouble(textfield.getText());
            operations ='/';
            textfield.setText("");
        }
        if (ae.getSource() == neg){
            String result= neg(textfield.getText());
            textfield.setText(result);
        }
        if (ae.getSource() == equ){
            num2 =Double.parseDouble(textfield.getText());

            switch(operations){

                case '+':
                    result =add(num1,num2);
                    break;

                case '-':
                    result =sub(num1,num2);
                    break;

                case '*':
                    result =mult(num1,num2);
                    break;

                case '/':
                    result =div(num1,num2);
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if (ae.getSource() == del){
            String string=textfield.getText();
            textfield.setText("");
            for(int i=0; i < string.length()-1;i++){
                textfield.setText(textfield.getText()+string.charAt(i));
            }

        }
    }
    public double add(Double num1,Double num2){

        return  num1+num2;
    }
    public double mult(Double num1,Double num2){

        return  num1*num2;
    }
    public double sub(Double num1,Double num2){

        return  num1-num2;
    }
    public double div(Double num1,Double num2){

        return  num1/num2;
    }
    public String neg(String num){
        Double temp =Double.parseDouble(num);
        temp*=-1;
        String result=String.valueOf(temp);
        return  result;
    }

}
