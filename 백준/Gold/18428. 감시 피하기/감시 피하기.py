import sys

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def check():
    for y, x in selected:
        board[y][x] = "O"

    for y, x in students:
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            while 0 <= ny < n and 0 <= nx < n and board[ny][nx] != "O":
                if board[ny][nx] == "T":
                    for y, x in selected:
                        board[y][x] = "X"
                    return False

                ny += dy[i]
                nx += dx[i]

    for y, x in selected:
        board[y][x] = "X"

    return True


def dfs(curr, start):
    global answer
    if curr == 3:
        if check():
            answer = True
        return

    for i in range(start, len(empty_spaces)):
        selected.append(empty_spaces[i])
        dfs(curr + 1, i + 1)
        selected.pop()


n = int(input())
board = [list(input().split()) for _ in range(n)]

empty_spaces = []
students = []

for i in range(n):
    for j in range(n):
        if board[i][j] == "X":
            empty_spaces.append((i, j))
        elif board[i][j] == "S":
            students.append((i, j))

selected = []
answer = False
dfs(0, 0)

print("YES" if answer else "NO")