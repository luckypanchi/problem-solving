import sys

input = sys.stdin.readline


def change(curr, idx):
    for i in range(idx - 1, idx + 2):
        if 0 <= i < n:
            curr[i] = 1 - curr[i]


def go(curr):
    cnt = 0
    for i in range(1, n):
        if curr[i - 1] != target[i - 1]:
            change(curr, i)
            cnt += 1

    if curr == target:
        return [True, cnt]
    else:
        return [False, -1]


n = int(input())
current = list(map(int, input().strip()))
target = list(map(int, input().strip()))

curr = current[:]

answer1 = go(curr)

change(current, 0)

answer2 = go(current)
answer2[1] += 1

if answer1[0] and answer2[0]:
    print(min(answer1[1], answer2[1]))
elif answer1[0]:
    print(answer1[1])
elif answer2[0]:
    print(answer2[1])
else:
    print("-1")
