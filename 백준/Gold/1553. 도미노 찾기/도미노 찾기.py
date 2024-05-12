import sys

input = sys.stdin.readline

dx = (1, 0)
dy = (0, 1)


def checkRange(y, x):
    return 0 <= y < 8 and 0 <= x < 7


def solve(curr):
    if curr == 56:
        return 1

    y = curr // 7
    x = curr % 7

    if visited[y][x]:
        return solve(curr + 1)

    currNumber = board[y][x]

    result = 0

    for i in range(2):
        ny = y + dy[i]
        nx = x + dx[i]
        if not checkRange(ny, nx) or visited[ny][nx]:
            continue

        nextNumber = board[ny][nx]
        if isSelected[currNumber][nextNumber] or isSelected[nextNumber][currNumber]:
            continue

        isSelected[currNumber][nextNumber] = True
        isSelected[nextNumber][currNumber] = True
        visited[y][x] = True
        visited[ny][nx] = True
        result += solve(curr + 1)
        visited[ny][nx] = False
        visited[y][x] = False
        isSelected[nextNumber][currNumber] = False
        isSelected[currNumber][nextNumber] = False

    return result


board = [list(map(int, input().strip())) for _ in range(8)]

isSelected = [[False] * 7 for _ in range(7)]
visited = [[False] * 7 for _ in range(8)]

print(solve(0))