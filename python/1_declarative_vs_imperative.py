list_of_strings = [
    "small",
    "alsosmall",
    "quiteabitbigger",
    "definitelytoolargetokeepattentionofreader"
]

filtered_list = list()
for item in list_of_strings:
    if len(item) < 10:
        filtered_list.append(item)

print(filtered_list)
