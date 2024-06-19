import sys

input = sys.stdin.readline


def convert(s):
    if s in ("0", "1", "2", "5", "8"):
        return s
    elif s == "6":
        return "9"
    elif s == "9":
        return "6"


n = list(input().strip())
number = int("".join(n))

if number == 1:
    print("no")
    sys.exit()

for i in range(2, int(number**0.5) + 1):
    if number % i == 0:
        print("no")
        sys.exit()

flipped = []
while n:
    s = n.pop()
    if s in ("3", "4", "7"):
        print("no")
        sys.exit()

    flipped.append(convert(s))

newNumber = int("".join(flipped))

for i in range(2, int(newNumber**0.5) + 1):
    if newNumber % i == 0:
        print("no")
        sys.exit()

print("yes")