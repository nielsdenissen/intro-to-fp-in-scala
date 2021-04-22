package java_examples;

import java.util.*;

class TypeSystem {

    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("1", "9", "11", "100");

        // Parse strings to integers
        ArrayList<Integer> listOfIntegers = new ArrayList<>();
        for (String item : listOfStrings) {
            listOfIntegers.add(Integer.valueOf(item));
        }

        // Filtering the list of integers works fine
        for (Integer item: listOfIntegers) {
            if (item < 10) {
                System.out.println(item);
            }
        }

        // Filtering the list of strings does not compile
        // TODO: uncomment; below code raises a compilation error
//        for (String item: listOfStrings) {
//            if (item < 10) {
//                System.out.println(item);
//            }
//        }
    }
}
