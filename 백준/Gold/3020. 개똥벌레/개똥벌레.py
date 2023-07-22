import sys

input = sys.stdin.readline

INF = float("inf")


n, h = map(int, input().split())

bottom = [0] * (h + 1)
top = [0] * (h + 1)

for i in range(n):
    _h = int(input())
    if i % 2 == 0:
        bottom[_h] += 1
    else:
        top[_h] += 1


for i in range(h, 1, -1):
    bottom[i - 1] += bottom[i]
    top[i - 1] += top[i]

answer = INF
count = 0

for height in range(1, h + 1):
    cnt = bottom[height] + top[h - height + 1]

    if cnt < answer:
        answer = cnt
        count = 1
    elif answer == cnt:
        count += 1

print(answer, count)