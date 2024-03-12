import sys

input = sys.stdin.readline


def solve(prev, curr):
    global answer

    if curr == n:
        answer = max(answer, prev)
        return

    if eggs[curr][0] <= 0:
        solve(prev, curr + 1)
        return

    isAllBroken = True
    for target in range(n):
        if curr == target or eggs[target][0] <= 0:
            continue

        isAllBroken = False
        eggs[curr][0] -= eggs[target][1]
        eggs[target][0] -= eggs[curr][1]
        cnt = 0
        if eggs[curr][0] <= 0:
            cnt += 1
        if eggs[target][0] <= 0:
            cnt += 1

        solve(prev + cnt, curr + 1)

        eggs[curr][0] += eggs[target][1]
        eggs[target][0] += eggs[curr][1]

    if isAllBroken:
        solve(prev, n)


n = int(input())
eggs = [list(map(int, input().split())) for _ in range(n)]

answer = -1

solve(0, 0)

print(answer)