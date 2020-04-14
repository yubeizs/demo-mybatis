package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = new String("a")+ new String("bc");
        String s4 = new String("abc"); s4.intern();
        String s5 = new String("abc").intern();
        System.out.print("s1==s5的结果");
        System.out.println(s1==s5);
        System.out.print("s1==s2的结果");
        System.out.println(s1==s2);
        System.out.print("s1==s3的结果");
        System.out.println(s1==s3);
        System.out.print("s1==s4的结果");
        System.out.println(s1==s4);
        System.out.print("s3==s4的结果");
        System.out.println(s3==s4);
    }
}
