package com.part2.citymap;

import com.part1.email.ValidateEmail;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Author: Sean
 * Date: Created In 17:37 2019/3/20
 * Title: 输入界面
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class InputFrame extends JFrame {
    /**
     * 在界面中用到的组件
     */
    private JTextField nameJTextField, addressJTextField, emailJTextField, nativeJTextField;
    private JComboBox genderJComboBox, provinceJComboBox, cityJComboBox;
    private JLabel nameJLabel, addressJLabel, emailJLabel, genderJLabel, provinceJLabel, cityJLabel, nativeJLabel;
    private JButton saveButton;
    private JButton cancelButton;
    private JTextArea infoArea;

    /**
     * 默认的宽度和宽度
     */
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 660;

    /**
     * 枚举所有的性别
     */
    private static final String[] genders = {"男", "女"};
    /**
     * 检测是否选择了籍贯
     */
    private boolean isChoosedNative = false;
    /**
     * 构造函数
     *
     * @param title 界面名称
     */
    public InputFrame(String title) {
        // 设置界面属性
        super(title);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLayout(null);
        setBounds((screenSize.width - DEFAULT_WIDTH) / 2, (screenSize.height - DEFAULT_HEIGHT) / 2,
                DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置文本输入框
        nameJTextField = new JTextField(20);
        addressJTextField = new JTextField(30);
        emailJTextField = new JTextField(30);

        // 设置性别框
        genderJComboBox = new JComboBox<>();
        genderJComboBox.setModel(new DefaultComboBoxModel(genders));

        // 设置籍贯框
        provinceJComboBox = new JComboBox<>();
        provinceJComboBox.setModel(new DefaultComboBoxModel(CityMap.getProvinces()));

        provinceJComboBox.addItemListener(e->{
            String selectedProvince = (String) provinceJComboBox.getSelectedItem();
            if (cityJComboBox != null) {
                cityJComboBox.removeAllItems();
            }
            cityJComboBox.setModel(new DefaultComboBoxModel(CityMap.getCitiesByProvince(selectedProvince)));
            isChoosedNative = true;
        });
//        provinceJComboBox.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                String selectedProvince = (String) provinceJComboBox.getSelectedItem();
//                if (cityJComboBox != null) {
//                    cityJComboBox.removeAllItems();
//                }
//                cityJComboBox.setModel(new DefaultComboBoxModel(CityMap.getCitiesByProvince(selectedProvince)));
//                isChoosedNative = true;
//            }
//        });
        cityJComboBox = new JComboBox<>();

        // 设置保存和重置按钮
        saveButton = new JButton("保存");
        saveButton.addActionListener(e->{
            if (nameJTextField.getText().equals("") || nameJTextField.getText().charAt(0) == ' ') {
                showMessageDialog(null, "姓名有误，请重新输入！");
                return;
            }
            if (!isChoosedNative) {
                showMessageDialog(null, "请选择籍贯！");
                return;
            }
            if (addressJTextField.getText().equals("") || addressJTextField.getText().charAt(0) == ' ') {
                showMessageDialog(null, "通信地址有误，请重新输入！");
                return;
            }
            if (!ValidateEmail.isEmail(emailJTextField.getText())) {
                showMessageDialog(null, "邮箱地址有误，请重新输入！");
                return;
            }
            infoArea.setText("基本信息：\n");
            String string = "";
            string += "\n" + "姓名：" + nameJTextField.getText() + "\n性别：" + genderJComboBox.getSelectedItem();
            string += "\n" + "籍贯：" + provinceJComboBox.getSelectedItem() +
                    ((cityJComboBox.getSelectedItem() != null) ? cityJComboBox.getSelectedItem() : "");
            string += "\n" + "通讯地址：" + addressJTextField.getText();
            string += "\n" + "邮箱：" + emailJTextField.getText();
            infoArea.append(string);
        });
//        saveButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (nameJTextField.getText().equals("") || nameJTextField.getText().charAt(0) == ' ') {
//                    showMessageDialog(null, "姓名有误，请重新输入！");
//                    return;
//                }
//                if (!isChoosedNative) {
//                    showMessageDialog(null, "请选择籍贯！");
//                    return;
//                }
//                if (addressJTextField.getText().equals("") || addressJTextField.getText().charAt(0) == ' ') {
//                    showMessageDialog(null, "通信地址有误，请重新输入！");
//                    return;
//                }
//                if (!ValidateEmail.isEmail(emailJTextField.getText())) {
//                    showMessageDialog(null, "邮箱地址有误，请重新输入！");
//                    return;
//                }
//                String string = "";
//                string += "\n" + "姓名：" + nameJTextField.getText() + "\n性别：" + genderJComboBox.getSelectedItem();
//                string += "\n" + "籍贯：" + provinceJComboBox.getSelectedItem() +
//                        ((cityJComboBox.getSelectedItem() != null) ? cityJComboBox.getSelectedItem() : "");
//                string += "\n" + "通讯地址：" + addressJTextField.getText();
//                string += "\n" + "邮箱：" + emailJTextField.getText();
//                infoArea.append(string);
//            }
//        });
        cancelButton = new JButton("取消");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoArea.setText("基本信息：\n");
            }
        });

        // 设置文本显示框
        infoArea = new JTextArea();
        infoArea.setText("基本信息：\n");

        // 初始化所有的标签
        nameJLabel = new JLabel("姓名");
        nativeJLabel = new JLabel("籍贯");
        emailJLabel = new JLabel("邮箱");
        genderJLabel = new JLabel("性别");
        addressJLabel = new JLabel("通讯地址");
        provinceJLabel = new JLabel("省（市）");
        cityJLabel = new JLabel("市");


        // 第一个部分，基本信息
        final JPanel pan1 = new JPanel();
        pan1.setLayout(new GridLayout(1, 4));
        pan1.setBorder(new TitledBorder("基本信息"));
        pan1.setBounds(12, 12, 418, 70);
        pan1.add(nameJLabel);
        pan1.add(nameJTextField);
        pan1.add(genderJLabel);
        pan1.add(genderJComboBox);
        getContentPane().add(pan1);

        // 第二个部分，籍贯
        final JPanel pan2 = new JPanel();
        pan2.setLayout(new GridLayout());
        pan2.setBorder(new TitledBorder("籍贯"));
        pan2.setBounds(12, 98, 418, 70);
        pan2.add(provinceJLabel);
        pan2.add(provinceJComboBox);
        pan2.add(cityJLabel);
        pan2.add(cityJComboBox);
        add(pan2);

        // 第三个部分，通讯地址和邮箱
        final JPanel pan3 = new JPanel();
        pan3.setLayout(new GridLayout());
        pan3.setBorder(new TitledBorder("通信"));
        pan3.setBounds(12, 184, 418, 70);
        pan3.add(addressJLabel);
        pan3.add(addressJTextField);
        pan3.add(emailJLabel);
        pan3.add(emailJTextField);
        add(pan3);


        // 第四个部分，保存和重置按钮
        final JPanel pan4 = new JPanel();
        pan4.setLayout(null);
        pan4.setBorder(new TitledBorder("已录入信息"));
        pan4.setBounds(12, 278, 418, 70);
        saveButton.setBounds(80, 20, 60, 40);
        cancelButton.setBounds(280, 20, 60, 40);
        pan4.add(saveButton);
        pan4.add(cancelButton);
        add(pan4);

        // 第五个部分，文本显示框
        infoArea.setBounds(12, 360, 420, 200);
        add(infoArea);

        pack();

    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
