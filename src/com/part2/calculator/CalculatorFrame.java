package com.part2.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: Sean
 * Date: Created In 16:33 2019/3/21
 * Title: 计算器界面
 * Description: 利用GridLayout设置计算器的按钮
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class CalculatorFrame extends JFrame {
    private JPanel calculateJPanel;
    private double calResult;
    private String lastCommand;
    private JButton display;
    private boolean isStart;
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_LENGTH = 480;

    public CalculatorFrame() {
        isStart = true;
        calResult = 0.0;
        lastCommand = "=";

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLayout(new BorderLayout());
        setBounds((screenSize.width-DEFAULT_WIDTH)/2,
                (screenSize.height-DEFAULT_LENGTH)/2,
                DEFAULT_WIDTH, DEFAULT_LENGTH);

        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        initCalculateJPanel();
        add(calculateJPanel, BorderLayout.CENTER);
    }

    public void initCalculateJPanel(){
        calculateJPanel = new JPanel();
        calculateJPanel.setLayout(new GridLayout(4, 4));
        InsertAction insert = new InsertAction();
        CommandAction command = new CommandAction();

        // first row
        addButtonToCalculateJPanel("7", insert);
        addButtonToCalculateJPanel("8", insert);
        addButtonToCalculateJPanel("9", insert);
        addButtonToCalculateJPanel("/", command);

        // second row
        addButtonToCalculateJPanel("4", insert);
        addButtonToCalculateJPanel("5", insert);
        addButtonToCalculateJPanel("6", insert);
        addButtonToCalculateJPanel("*", command);

        // third row
        addButtonToCalculateJPanel("1", insert);
        addButtonToCalculateJPanel("2", insert);
        addButtonToCalculateJPanel("3", insert);
        addButtonToCalculateJPanel("+", command);

        // forth row
        addButtonToCalculateJPanel("0", insert);
        addButtonToCalculateJPanel(".", insert);
        addButtonToCalculateJPanel("=", command);
        addButtonToCalculateJPanel("*", command);
    }

    public void addButtonToCalculateJPanel(String label, ActionListener listener){
        JButton button= new JButton(label);
        button.addActionListener(listener);
        calculateJPanel.add(button);
    }

    private class InsertAction implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String input = event.getActionCommand();
            if(isStart){
                display.setText("");
                isStart = false;
            }
            display.setText(display.getText() + input);
        }
    }

    private class CommandAction implements  ActionListener{
        public void actionPerformed(ActionEvent event){
            String command = event.getActionCommand();
            if(isStart){
                if(command.equals("-")){
                    display.setText(command);
                    isStart = false;
                }
                else lastCommand = command;
            }
            else {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                isStart = true;
            }
        }
    }

    public void calculate(Double x){
        if(lastCommand.equals("+")) calResult += x;
        else if(lastCommand.equals("-")) calResult -= x;
        else if(lastCommand.equals("*")) calResult *= x;
        else if(lastCommand.equals("/")) calResult /= x;
        else if(lastCommand.equals("=")) calResult = x;
        display.setText("" + calResult);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_LENGTH);
    }
}
