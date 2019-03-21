package com.part2.citymap;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Sean
 * Date: Created In 21:52 2019/3/19
 * Title: 测试城市录入
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */
public class TestInputFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new InputFrame("信息录入");
            frame.setVisible(true);
        });
    }
}
