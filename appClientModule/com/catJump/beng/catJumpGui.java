package com.catJump.beng;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.FocusAdapter;

public class catJumpGui {
    private JPanel boot;
    private JList 测试list;
    private JButton 新增Button;
    private JButton 启动Button;
    private JButton 修改Button;

    public catJumpGui() {
        新增Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(boot,actionEvent.getActionCommand()+"点击");
                String[] a = {"10"};
                测试list.setListData(a);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("catJumpGui");
        frame.setContentPane(new catJumpGui().boot);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
        frame.setSize(800,400);
        frame.setVisible(true);
    }

}
