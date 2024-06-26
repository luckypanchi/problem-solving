import sys

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


def dfs(y, x):
    result = 0
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < r and 0 <= nx < c:
            nextCharIndex = ord(board[ny][nx]) - ord("A")
            if visited[nextCharIndex]:
                continue

            visited[nextCharIndex] = True
            result = max(result, 1 + dfs(ny, nx))
            visited[nextCharIndex] = False

    return result


r, c = map(int, input().split())
board = [list(input().strip()) for _ in range(r)]

visited = [False] * 26
charIndex = ord(board[0][0]) - ord("A")
visited[charIndex] = True

answer = dfs(0, 0) + 1

print(answer)