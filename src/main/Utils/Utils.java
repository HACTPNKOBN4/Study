package main.Utils;

import main.Main;

import javax.swing.*;


public class Utils {

    public static Icon loadImage(String path){
            return new ImageIcon(Main.class.getResource(path));
    }

    public static void main(String[] args) {
        String s = "(3) (4,23)";
        System.out.println(s.matches("(\\W*((\\(\\d+,\\d+\\))|(\\(\\d+\\)))\\W*)+"));

        String s1 = "(3)";
        System.out.println(s1.matches("(\\(\\d+\\))"));
    }
}
