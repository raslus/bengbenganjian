package beng;

import java.awt.*;
import java.util.Date;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import static beng.As.FUNC_KEY_MARK;

public class MPanel2 {
    public void run() {
        JFrame jf = new JFrame();
        jf.setTitle("蹦蹦辅助");
        jf.setSize(250, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout(3, 3));
        JButton btn = new JButton("木有用");
        jp1.add(btn);
        jf.setContentPane(jp1);
        jf.setVisible(true);
        JIntellitype.getInstance().registerSwingHotKey(0, 0, 113);
        JIntellitype.getInstance().registerSwingHotKey(1, 0, 114);
        JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
            @Override
            public void onHotKey(int markCode) {
                System.out.println(new Date().toString()+"==" + markCode);
                if (action) {
                    action = false;
                    System.out.println("按键关闭");
                } else {
                    action = true;
                    System.out.println("案件开启");
                }
                robotKey(action);
            }
        });
    }

    Robot robot;
    boolean action = false;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private void robotKey(boolean action) {
        do {
            robot.keyPress(97);
            robot.keyRelease(97);
            System.out.println(97);
            robot.delay(500);
        } while (action);
    }
}
