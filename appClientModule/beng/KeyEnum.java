package beng;

public enum KeyEnum {
    Q('q'), W('w'), E('e'), R('r'), T('t'), Y('y'), U('u'), I('i'), O('0'), P('p'), A('a'), S('s'), D('d'), F('f'), G('g'), H('h'), J('j'), K('k'), L('l'), Z('z'), X('x'), C('c'), V('v'), B('b'), N('n'), M('m');

    private char val;
    private char upVal;

    KeyEnum(char val) {
        this.val = val;
        this.upVal = (char) (val-32);
    }

    public char getVal (){
        return val;
    }

    public char getUpVal(){
        return upVal;
    }
}
