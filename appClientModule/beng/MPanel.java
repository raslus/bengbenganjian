package beng;

import com.melloware.jintellitype.JIntellitype;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.util.LinkedHashMap;
import java.util.Map;

public class MPanel {
    Map<String, Object> map = new LinkedHashMap();

    {
        map.put("action",false);
        map.put("robot", -1);
        try {
            robot = new Robot();

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        JFrame jf = new JFrame();
        jf.setTitle("蹦蹦辅助");
        jf.setSize(250, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout(3, 3));
        JButton btn = new JButton("按钮");
        jp1.add(btn);
        jf.setContentPane(jp1);
        jf.setVisible(true);
        for (KeyEnum a : KeyEnum.values()) {
            JIntellitype.getInstance().registerSwingHotKey(a.getUpVal(), 0, a.getUpVal());
            JIntellitype.getInstance().registerHotKey(-1, InputEvent.ALT_MASK, a.getUpVal());
        }

        JIntellitype.getInstance().addHotKeyListener(markCode -> {
            map.put("robot", markCode);
            System.out.println("robot==" + map.get("robot"));
            if (markCode==0) {
                action = false;
                System.out.println("关闭");
            } else {
                action = true;
                System.out.println("开启");
            }
//                }
        });
        robot();
    }

    Robot robot;
    boolean action = false;



    void robot(){
        while(true){
            int key = (int) map.get("robot");
            if(key!=-1){
                System.out.println("触发按键");
                robot.keyPress(key);
                robot.delay(500);
                robot.keyRelease(key);
                System.out.println(key);
            }

        }
    }
    public void robotReady() throws InterruptedException {
        do {
            System.out.println((int) map.get("robot"));
            if ((int) map.get("robot") != -1) {
                robotAct();
            }
            Thread.sleep(500);
        } while ((int) map.get("robot") == -1);
    }

    public void robotAct() throws InterruptedException {
        int markCode = -1;
        do {
            markCode = (int) map.get("robot");
            robot.keyPress(markCode);

            System.out.println("按下" + markCode);
            robot.delay(500);
            System.out.println("抬起" + markCode);
            if (markCode == -1) {
                robotReady();
            }
        } while (markCode != -1);
    }
}
