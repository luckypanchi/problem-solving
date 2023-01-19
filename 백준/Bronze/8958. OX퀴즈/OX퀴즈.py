import sys

input = sys.stdin.readline

tc = int(input())

answer = []

for _ in range(tc):
    string = input()

    result = 0
    p = 0
    for s in string:
        if s == "X":
            p = 0
        elif s == "O":
            p += 1
            result += p

    answer.append(result)

for a in answer:
    print(a)
