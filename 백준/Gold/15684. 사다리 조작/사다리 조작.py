import sys

input = sys.stdin.readline


INF = float("inf")


def go(start):
    x = start
    for y in range(h):
        if x < ladderColumn and ladder[y][x]:
            x += 1
        elif 0 < x and ladder[y][x - 1]:
            x -= 1
    return x == start


def check():
    for start in range(n):
        if not go(start):
            return False
    return True


def ladderCheck(y, x):
    if ladder[y][x]:
        return False

    if x + 1 < ladderColumn and ladder[y][x + 1]:
        return False

    if 0 <= x - 1 and ladder[y][x - 1]:
        return False

    return True


def solve(count, start):
    if count == 0:
        return check()

    for curr in range(start, ladderColumn * h):
        y = curr // ladderColumn
        x = curr % ladderColumn

        if ladderCheck(y, x):
            ladder[y][x] = True
            if solve(count - 1, curr + 1):
                return True
            ladder[y][x] = False

    return False


n, m, h = map(int, input().split())
ladderColumn = n - 1
ladder = [[False] * ladderColumn for _ in range(h)]

for _ in range(m):
    a, b = map(int, input().split())
    ladder[a - 1][b - 1] = True

answer = -1
for c in range(4):
    if solve(c, 0):
        answer = c
        break

print(answer)