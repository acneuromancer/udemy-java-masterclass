package section_12_collections._04_map;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();

//        languages.put("Java", "a compiled high level, object-oriented, platform independent language");
//        System.out.println(languages.get("Java"));
//        languages.put("Java", "this course is about it");
//        System.out.println(languages.get("Java"));


        if (languages.containsKey("Java")) {
            System.out.println("Java already exists.");
        } else {
            languages.put("Java", "a compiled high level, object-oriented, platform independent language");
            System.out.println("Java added successfully");
        }

        System.out.println(languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics"));
        System.out.println(languages.put("Algol", "an algorithmic language"));
        System.out.println(languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));

        System.out.println("=====================");

        if (languages.remove("Lisp")!= null) {
            System.out.println("Lisp key and its value removed from the _04_map");
        } else {
            System.out.println("Lisp key and its value not removed from the _04_map");
        }

        if (languages.remove("Lisp") != null) {
            System.out.println("Lisp key and its value removed from the _04_map");
        } else {
            System.out.println("Lisp key and its value not removed from the _04_map");
        }

        if (languages.remove("Algol", "a family of algorithmic languages")) {
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed, key value pair not found");
        }

        System.out.println("=====================");
        for (String key : languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }
    }

}
