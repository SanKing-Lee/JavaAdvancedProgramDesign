package com.partSwing.jtree.treeModel;

import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.lang.reflect.Field;
import java.util.EventListener;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Object;

/**
 * Author: Sean
 * Date: Created In 10:59 2019/5/7
 * Title:
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class ObjectTreeModel implements TreeModel {
    private Variable root;
    private EventListenerList eventListenerList = new EventListenerList();

    public ObjectTreeModel(){
        root = null;
    }

    public void setRoot(Variable root){
        Variable oldRoot = root;
        this.root = root;
        fireTreeStructureChanged(oldRoot);
    }

    public Object getRoot(){
        return root;
    }

    public int getChildCount(Object parent){
        return ((Variable)parent).getFields().size();
    }

    public Object getChild(Object parent, int index){
        List<Field> fields = ((Variable)parent).getFields();
        Field f = fields.get(index);
        Object parentValue = ((Variable)parent).getValue();
        try{
            return new Variable(f.getType(), f.getName(), f.get(parentValue));
        } catch (IllegalAccessException e){
            return null;
        }
    }
    public int getIndexOfChild(Object parent, Object child){
        int n = getChildCount(parent);
        for(int i = 0; i < n; i++){
            if(getChild(parent, i).equals(child)){
                return i;
            }
        }
        return -1;
    }

    public boolean isLeaf(Object node){
        return getChildCount(node) == 0;
    }

    public void valueForPathChanged(TreePath path, Object newValue){

    }

    public void addTreeModelListener(TreeModelListener l){
        eventListenerList.add(TreeModelListener.class, l);
    }

    public void removeTreeModelListener(TreeModelListener l){
        eventListenerList.remove(TreeModelListener.class, l);
    }

    public void fireTreeStructureChanged(Object oldRoot){
        TreeModelEvent event = new TreeModelEvent(this, new Object[]{oldRoot});
        for(TreeModelListener l: eventListenerList.getListeners(TreeModelListener.class)){
            l.treeStructureChanged(event);
        }
    }
}
