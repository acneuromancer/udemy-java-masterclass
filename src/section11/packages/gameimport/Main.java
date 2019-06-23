package section11.packages.gameimport;

import com.example.game.ISavable;
import com.example.game.Monster;
import com.example.game.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player tim = new Player("Tim", 10, 15);
        System.out.println(tim);
        saveObject(tim);

        tim.setHitPoints(8);
        tim.setWeapon("Stormbringer");
        System.out.println(tim + "\n");
        saveObject(tim);
        // loadObject(tim);
        System.out.println(tim + "\n");

        ISavable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println(werewolf + "\n");
        System.out.println("Strength = " + ((Monster) werewolf).getStrength());
        saveObject(werewolf);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while(!quit) {
            System.out.print("Choose an option: ");

            while(!scanner.hasNextInt()) {
                System.out.println("Wrong value. Please enter 0 or 1.");
                scanner.nextLine();
            }

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
                default:
                    break;
            }
        }

        return values;
    }

    public static void saveObject(ISavable objectToSave) {
        for (int i=0; i<objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device.");
        }
    }

    public static void loadObject(ISavable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }

}
