import sys

input = sys.stdin.readline

INF = float("inf")


def check(startY, startX, length):
    if not (0 <= startY + length - 1 < 10 and 0 <= startX + length - 1 < 10):
        return False

    for y in range(startY, startY + length):
        for x in range(startX, startX + length):
            if visited[y][x] or board[y][x] == 0:
                return False

    return True


def mark(startY, startX, length, flag):
    for y in range(startY, startY + length):
        for x in range(startX, startX + length):
            visited[y][x] = flag


def solve(curr):
    if curr == len(ones):
        return sum(papers)

    y, x = ones[curr]

    if visited[y][x]:
        return solve(curr + 1)

    result = INF

    for siz in range(1, 6):
        if papers[siz] < 5 and check(y, x, siz):
            mark(y, x, siz, True)
            papers[siz] += 1
            result = min(result, solve(curr + 1))
            papers[siz] -= 1
            mark(y, x, siz, False)

    return result


board = [list(map(int, input().split())) for _ in range(10)]
papers = [0] * 6
visited = [[False] * 10 for _ in range(10)]

ones = []
for i in range(10):
    for j in range(10):
        if board[i][j] == 1:
            ones.append((i, j))


answer = solve(0)
if answer == INF:
    print(-1)
else:
    print(answer)