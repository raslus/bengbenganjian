package com.catJump.beng;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class catJumpGui {
    private JPanel boot;
    private JList 测试list;
    private JButton 新增Button;
    private JButton 启动Button;
    private JButton 修改Button;

    public catJumpGui() {
//        String[] a = {"10"};
//        测试list.setListData(a);
        jx3HList.getInstance().initHlist();
        测试list.setListData(jx3HList.getInstance().getHList().toArray());
        测试list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println(测试list.getSelectedValue());
            }
        });
        新增Button.addActionListener(actionEvent -> {
//                JOptionPane.showMessageDialog(boot,actionEvent.getActionCommand()+"点击");
            openHEditFrame();
        });
        修改Button.addActionListener(actionEvent -> {
            openHEditFrame();
        });

    }

    public void openHEditFrame(){
        System.out.println(测试list.isSelectionEmpty());
        if(!测试list.isSelectionEmpty()){
            System.out.println(测试list.getSelectedIndex());
        }
        JFrame catJumpGui2 = new JFrame("配置信息");
        catJumpGui2.setContentPane(new catJumpGui2().conf);
        catJumpGui2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        catJumpGui2.setSize(600,400);
        catJumpGui2.setVisible(true);
        catJumpGui2.setAlwaysOnTop(true);
        catJumpGui2.setAutoRequestFocus(true);
        boot.setEnabled(false);
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
