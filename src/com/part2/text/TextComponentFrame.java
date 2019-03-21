package com.part2.text;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Sean
 * Date: Created In 16:57 2019/3/21
 * Title: 文本组件界面
 * Description: 在一个界面里面加入文本域、文本区域、密码域、滚动窗格
 * Update History:
 * Version: 0.1
 * [Date][Version][Author] What has been done;
 */

public class TextComponentFrame extends JFrame {
    public static final int TEXTAREA_ROWS = 8;
    public static final int TEXTAREA_COLUMNS = 20;
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 640;

    public TextComponentFrame(){
        JTextField userNameText = new JTextField("", 10);
        JPasswordField userPwdText = new JPasswordField("", 20);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 4));
        northPanel.add(new JLabel("Name"));
        northPanel.add(userNameText);
        northPanel.add(new JLabel("Password"));
        northPanel.add(userPwdText);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setBounds((screenSize.width - DEFAULT_WIDTH)/2, (screenSize.height-DEFAULT_HEIGHT)/2,
                DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLayout(new BorderLayout());
        add(northPanel, BorderLayout.NORTH);
        pack();
    }

    public Dimension getPreferredSize() {return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);}
}
