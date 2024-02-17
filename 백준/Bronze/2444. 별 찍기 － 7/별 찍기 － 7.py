import sys

input = sys.stdin.readline


n = int(input())
answer = [""] * (2 * n - 1)

for i in range(n - 1):
    s = " " * (n - i - 1) + "*" * (2 * i + 1)
    answer[i] = s
    answer[2 * n - 1 - i - 1] = s

answer[n - 1] = "*" * (2 * n - 1)

for ans in answer:
    print(ans)