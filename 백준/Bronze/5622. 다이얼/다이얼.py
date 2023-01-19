import sys

input = sys.stdin.readline


numbers = dict()

for a in "ABC":
    numbers[a] = 3

for a in "DEF":
    numbers[a] = 4

for a in "GHI":
    numbers[a] = 5

for a in "JKL":
    numbers[a] = 6

for a in "MNO":
    numbers[a] = 7

for a in "PQRS":
    numbers[a] = 8

for a in "TUV":
    numbers[a] = 9

for a in "WXYZ":
    numbers[a] = 10

answer = 0

string = input().strip()

for s in string:
    answer += numbers[s]

print(answer)
