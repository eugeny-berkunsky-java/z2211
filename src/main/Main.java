package main;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(new Locale("uk", "UA"));
	    new Main().run4();
    }

    private void run() {
        Console console = System.console();
        if (console==null) {
            System.out.println("NULL");
        } else {
            String s = console.readLine();
            console.printf("read from console: %s\n",s);
            char[] chars = console.readPassword();
            System.out.println("password = " + new String(chars));
        }
    }

    private void run4() {
        int a = 17;
        double d = 12.34;
        Date date = new Date();
        String name1 = "Vasya";
        String name2 = "Alex";
        System.out.println("a = " + a);
        System.out.println("d = " + d);
        System.out.println("date = " + date);
        System.out.printf("a = %-5d\n",a);
        System.out.printf("%-10s %2d\n", name1, a);
        System.out.printf("%-10s %2d\n", name2, a);
        System.out.printf("%1$te %1$tB\n", date);
    }

    private void run3() throws IOException {
        Scanner s = null;
        double sum = 0;
        try {
            s = new Scanner(new BufferedReader(new FileReader("file.txt")));
            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } else {
                    s.next();
                }
            }

        } finally {
            if (s != null) {
                s.close();
            }
            System.out.println("sum = " + sum);
        }
    }

    private void run1() {
        System.out.println(myF());
    }

    private int myF() {
        try {
            return 5;
        } finally {
            return 0;
        }
    }

    private void run2() {
        String[] a = new String[]{"3","1","7","O","0","6","9"};
        try {
            Scanner in = new Scanner(System.in);
            int index = in.nextInt();
            System.out.println(a[index]);
            int v = Integer.parseInt(a[index]);
            System.out.println("v = " + v);
        } catch (IndexOutOfBoundsException | NumberFormatException ex) {
            System.err.println(ex.getMessage());
        } finally {
            System.out.println("Block Finally");
        }
    }
}
