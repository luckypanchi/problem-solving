import sys

input = sys.stdin.readline


n = int(input())
calendar = [0] * 366

for _ in range(n):
    s, e = map(int, input().split())

    for i in range(s, e + 1):
        calendar[i] += 1

w, h = 0, 0
answer = 0

for i in range(366):
    if calendar[i] != 0:
        h = max(h, calendar[i])
        w += 1
    else:
        answer += w * h
        w, h = 0, 0

answer += w * h

print(answer)