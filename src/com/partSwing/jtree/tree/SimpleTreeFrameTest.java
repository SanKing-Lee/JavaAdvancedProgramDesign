package com.partSwing.jtree.tree;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Sean
 * Date: Created In 23:22 2019/5/6
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class SimpleTreeFrameTest {
    public static void main(String [] args){
        EventQueue.invokeLater(()->{
            JFrame frame = new SimpleTreeFrame();
            frame.setTitle("SimpleTree");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
