package beng;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class As extends JFrame {
    private static final long serialVersionUID = 1L;
    // 定义热键标识，用于在设置多个热键时，在事件处理中区分用户按下的热键
    public static final int FUNC_KEY_MARK = 1;
    public static final int EXIT_KEY_MARK = 0;

    JButton msgBtn;
    JButton exitBtn;

    public As() {
        this.setTitle("全局热键设置");
        this.setBounds(100, 100, 100, 100);
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        msgBtn = new JButton("弹出框（Alt+S）");
        // 设置按钮边距
        msgBtn.setMargin(new Insets(0, 0, 0, 0));
        msgBtn.setFocusable(false);
        msgBtn.setBounds(0, 0, 10, 0);
        msgBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessage();
            }
        });
        this.add(msgBtn);

        exitBtn = new JButton("退出（Alt+Q）");
        exitBtn.setMargin(new Insets(0, 0, 0, 0));
        exitBtn.setFocusable(false);
        exitBtn.setBounds(10, 0, 10, 0);
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(exitBtn);

        // 第一步：注册热键，第一个参数表示该热键的标识，第二个参数表示组合键，如果没有则为0，第三个参数为定义的主要热键
        JIntellitype.getInstance().registerHotKey(FUNC_KEY_MARK, JIntellitype.MOD_ALT, (int) 'S');
        JIntellitype.getInstance().registerHotKey(EXIT_KEY_MARK, JIntellitype.MOD_ALT, (int) 'Q');

        // 第二步：添加热键监听器
        JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
            @Override
            public void onHotKey(int markCode) {
                System.out.println(markCode);
                switch (markCode) {
                    case FUNC_KEY_MARK:
                        showMessage();
                        break;
                    case EXIT_KEY_MARK:
                        System.exit(0);
                        break;
                }
            }
        });

        this.setVisible(true);
    }

    public void showMessage() {
        JOptionPane.showMessageDialog(null, "就算把窗口最小化，按快捷键Alt+S也可以弹出提示框哦！", "弹出框标题", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new As();
    }
}
