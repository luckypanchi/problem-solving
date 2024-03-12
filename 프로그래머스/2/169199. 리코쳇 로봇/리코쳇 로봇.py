from collections import deque

dy = (0, 1, 0, -1)
dx = (1, 0, -1, 0)


def move(board, y, x, d):
    n = len(board)
    m = len(board[0])

    while 0 <= y + dy[d] < n and 0 <= x + dx[d] < m and board[y + dy[d]][x + dx[d]] == ".":
        y += dy[d]
        x += dx[d]

    return (y, x)


def solution(board):
    n = len(board)
    m = len(board[0])

    start, dest = None, None
    for i in range(n):
        board[i] = list(board[i].strip())

    for i in range(n):
        for j in range(m):
            if board[i][j] == "R":
                start = (i, j)
                board[i][j] = "."
            elif board[i][j] == "G":
                dest = (i, j)
                board[i][j] = "."

    visited = [[-1] * m for _ in range(n)]
    visited[start[0]][start[1]] = 0

    que = deque()
    que.append((start[0], start[1]))

    while que:
        y, x = que.popleft()

        for i in range(4):
            ny, nx = move(board, y, x, i)

            if visited[ny][nx] == -1:
                visited[ny][nx] = visited[y][x] + 1

                que.append((ny, nx))

                if (ny, nx) == (dest[0], dest[1]):
                    return visited[ny][nx]

    return -1