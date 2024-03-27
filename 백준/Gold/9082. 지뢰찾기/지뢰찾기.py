import sys

input = sys.stdin.readline


tc = int(input())
for _ in range(tc):
    n = int(input())
    numbers = list(map(int, input().strip()))
    mine = list(input().strip())

    result = 0
    for i in range(n):
        if i == 0 and numbers[0] != 0 and numbers[1] != 0:
            numbers[0] -= 1
            numbers[1] -= 1
            result += 1
        elif i == n - 1 and numbers[i] != 0 and numbers[i - 1] != 0:
            numbers[i - 1] -= 1
            numbers[i - 2] -= 1
            result += 1
        elif 1 <= i < n - 1 and numbers[i - 1] != 0 and numbers[i] != 0 and numbers[i + 1] != 0:
            numbers[i - 1] -= 1
            numbers[i] -= 1
            numbers[i + 1] -= 1
            result += 1

    print(result)
