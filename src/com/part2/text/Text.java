package com.part2.text;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Sean
 * Date: Created In 17:04 2019/3/21
 * Title: 运行界面
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class Text {
    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            JFrame frame = new TextComponentFrame();
            frame.setTitle("Text");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
