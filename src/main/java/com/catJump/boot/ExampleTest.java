package com.catJump.boot;

import java.util.*;
import java.util.stream.Collectors;

public class ExampleTest {
    public static void main (String args[]){
//        texi();
//        aeiou();
//        drawLine();
//        easyRom();
//        int[] count = new int[128];
//        for(int a :count){
//            System.out.println(a);
//        }
//        serviceInterface();
        countStrings();
    }

    /**
         程序员小明打了一辆出租车去上班。出于职业敏感，他注意到这辆出租车的计费表有点问题，总是偏大。
         出租车司机解释说他不喜欢数字4，所以改装了计费表，任何数字位置遇到数字4就直接跳过，其余功能都正常。
         比如：  1. 23再多一块钱就变为25；
                2. 39再多一块钱变为50；
                3. 399再多一块钱变为500；
         小明识破了司机的伎俩，准备利用自己的学识打败司机的阴谋。   给出计费表的表面读数，返回实际产生的费用
         #理解题意 任何数字位置遇到4就跳过，即逢“4"加1,算差价
     */
    static void texi(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String numStr = String.valueOf(num);
        int difNum = 0;
        for (int i = 1;i <= num; i++){
            if( String.valueOf(i).indexOf('4') > -1){
                difNum += 1;
            }
        }
        System.out.println(num - difNum);
        scanner.close();
    }

    /**
     *   开头和结尾都是元音字母（aeiouAEIOU）的字符串为 元音字符串 ，
     *   其中混杂的非元音字母数量为其 瑕疵度 。
     *   比如:
     *      · “a” 、 “aa”是元音字符串，其瑕疵度都为0
     *      · “aiur”不是元音字符串（结尾不是元音字符）
     *      · “abira”是元音字符串，其瑕疵度为2
     *   给定一个字符串，请找出指定瑕疵度的最长元音字符子串，并输出其长度，
     *   如果找不到满足条件的元音字符子串，输出0。
     *   子串：字符串中任意个连续的字符组成的子序列称为该字符串的子串。
     *
     *   #双指针
     */
    static void aeiou(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = scanner.next();
        System.out.println("请输入要查找的瑕疵度");
        int find = scanner.nextInt();

        String strLowed = str.toLowerCase();//将字符串转为小写 方便寻找元音
        ArrayList<String> arrayList = new ArrayList<>();
        char[] chars = strLowed.toCharArray();
        int left = 0;
        int right = 0;
        int count = 0;
        for(right = 0;right < chars.length; right ++){
            boolean yuanFlag = "aeiou".indexOf(chars[right])>-1;//元音
            if(!yuanFlag) {
                count++;
                continue;
            }
            if(yuanFlag && count<find){//是元音，但是瑕疵不够，继续循环
                continue;
            }
            //如果瑕疵度刚好，左边是元音，保存到列表中
            if("aeiou".indexOf(chars[left])>-1 && count == find){
                String temp = str.substring(left,right+1);
                arrayList.add(temp);
            }
            //如果瑕疵度足够，左边是非元音，移动左侧指针
            while ("aeiou".indexOf(chars[left])<0 || count > find){
                left++;
                if("aeiou".indexOf(chars[left])<0){
                    count--;
                }
                if(left>right){
                    left = right;
                    break;
                }
            }
            if("aeiou".indexOf(chars[left])>-1 && count == find){
                String temp = str.substring(left,right+1);
                arrayList.add(temp);
            }
        }
        if(arrayList.size()>0){
            //用stream()方法处理
            arrayList = (ArrayList<String>) arrayList.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
            System.err.println(arrayList.get(0));
            System.err.println(arrayList.get(0).length());
            //也可以遍历arrList单独取出
            String a = "";
            for(String b : arrayList){
                if(b.length() > a.length()){
                    a = b;
                }
            }
            System.out.println(a);
        }else if(arrayList.size() ==1 ) {
            System.err.println(arrayList.get(0));
            System.err.println(arrayList.get(0).length());
        }else {
            System.err.println(0);
        }

    }

    /**
     *   给定两个整数数组array1、array2，数组元素按升序排列。
     *   假设从array1、array2中分别取出一个元素可构成一对元素，现在需要取出k对元素，并对取出的所有元素求和，计算和的最小值
     *   注意：两对元素如果对应于array1、array2中的两个下标均相同，则视为同一对元素。
     *
     *
     */
    static void arrayCombine(){
            Scanner sc=new Scanner(System.in);
            String str1=sc.nextLine();
            String str2=sc.nextLine();
            int k=sc.nextInt();
            int m=0;
            int[] str11=getarray(str1);
            int[] str22=getarray(str2);
            //创建一个集合，将元素对的和存入集合
            ArrayList<Integer> arraylist=new ArrayList<>(str11.length*str22.length);
            for (int i:str11) {
                for(int j:str22){
                    arraylist.add(i+j);
                }
            }

            //对集合进行排序，需要用到Collections
            Collections.sort(arraylist);
            for(int i=0;i<k;i++){
                m+=arraylist.get(i);
            }
            System.out.println(m);
    }

