list_of_strings = ["1", "9", "11", "100"]

# Parse strings to integers
list_of_integers = [int(item) for item in list_of_strings]

# This one should be fine, we're providing a list of integers
for item in list_of_integers:
    if item < 10:
        print(item)

# This one will break, we're providing a list of strings, but we only notice at runtime
for item in list_of_strings:
    if item < 10:
        print(item)
