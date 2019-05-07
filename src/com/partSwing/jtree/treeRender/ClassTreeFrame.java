package com.partSwing.jtree.treeRender;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Enumeration;

/**
 * Author: Sean
 * Date: Created In 0:28 2019/5/7
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class ClassTreeFrame extends JFrame {
    private static int DEFAULT_WIDTH = 400;
    private static int DEFAULT_HEIGHT = 300;

    private DefaultMutableTreeNode root;
    private DefaultTreeModel model;
    private JTree tree;
    private JTextField textField;
    private JTextArea textArea;

    public ClassTreeFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        root = new DefaultMutableTreeNode(java.lang.Object.class);
        root.setAllowsChildren(true);
        model = new DefaultTreeModel(root, true);
        tree = new JTree(model);
        // tree.setRootVisible(false);

        ClassNameTreeRender classNameTreeRender = new ClassNameTreeRender();
        tree.setCellRenderer(classNameTreeRender);

        tree.addTreeSelectionListener(event->{
            TreePath path = tree.getSelectionPath();
            if(path == null) return;
            DefaultMutableTreeNode node =
                    (DefaultMutableTreeNode)path.getLastPathComponent();
            Class<?> c = (Class<?>)node.getUserObject();
            textArea.setText(getFiledDescription(c));
        });

        int mode = TreeSelectionModel.SINGLE_TREE_SELECTION;
        tree.getSelectionModel().setSelectionMode(mode);

        textArea = new JTextArea();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(new JScrollPane(tree));
        panel.add(new JScrollPane(textArea));
        add(panel, BorderLayout.CENTER);

        addTextField();
    }

    @SuppressWarnings("unchecked")
    public DefaultMutableTreeNode findUserObject(Object obj) {
        Enumeration<TreeNode> enumeration = (Enumeration<TreeNode>) root.breadthFirstEnumeration();
        while (enumeration.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration.nextElement();
            if (node.getUserObject().equals(obj)) {
                return node;
            }
        }

        return null;
    }

    public static String getFiledDescription(Class<?> c) {
        StringBuilder stringBuilder = new StringBuilder();
        Field[] fields = c.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if ((field.getModifiers() & Modifier.STATIC) == 0) {
                stringBuilder.append("static ");
            }
            stringBuilder.append(field.getType().getName());
            stringBuilder.append(" ");
            stringBuilder.append(field.getName());
            stringBuilder.append(";\n");
        }
        return stringBuilder.toString();
    }

    public DefaultMutableTreeNode addClass(Class<?> c) {
        if (c.isInterface() | c.isPrimitive()) {
            return null;
        }
        DefaultMutableTreeNode node = findUserObject(c);
        if (node != null) {
            return node;
        }
        Class<?> s = c.getSuperclass();
        DefaultMutableTreeNode parent;
        if (s == null) {
            parent = root;
        }
        // 递归调用，添加所有的超类
        else {
            parent = addClass(s);
        }
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(c);
        model.insertNodeInto(newNode, parent, parent.getChildCount());

        TreePath path = new TreePath(model.getPathToRoot(newNode));
        tree.makeVisible(path);
        return newNode;
    }

    public void addTextField() {
        JPanel panel = new JPanel();
        ActionListener addListener = event -> {
            try{
                String text = textField.getText();
                addClass(Class.forName(text));
                textField.setText("");
            } catch(ClassNotFoundException e){
                JOptionPane.showMessageDialog(null, "Class Not Found!");
            }
        };
        textField = new JTextField(20);
        textField.addActionListener(addListener);
        panel.add(textField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(addListener);
        panel.add(addButton);

        add(panel, BorderLayout.SOUTH);
    }
}