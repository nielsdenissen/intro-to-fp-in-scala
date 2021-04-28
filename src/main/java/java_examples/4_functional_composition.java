package java_examples;


import java.util.function.Function;

class FunctionComposition {

    public static void main(String[] args) {
        // --------------------------------- Part 1 - Composition of a greeting ---------------------------------
        System.out.println("------------ Part 1 ------------\n");

        Function<String, String> addGreeting = name -> "Hello, my name is " + name;
        Function<String, String> toUpperCase = text -> text.toUpperCase();

        // Java supports compose and andThen to combine functions, the only difference is the order of applying
        Function<String, String> loudGreeting = addGreeting.andThen(toUpperCase);
        System.out.println(loudGreeting.apply("Tom"));


        // --------------------------------- Part 2 - Passing functions around ---------------------------------
        System.out.println("\n------------ Part 2 ------------\n");

        // First we create a generic divisible_by function
        Function<Integer, Function<Integer, Boolean>> divisibleBy = (y) -> (x) -> Math.floorMod(x, y) == 0;

        // We can now create a divisible_by_2 function using divisible_by
        // Notice divisible_by_2 is another function that returns a function
        Function<Integer, Boolean> divisibleBy2 = divisibleBy.apply(2);
        System.out.println("Result of divisibleBy2.apply(4)=" + divisibleBy2.apply(4));
        System.out.println("Result of divisibleBy2.apply(5)=" + divisibleBy2.apply(5));
    }
}