    static int[] getarray(String str){
            String[] str11=str.split(" ");
            int[] str111=new int[str11.length-1];
            for(int i=1;i<str11.length;i++){
                str111[i-1]=Integer.parseInt(str11[i]);
            }
            return str111;
        }


    /**
     * 
     *   绘图机器的绘图笔初始位置在原点（0, 0），机器启动后其绘图笔按下面规则绘制直线：
     *   1）尝试沿着横向坐标轴正向绘制直线，直到给定的终点值E。
     *   2）期间可通过指令在纵坐标轴方向进行偏移，并同时绘制直线，偏移后按规则1 绘制直线；指令的格式为X offsetY，表示在横坐标X 沿纵坐标方向偏移，offsetY为正数表示正向偏移，为负数表示负向偏移。
     *   给定了横坐标终点值E、以及若干条绘制指令，请计算绘制的直线和横坐标轴、以及 X=E 的直线组成图形的面积。
     *
     *   #出现了审题错误。（认为是在某座标开始走斜线，复杂化了需求）实际是到达指令坐标后Ｙ坐标直接移动
     *
     */
    static void  drawLine(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder strs = new StringBuilder();
        int finalLineX = 0;
        while (true){
           try {
               System.out.println("输入指令集：【X offsetY】格式");
               String a =  scanner.next(".*offset.*");
               strs.append(a);
           }catch (Exception e){
               finalLineX = scanner.nextInt();
               break;
           }
           strs.append(",");
           System.out.println("请继续输入指令，或者输入终点坐标");
        }
        float area =  0;
        float start = 0;
        float end = 0;
        String[] draw = strs.toString().split(",");
        float endY = 0;
        for(int i = 0;i < draw.length; i++){
            float x = Integer.parseInt(draw[i].split("offset")[0]);//X为坐标偏移起始点
            float y = Integer.parseInt(draw[i].split("offset")[1]);//Y为坐标偏移Y轴终点
            end += x;
            if(end >= finalLineX){
                //如果给出的坐标偏移时越过终点
                area += (float) ((finalLineX - start) * (endY + y) / 2 );
            }else{
                area += (float) (x * (endY + y)) /2 ;
                start = end;
                endY = y;
            }
        }
        if(end < finalLineX){
            area += (finalLineX - end) * endY;
        }

        System.out.println("最终面积为:"+area);
        scanner.close();
    }

    /**
     * 请实现一个简易内存池,根据请求命令完成内存分配和释放。
     * 内存池支持两种操作命令，REQUEST和RELEASE，其格式为：
     * REQUEST=请求的内存大小 表示请求分配指定大小内存，如果分配成功，返回分配到的内存首地址；如果内存不足，或指定的大小为0，则输出error。
     * RELEASE=释放的内存首地址 表示释放掉之前分配的内存，释放成功无需输出，如果释放不存在的首地址则输出error。
     * 注意：
     * 1.内存池总大小为100字节。
     * 2.内存池地址分配必须是连续内存，并优先从低地址分配。
     * 3.内存释放后可被再次分配，已释放的内存在空闲时不能被二次释放。
     * 4.不会释放已申请的内存块的中间地址。
     * 5.释放操作只是针对首地址所对应的单个内存块进行操作，不会影响其它内存块。
     *
     * #Map 存放 key为头 value为尾
     */
    static void easyRom(){
        final int Max = 100;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入指令数后输入指令");
        int count = scanner.nextInt();
        String[][] lineArr = new String[count][2];
        for (int i = 0; i < count; i++) {
            lineArr[i] = scanner.next().split("=");
        }

        Map<Integer,Integer> map = new TreeMap<>();
        int beforeHead = 0;
        for(int i = 0; i<count; i++){
            int value = Integer.parseInt(lineArr[i][1]);
            if(lineArr[i][0].startsWith("REQUEST")){
                if(value > Max || value < 0){
                    System.err.println("error");
                    continue;
                }
                if(map.isEmpty()){
                    map.put(0,value);
                }else{
                    List<Integer> headList = new ArrayList<>(map.keySet());
                    for(Integer head : headList){
                        if(head - beforeHead >=value){
                            map.put(beforeHead,beforeHead + value);
                        }else{
                            beforeHead = map.get(head);
                        }
                    }
                    if(Max - beforeHead >= value){
                        map.put(beforeHead,beforeHead+value);
                    }else{
                        System.err.println("error");
                    }
                }

            }else if(lineArr[i][0].startsWith("RELEASE")){
                map.remove(value);
            }else{
                System.err.println("error");
            }
        }
        scanner.close();

    }

