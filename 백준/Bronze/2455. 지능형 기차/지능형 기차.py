import sys

input = sys.stdin.readline


answer = -1
curr = 0

for _ in range(4):
    a, b = map(int, input().split())
    curr = curr - a + b
    answer = max(answer, curr)

print(answer)