import sys

input = sys.stdin.readline


n = int(input())
string = input().strip()

length = []

blue = 0
red = 0
prev = ""

for s in string:
    if prev != s:
        prev = s
        if s == "B":
            blue += 1
        elif s == "R":
            red += 1

print(1 + min(blue, red))