    /**
     * 给定一个表达式，求其分数计算结果    
     * 表达式的限制如下：        
     * 1. 所有的输入数字皆为正整数(包括0)    
     * 2. 仅支持四则运算[ + - * / ]和括号
     * 3. 结果为整数或分数, 分数必须化为最简格式(比如6, 3/4, 7/8, 90/7)
     * 4. 除数可能为0，如果遇到这种情况，直接输出ERROR
     * 5.输入和最终计算结果中的数字都不会超出整型范围
     * 用例的输入一定合法,不会出现括号不匹配的情况
     *
     * # 中缀表达式 -> 逆波兰表达式  （栈的应用）
     *  1 将表达式字符串中的符号转转存到 list 集合 ls 中，方便遍历
     *  2 将中缀表达式转换为后缀表达式 【Stack】   遍历list，数字优先放入A栈，运算符号及左括号有限放入B栈，遍历到右括号时，将B栈的存放弹出直到遇到左括号。
     *  3 计算后缀表达式的值
     */
    static void mathExpress(){
        
    }


    /**
     * 服务之间交换的接口成功率作为服务调用关键质量特性，
     * 某个时间段内的接口失败率使用一个数组表示，数组中每个元素都是单位时间内失败率数值，数组中的数值为0~100的整数，
     * 给定一个数值(minAverageLost)表示某个时间段内平均失败率容忍值，即平均失败率小于等于minAverageLost，找出数组中最长时间段，如果未找到则直接返回NULL。
     *
     * #双指针搜索？√ 遍历数组，左固定 移动右标。有符合条件的压入栈
     */
    static void serviceInterface(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("请输入接口成功率数组，用空格隔开");
            String okList = scanner.nextLine();
            System.out.println("请输入接口失败率容忍值");
            int minAverageLost = scanner.nextInt();
            List<String> numArr = Arrays.asList(okList.split(" "));
            Stack<Map<String,Object>> tempStack = new Stack<>();
            //思路：for遍历list
            int t = -1;
            for(int i = 0; i < numArr.size(); i++){
                int a = Integer.parseInt(numArr.get(i));
                for(int j = i +1; j < numArr.size(); j++ ){
                    a += Integer.parseInt(numArr.get(j));
                    if( a/(j - i +1) <= minAverageLost){
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(i).append("-").append(j);
                        Map<String,Object> map = new HashMap<>();
                        map.put("str",stringBuilder.toString());
                        map.put("len",j-i);
                        if(tempStack.isEmpty()){
                            tempStack.push(map);
                        } else {
                            if (Integer.parseInt(String.valueOf(tempStack.peek().get("len"))) < j-i){
                                while(!tempStack.isEmpty()){
                                    if (Integer.parseInt(String.valueOf(tempStack.peek().get("len"))) < j-i){
                                        tempStack.pop();
                                    }
                                }
                                tempStack.push(map);
                            }else if(Integer.parseInt(String.valueOf(tempStack.peek().get("len"))) == j-i) {
                                tempStack.push(map);
                            }
                        }
                    }
//                    System.out.println(tempStack);
                }
            }

            while (!tempStack.isEmpty()){
                System.out.println(tempStack.pop());
            }

        }catch (Exception e){

        }finally {
            scanner.close();
        }
    }

    /**
     * 给定M(0<M<=30)个字符（a-z），
     * 从中取出任意字符（每个字符只能用一次）拼接成长度为N(0<N<=5)的字符串，要求相同的字符不能相邻，
     * 计算出给定的字符列表能拼接出多少种满足条件的字符串，输入非法或者无法拼接出满足条件的字符串则返回0。
     *
     * #for中删除元素 可以使用Iterator迭代器
     * #需不需要考虑字符串的顺序，即给出abc时，（ab）-(ba)分别计数，需要！
     * #递归中用for遍历数组，拼接字符串后，储存到hashSet中去重
     */
    static void countStrings(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入0-30个a-z的字符");
            String input = scanner.nextLine();
            System.out.println("请输入要拼接的长度");
            int LEN = scanner.nextInt();

            String[] chars = input.split("");
            List<String> charList = new ArrayList<>(Arrays.asList(chars));

            List<String> generateList = new ArrayList<>();
            int count = 0;

            deep(charList,LEN,count,"");
            System.out.println(count);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    static void deep(List<String> list,int LEN,Integer count,String str){
        //删除一个元素传递到下一次递归的时候，不应收到之前遍历时的影响
        Iterator iterator = list.iterator();
        if(LEN == 0){
            //字符串长度足够，增加技术值
            count ++;
            System.out.println(count);
            return;
        }
       //搜索不够足够的长度，继续迭代
       if(LEN > 0){
           LEN--;
           while (iterator.hasNext()){
               Object obh  = iterator.next();
               String temp = String.valueOf(obh);
               if(temp.equals(str)){//当前循环的元素等于上次迭代选择的元素跳过
                   continue;
               };
               deep(list,LEN,count,temp);
           }
       }
    }
    
}
