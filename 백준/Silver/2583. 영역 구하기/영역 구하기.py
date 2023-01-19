import sys
sys.setrecursionlimit(10**5)

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def main():
    m, n, k = map(int, sys.stdin.readline().split())
    matrix = [[0] * n for _ in range(m)]
    visited = [[0] * n for _ in range(m)]

    for _ in range(k):
        a, b, c, d = map(int, sys.stdin.readline().split())
        for i in range(a, c):
            for j in range(b, d):
                matrix[j][i] = 1

    def dfs(y, x, idx):
        visited[y][x] = 1
        answer[idx] += 1

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<n and 0<=ny<m and matrix[ny][nx] == 0 and visited[ny][nx] == 0:
                dfs(ny, nx, idx)
    
    answer = []
    idx = -1
    for i in range(m):
        for j in range(n):
            if matrix[i][j] == 0 and visited[i][j] == 0:
                answer.append(0)
                idx += 1
                dfs(i, j, idx)

    answer.sort()

    print(len(answer))
    for i in answer:
        print(i, end=' ')

if __name__ == "__main__":
    main()