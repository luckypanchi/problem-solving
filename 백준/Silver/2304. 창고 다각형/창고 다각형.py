import sys

input = sys.stdin.readline


n = int(input())
front = [0] * 1002
back = [0] * 1002

for _ in range(n):
    x, h = map(int, input().split())
    front[x] = h
    back[x] = h

for i in range(1, 1001):
    front[i] = max(front[i], front[i - 1])
    j = 1001 - i
    back[j] = max(back[j], back[j + 1])

answer = 0
for x in range(1, 1001):
    answer += min(front[x], back[x])

print(answer)