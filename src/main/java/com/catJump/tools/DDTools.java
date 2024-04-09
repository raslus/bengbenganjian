package com.catJump.tools;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class DDTools {
    public interface DD extends Library {
        DD INSTANCE = (DD) Native.loadLibrary(".\\dd40605x64.dll", DD.class);

        public int DD_mov(int x, int y);//mouse move abs.
        public int DD_movR(int dx, int dy);//mouse move rel.
        public int DD_btn(int btn);//1==L.down, 2==L.up, 4==R.down, 8==R.up, 16==M.down, 32==M.up
        public int DD_whl(int whl);//Mouse Wheel. 1==down, 2==up
        public int DD_key(int ddcode, int flag);//keyboard,
        public int DD_str(String s);////Input visible char
    }
}
