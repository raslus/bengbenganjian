package beng;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Date;

import com.melloware.jintellitype.JIntellitype;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class MPanel2 {
    public void run() {
        JFrame jf = new JFrame();
        jf.setTitle("蹦蹦辅助");
        jf.setSize(250, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout(3, 3));
        JButton btn = new JButton("木大");
        jp1.add(btn);
        jf.setContentPane(jp1);
        jf.setVisible(true);
        RobotThread thread = new RobotThread();
        Thread t1 = new Thread(thread);

        JIntellitype.getInstance().registerSwingHotKey(0, 0, 113);
        JIntellitype.getInstance().registerSwingHotKey(1, InputEvent.ALT_MASK, 113);
        JIntellitype.getInstance().addHotKeyListener(markCode -> {
            System.out.println(new Date().toString() + "==" + markCode);
            if (markCode == 0) {
                action = true;
                System.out.println("关闭");
                t1.start();
            } else if (markCode == 1) {
                action = false;
                System.out.println("开启");
                t1.interrupt();
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
    //新建进程来执行,执行几次以后暂停
    //创建两个进程来进行按键操作,一个进程执行robot另一个进程监听按键

    private void robotKey() {
        do {
            robot.keyPress(97);
            robot.keyRelease(97);
            System.out.println(97);
            robot.delay(500);
        } while (action);
    }

    class RobotThread implements Runnable {
        @Override
        public void run() {
            do {
                robot.keyPress(97);
                robot.keyRelease(97);
                System.out.println(97);
                robot.delay(500);
            } while (action);
        }
    }
}
