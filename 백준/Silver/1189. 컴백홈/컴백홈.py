import sys

input = sys.stdin.readline


dy = (0, 1, 0, -1)
dx = (1, 0, -1, 0)


def dfs(currY, currX, currDist):
    global answer

    if currDist > k:
        return

    if currY == 0 and currX == c - 1:
        if currDist == k:
            answer += 1
        return

    for i in range(4):
        ny = currY + dy[i]
        nx = currX + dx[i]
        if 0 <= ny < r and 0 <= nx < c and not visited[ny][nx] and board[ny][nx] != "T":
            visited[ny][nx] = True
            dfs(ny, nx, currDist + 1)
            visited[ny][nx] = False


r, c, k = map(int, input().split())
board = [list(input().strip()) for _ in range(r)]
visited = [[False] * c for _ in range(r)]

answer = 0

visited[r - 1][0] = True
dfs(r - 1, 0, 1)

print(answer)