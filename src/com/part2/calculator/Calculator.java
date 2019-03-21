package com.part2.calculator;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Sean
 * Date: Created In 16:35 2019/3/21
 * Title: 运行计算器
 * Description: 将界面加入事件流
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class Calculator {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new CalculatorFrame();
            frame.setTitle("Layout");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
