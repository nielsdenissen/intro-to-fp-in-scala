# --------------------------------- Part 1 - Composition of a greeting ---------------------------------
print("------------ Part 1 ------------\n")


def add_greeting(name):
    return f"Hello my name is {name}"


def to_upper_case(str_in):
    return str_in.upper()


# We can combine these functions directly by calling them one by one
print(to_upper_case(add_greeting("Tom")))


# Using function composition, we could also combine the two functions into a new one first
def compose(func1, func2):
    return lambda x: func1(func2(x))


# This way we can create a new function composed of the 2 previous
loud_greeting = compose(to_upper_case, add_greeting)
print(loud_greeting("Tom"))


# --------------------------------- Part 2 - Passing functions around ---------------------------------
print("\n------------ Part 2 ------------\n")


# First we create a generic divisible_by function
# Notice divisible_by is a function that returns another function
def divisible_by(y):
    return lambda x: x % y == 0


# We can now create a divisible_by_2 function using divisible_by
divisible_by_2 = divisible_by(2)
print(f"Result of {divisible_by_2(4)=}")
print(f"Result of {divisible_by_2(5)=}")
