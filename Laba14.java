package com.company;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Laba14 {
    public static void main(String[] args) {
        BufferedReader read = null;
        BufferedWriter write = null;
        try {
            read = new BufferedReader(new FileReader("programCod.txt"));
            write = new BufferedWriter(new FileWriter("deleteComments.txt"));
            int i;
            StringBuffer cod = new StringBuffer();
            while ((i = read.read()) != -1) {
                cod.append((char) i);
            }
            Pattern pattern = Pattern.compile("(/\\*.*?\\*/)|(//[^\n]*)", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(cod.toString());
            StringBuffer deleteComments = new StringBuffer(matcher.replaceAll(""));
            write.write(deleteComments.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (read != null) {
                    read.close();
                }
                if (write != null) {
                    write.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}