import sys

input = sys.stdin.readline

cons = "bcdfghjklmnpqrstvwxyz"
vowels = "aeiou"


def condition_one(string):
    for s in string:
        if s in vowels:
            return True
    return False


def condition_two(string):
    for i in range(len(string) - 2):
        if string[i] in cons and string[i + 1] in cons and string[i + 2] in cons:
            return False
        elif (
            string[i] in vowels and string[i + 1] in vowels and string[i + 2] in vowels
        ):
            return False
    return True


def condition_three(string):
    for i in range(len(string) - 1):
        if string[i] == string[i + 1] and string[i] != "e" and string[i] != "o":
            return False
    return True


while True:
    string = input().rstrip()

    if string == "end":
        break

    if condition_one(string) and condition_two(string) and condition_three(string):
        print(f"<{string}> is acceptable.")
    else:
        print(f"<{string}> is not acceptable.")
