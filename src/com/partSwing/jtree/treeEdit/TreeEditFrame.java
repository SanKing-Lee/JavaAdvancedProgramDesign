package com.partSwing.jtree.treeEdit;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

/**
 * Author: Sean
 * Date: Created In 23:44 2019/5/6
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class TreeEditFrame extends JFrame {
    private static int DEFAULT_WIDTH = 400;
    private static int DEFAULT_HEIGHT = 300;

    private DefaultTreeModel model;
    private JTree tree;

    public TreeEditFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        DefaultMutableTreeNode root = (DefaultMutableTreeNode)makeSampleTree();
        model = new DefaultTreeModel(root);
        tree = new JTree(model);
        tree.setEditable(true);

        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane, BorderLayout.CENTER);

        makeButtons();
    }

    public TreeNode makeSampleTree(){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("World");
        DefaultMutableTreeNode country = new DefaultMutableTreeNode("USA");
        root.add(country);
        DefaultMutableTreeNode state = new DefaultMutableTreeNode("California");
        country.add(state);
        DefaultMutableTreeNode city = new DefaultMutableTreeNode("San Jose");
        state.add(city);
        city = new DefaultMutableTreeNode("Cupertino");
        state.add(city);
        state = new DefaultMutableTreeNode("Michigan");
        country.add(state);
        city = new DefaultMutableTreeNode("Ann Arbor");
        state.add(city);
        country = new DefaultMutableTreeNode("Germany");
        root.add(country);
        state = new DefaultMutableTreeNode("Schleswig-Holstein");
        country.add(state);
        city = new DefaultMutableTreeNode("Kiel");
        state.add(city);
        country = new DefaultMutableTreeNode("China");
        root.add(country);
        city = new DefaultMutableTreeNode("CQ");
        city.setAllowsChildren(true);
        country.add(city);

        return root;
    }

    public void makeButtons(){
        JPanel panel = new JPanel();

        JButton addSiblingButton = new JButton("Add Sibling");
        addSiblingButton.addActionListener(event->{
            DefaultMutableTreeNode selectedNode =
                    (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
            if(selectedNode == null){
                return;
            }
            DefaultMutableTreeNode parent = (DefaultMutableTreeNode)selectedNode.getParent();
            if(parent == null){
                return;
            }
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("New");
            model.insertNodeInto(newNode, parent, parent.getChildCount());
            TreeNode[] nodes = model.getPathToRoot(newNode);
            TreePath path = new TreePath(nodes);
            tree.scrollPathToVisible(path);
        });
        panel.add(addSiblingButton);

        JButton addChildButton = new JButton("Add Child");
        addChildButton.addActionListener(event->{
            DefaultMutableTreeNode selectedNode =
                    (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
            if(selectedNode == null){
                return;
            }
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("New");
            model.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
            TreeNode[] nodes = model.getPathToRoot(newNode);
            TreePath path = new TreePath(nodes);
            tree.scrollPathToVisible(path);
        });
        panel.add(addChildButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(event->{
            DefaultMutableTreeNode selectedNode =
                    (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
            if(selectedNode == null){
                return;
            }
            DefaultMutableTreeNode parent = (DefaultMutableTreeNode)selectedNode.getParent();
            if(parent == null){
                return;
            }
            model.removeNodeFromParent(selectedNode);
        });
        panel.add(deleteButton);

        add(panel, BorderLayout.SOUTH);
    }
}
