package java_examples;


import java.util.function.Function;

class FunctionComposition {

    public static void main(String[] args) {
        Function<String, String> addGreeting = name -> "Hello, my name is " + name;
        Function<String, String> toUpperCase = text -> text.toUpperCase();

        // Java supports compose and andThen to combine functions, the only difference is the order of applying
        Function<String, String> loudGreeting = addGreeting.andThen(toUpperCase);
        System.out.println(loudGreeting.apply("Tom"));
    }
}
