package section_11_naming_packages_static_final.scopevisibility.challenge;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter a number: ");

        X x = new X(new Scanner(System.in));
        x.x();
    }

}
