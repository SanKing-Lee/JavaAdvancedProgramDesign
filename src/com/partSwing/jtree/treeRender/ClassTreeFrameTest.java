package com.partSwing.jtree.treeRender;

import javax.swing.*;
import javax.xml.stream.XMLEventWriter;
import java.awt.*;

/**
 * Author: Sean
 * Date: Created In 10:37 2019/5/7
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class ClassTreeFrameTest {
    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            JFrame frame = new ClassTreeFrame();
            frame.setTitle("ClassNameTree");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
