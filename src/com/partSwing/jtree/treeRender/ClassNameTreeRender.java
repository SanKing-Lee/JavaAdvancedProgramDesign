package com.partSwing.jtree.treeRender;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.lang.reflect.Modifier;

/**
 * Author: Sean
 * Date: Created In 0:30 2019/5/7
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class ClassNameTreeRender extends DefaultTreeCellRenderer {
    private Font plainFont = null;
    private Font italicFont = null;

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
                                                  boolean expanded, boolean leaf, int row, boolean hasFocus){
        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
        Class<?> c = (Class<?>)node.getUserObject();

        if(plainFont == null){
            plainFont = getFont();
            if(plainFont!=null){
                italicFont = plainFont.deriveFont(Font.ITALIC);
            };
        }

        if((c.getModifiers()&Modifier.ABSTRACT) == 0) {
            setFont(plainFont);
        }
        else{
            setFont(italicFont);
        }
        return this;
    }
}
