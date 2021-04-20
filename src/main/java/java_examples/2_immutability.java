package java_examples;

import java.util.HashMap;
import java.util.Map;

class Immutability {

    public static void main(String[] args) {
        // In Java, to adjust an entry in a map we can simply adjust it in-place as it's mutable

        Map<String, String> original_map = new HashMap<>();
        original_map.put("one", "value");
        original_map.put("another", "entry");

        System.out.println(original_map);

        original_map.put("one", "some_other_value");

        System.out.println(original_map);

    }
}
