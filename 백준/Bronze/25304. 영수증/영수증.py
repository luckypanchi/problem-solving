import sys

input = sys.stdin.readline


x = int(input())
n = int(input())
answer = 0
for _ in range(n):
    a, b = map(int, input().split())
    answer += a * b
if answer == x:
    print("Yes")
else:
    print("No")