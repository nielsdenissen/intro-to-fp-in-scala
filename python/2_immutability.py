# In Python, to adjust an entry in a map we can simply adjust it in-place as it's mutable

original_map = {
    "one": "value",
    "another": "entry"
}

print(original_map)

original_map["one"] = "some_other_value"

print(original_map)
