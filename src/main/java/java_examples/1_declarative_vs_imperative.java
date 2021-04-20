package java_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Declarative_vs_imperative {

    public static void main(String[] args) {
        List<String> list_of_strings = Arrays.asList(
                "small",
                "alsosmall",
                "quiteabitbigger",
                "definitelytoolargetokeepattentionofreader"
        );

        List<String> filtered_list = new ArrayList<>();
        for (String item : list_of_strings) {
            if (item.length() < 10) {
                filtered_list.add(item);
            }
        }

        System.out.println(filtered_list);
    }

}
