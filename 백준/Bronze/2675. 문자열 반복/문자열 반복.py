import sys

input = sys.stdin.readline


tc = int(input())

answer = []

for _ in range(tc):
    n, s = input().split()
    n = int(n)

    result = ""

    for c in s:
        result += n * c

    answer.append(result)

for a in answer:
    print(a)
