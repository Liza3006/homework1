package com.mipt.orlovaelizaveta;

public class MainClass {

    private int privateInt;
    private String privateString;
    protected static double protectedStaticDouble;
    public final long PubFinLong = 219-8;

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println("Iter: " + i);
        }
    }
}
