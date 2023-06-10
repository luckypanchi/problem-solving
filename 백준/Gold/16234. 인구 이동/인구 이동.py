import sys
from collections import deque

input = sys.stdin.readline

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)


n, l, r = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]
answer = 0

while True:
    visited = [[False] * n for _ in range(n)]
    que = deque()
    flag = True
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                que.append((i, j))
                visited[i][j] = True
                arr = [(i, j)]
                s = matrix[i][j]

                while que:
                    y, x = que.popleft()
                    for k in range(4):
                        ny = y + dy[k]
                        nx = x + dx[k]
                        if (
                            0 <= ny < n
                            and 0 <= nx < n
                            and not visited[ny][nx] 
                            and l <= abs(matrix[ny][nx] - matrix[y][x]) <= r
                        ):
                            visited[ny][nx] = True
                            que.append((ny, nx))
                            arr.append((ny, nx))
                            s += matrix[ny][nx]

                if len(arr) > 1:
                    flag = False
                    new_pop = s // len(arr)

                    for y, x in arr:
                        matrix[y][x] = new_pop
    if flag:
        break
    
    answer += 1

print(answer)