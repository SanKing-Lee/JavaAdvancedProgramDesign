package com.partSwing.jtree.treeModel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Dimension2D;

/**
 * Author: Sean
 * Date: Created In 10:59 2019/5/7
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class ObjectInspectorFrame extends JFrame {
    private JTree tree;
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 450;
    public ObjectInspectorFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension2D screen = toolkit.getScreenSize();
        setLocation((int)(screen.getWidth() - DEFAULT_WIDTH)/2, (int)(screen.getHeight()-DEFAULT_HEIGHT)/2);

        Variable v = new Variable(getClass(), "this", this);
        ObjectTreeModel objectTreeModel = new ObjectTreeModel();
        objectTreeModel.setRoot(v);

        tree = new JTree(objectTreeModel);
        add(new JScrollPane(tree));
    }
}
