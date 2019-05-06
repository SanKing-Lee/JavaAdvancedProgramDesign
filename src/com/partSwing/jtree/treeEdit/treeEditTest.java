package com.partSwing.jtree.treeEdit;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Sean
 * Date: Created In 0:02 2019/5/7
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class treeEditTest {
    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            JFrame frame = new TreeEditFrame();
            frame.setTitle("TreeEdit");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
