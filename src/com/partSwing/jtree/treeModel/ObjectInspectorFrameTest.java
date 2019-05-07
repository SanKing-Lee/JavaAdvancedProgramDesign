package com.partSwing.jtree.treeModel;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Sean
 * Date: Created In 11:34 2019/5/7
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class ObjectInspectorFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new ObjectInspectorFrame();
            frame.setTitle("Object Inspector Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}
