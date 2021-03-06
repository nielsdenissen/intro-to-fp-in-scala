# Practical introduction to Functional Programming

![](./docs/imgs/scala-logo.jpg)

In this repo I aim to showcase the different concepts used in Functional Programming compared to Imperative Programming. 
To do so we'll showcase the differences in code examples and briefly discuss the
implications.

Each chapter has a **Code Example** that works out an exercise in 3 languages (Python, Java and Scala). The results of 
these exercises can be found here:
- Python: `./python/`
- Java: `./src/main/java/java_examples/`
- Scala: `./src/main/scala/scala_examples/`

Furthermore some exercises for FP in Scala are included using Polynote. You can start/stop the polynote server using:

    ./start-polynote.sh
    ./stop-polynote.sh

Let's start with the most obvious one and work our way towards more specific examples.


## 1. Declarative vs Imperative Programming

**Code Example**: Filter items longer then 10 characters from a list

Imperative ([Java](./src/main/java/java_examples/1_declarative_vs_imperative.java), 
[Python](./python/1_declarative_vs_imperative.py)):
- Specify list of instructions to be executed
- Easy to reason about as it can be followed step-by-step (especially for beginners)
- Close to actual execution model (von Neuman)

Declarative ([Scala](./src/main/scala/scala_examples/1_declarative_vs_imperative.scala)):
- Specify intention, declare what we want to do
- More readable code


## 2. Immutability

**Code Example**: Adding items to a map/dict

Mutable ([Java](./src/main/java/java_examples/2_immutability.java),[Python](./python/2_immutability.py)):
- Objects can be altered after creation
- Shared Mutable State Problem (state is shared and might be altered by other pieces of code)

Immutable ([Scala](./src/main/scala/scala_examples/2_immutability.scala)):
- Objects cannot be altered after creation
- Supports parallel execution naturally
- Improves readability of pipeline as it's always clear which values are set

### Memory management
Immutability doesn't necessarily mean more memory is used. When for instance adding items to a map, one could think
it takes up more memory since we'd have to create an entirely new map with the extra item added in an immutable object.
However this is mitigated by the fact that immutable objects can be referenced to safely from multiple objects (as they
are immutable and guaranteed not to change). So adding an element to a map could look like this:

![](docs/imgs/immutability_map_memory_1.png)  

After adding a new element:

![](docs/imgs/immutability_map_memory_2.png)


## 3. Type system
Types are very useful when you're writing a functional program (or any program for that matter). In functional 
programming you'll often be chaining functions together to compose higher level functions. Types make it lot easier to 
do so as they make it easy to understand the result of previous functions. Also, the compiler can help you in 
determining whether the operations you've written are valid.

**Code Example**: Create a list of strings, parse to integers and filter < 10

Untyped ([Python](./python/3_type_system.py)):
- Flexible
- Potential type errors at run-time (more need for testing)
- Slower when reading data as the type needs to be inferred

Typed ([Java](./src/main/java/java_examples/3_type_system.java),
[Scala](src/main/scala/scala_examples/3_0_type_system.scala)):
- Compile-time validation (less error-prone)
- Readability and understandability of code (types provide insight in what a function does)
- More efficient in memory as storage needs are tailored to a type

### 3.1 Type Inference
Type inference reduces the amount of boilerplate that can come along with typed languages. In Java for instance, each
object/variable created needs to have the type explicitly mentioned on definition. In many statically typed functional
languages, the compiler is able to infer the type of a variable based on how they are created. You can see an example 
of this in the code examples of this chapter (look at the creation of "listOfStrings" and "listofIntegers" in Java vs 
Scala).

### 3.2 Pattern Matching
Using pattern matching, the compiler tries to fit a variable to a specific expression. It looks a little like a 
switch-case statement, but it's more powerful than that.

**Code Example**([Scala](./src/main/scala/scala_examples/3_2_pattern_matching.scala)): Calculate the Area of a shape


## 4. Functional Composition and First-class Functions
Every program essentially consists of 2 things: Behavior and Data. In Functional programming, functions make up the 
behavior of the program. They describe the transformations that need to be done on immutable data in order to achieve 
the programmers goals.

With Functions being the main building blocks of functional programs, an important concept is functional composition. 
This is a way to combine functions together to create another function and thus more complex behavior. For this to be 
possible, functions need to be so-called first-class citizens. This means you can pass functions around the same way 
you can pass data/objects/variables around in your code.

**Code Examples** ([Python](./python/4_functional_composition.py), 
[Java](./src/main/java/java_examples/4_functional_composition.java),
[Scala](./src/main/scala/scala_examples/4_functional_composition.scala)): 
1.  Compose a greeting from 2 functions.
  ![Functional Composition](docs/imgs/functional_composition.png)
  In this example we'll compose a greeting function. In our example we only show the first 2 functions composed. As an
  exercise you can create an ASCII greeting by adding the last function.
  
2. Create divisibleBy functions by returning a function from a function


## 5. Functional Programming Concepts - Map, Option, Either
In this chapter we'll look at some examples of tools available to you in a functional programming language.

- **Map**: Apply a function on each element of a functor (e.g. a list)
- **Option**: Type that's empty or contains a value. This is used as an alternative to null/None types which require 
checking throughout the codebase.
- **Either**: Type that can contain two types of data.
- **Try**: Similar to an Either. Used to return either a result or an exception.

**Code example**: [Scala](./src/main/scala/scala_examples/5_functional_programming_concepts.scala)


## 6. Lazy evaluation

**Code example**: [Scala](./src/main/scala/scala_examples/6_lazy_evaluation.sc)

TODO:
- call by value vs call by name (https://stackoverflow.com/questions/13337338/call-by-name-vs-call-by-value-in-scala-clarification-needed/13337382#13337382)
- https://alvinalexander.com/scala/fp-book/how-to-use-by-name-parameters-scala-functions/


## 7. Parallel Execution
The combination of immutability of data and functions as first class citizens makes it relatively easy to distribute 
workloads across multiple workers. By distributing partitioned data along with the functions to execute on it to various 
machines, it's relatively simple to parallelize execution. As opposed to having a central mutable object that needs to 
be accessed from various places which requires concepts like locks.
Many big data frameworks like Spark and Flink rely on this concept.

### Spark, Scala and Python
UDF, immutability, interop between python/pandas and scala/spark


## 8. Pure Functions
TODO:
- No side-effects
- Separate business logic
- Improves testability


## 9. Theory
TODO:
- Functors
- Monads
- Category theory


## Resources used

- http://luizsol.com/why-functional-programming/
- https://www.freecodecamp.org/news/imperative-vs-declarative-programming-difference/
- https://www.freecodecamp.org/news/learn-the-fundamentals-of-functional-programming/
- Difference val and def: https://alvinalexander.com/scala/fp-book-diffs-val-def-scala-functions/  
- Why OOP is bad (or why encapsulation doesn't work): https://www.youtube.com/watch?v=QM1iUe6IofM&ab_channel=BrianWill
- Polynote: https://github.com/Vilos92/polynote
- Exercises: https://www.hackerrank.com/domains/fp
