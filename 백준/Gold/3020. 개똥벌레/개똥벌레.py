import sys

input = sys.stdin.readline

INF = float("inf")


n, h = map(int, input().split())
top = [0] * (h + 2)
bottom = [0] * (h + 2)
for i in range(n):
    _h = int(input())
    if i % 2 == 0:
        bottom[_h] += 1
    else:
        top[h + 1 - _h] += 1

for i in range(1, h + 1):
    j = h - i + 1
    top[i] += top[i - 1]
    bottom[j] += bottom[j + 1]


answer = INF
count = 0

for height in range(1, h + 1):
    currBreakCount = top[height] + bottom[height]
    if currBreakCount < answer:
        answer = currBreakCount
        count = 1
    elif currBreakCount == answer:
        count += 1

print(answer, count)