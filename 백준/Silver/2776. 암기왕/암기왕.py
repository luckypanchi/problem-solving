import sys

input = sys.stdin.readline


tc = int(input())

for _ in range(tc):
    n = int(input())
    num1 = set(map(int, input().split()))
    m = int(input())
    num2 = list(map(int, input().split()))
    for num in num2:
        if num in num1:
            print(1)
        else:
            print(0)
