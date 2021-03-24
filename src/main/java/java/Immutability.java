package java;

import java.util.HashMap;
import java.util.Map;

public class Immutability {

    public static void main(String[] args) {

        // 1: A regular map in Java is mutable (like most types in java)
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(0, "zero");
        map.put(1, "one");

        System.out.println("map: " + map);


        // 2: We can also make a variable immutable by adding "final"
        final Map<Integer, String> finalMap = new HashMap<Integer, String>();
        // This would generate a compile error
        finalMap.put(1, "one");

        System.out.println("immutableVar: " + finalMap);


        // 3: Methods on types
        String aString = "bla";
        aString.toUpperCase();

        System.out.println("aString: " + aString);
    }
}
