import sys

input = sys.stdin.readline


n = int(input())
costs = sorted([int(input()) for _ in range(n)], reverse=True)

answer = 0

for i, c in enumerate(costs):
    if i % 3 != 2:
        answer += c

print(answer)
