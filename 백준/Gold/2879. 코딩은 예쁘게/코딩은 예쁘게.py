import sys

sys.setrecursionlimit(10**6)

input = sys.stdin.readline


def solve(curr):
    global answer

    if curr == n:
        return

    if targets[curr] == 0:
        solve(curr + 1)
        return

    t = targets[curr]
    idxs = [curr]
    for i in range(curr + 1, n):
        if targets[curr] * targets[i] <= 0:
            break

        idxs.append(i)
        if targets[curr] < 0:
            t = max(t, targets[i])
        else:
            t = min(t, targets[i])

    answer += abs(t)
    for i in idxs:
        targets[i] -= t

    solve(curr)


n = int(input())
start = list(map(int, input().split()))
dest = list(map(int, input().split()))
targets = [dest[i] - start[i] for i in range(n)]

answer = 0
solve(0)

print(answer)