package com.winwin.picreport.Futils;
/*得到整数的长度*/
public class SizeOf {
    final static int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };
   public static int sizeOfInt(int x) {
        for (int i = 0;; i++)
            if (x <= sizeTable[i])
                return i + 1;
    }
//    public static void main(String[] args) {
//        System.out.println(sizeOfInt(1234));
//        System.out.println(sizeOfInt(123));
//        System.out.println(sizeOfInt(12345));
//        System.out.println(sizeOfInt(12));
//    }
}
