import sys

input = sys.stdin.readline


tc = int(input())

for _ in range(tc):
    n = int(input())
    numbers = [input().strip() for _ in range(n)]
    numbers.sort()

    flag = True
    for i in range(n - 1):
        if numbers[i] == numbers[i + 1][: len(numbers[i])]:
            print("NO")
            flag = False
            break

    if flag:
        print("YES")
