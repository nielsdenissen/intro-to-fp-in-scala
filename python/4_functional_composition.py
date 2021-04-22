def add_greeting(name):
    return f"Hello my name is {name}"


def to_upper_case(str_in):
    return str_in.upper()


# We can combine these functions directly by calling them one by one
print(to_upper_case(add_greeting("Tom")))


# Using function composition, we could also combine the two functions into a new one first
def compose(func1, func2):
    return lambda x: func1(func2(x))


loud_greeting = compose(to_upper_case, add_greeting)


print(loud_greeting("Tom"))
