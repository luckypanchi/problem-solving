import sys
sys.setrecursionlimit(50000)

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
answer = []

def main():
    t = int(sys.stdin.readline())
    for _ in range(t):
        m, n, k = map(int, sys.stdin.readline().split())
        matrix = [[0]*m for _ in range(n)]
        for _ in range(k):
            a, b = map(int, sys.stdin.readline().split())
            matrix[b][a] = 1

        def dfs(x, y):
            matrix[x][y] = 0
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx<0 or nx>n-1 or ny<0 or ny>m-1: continue
                if matrix[nx][ny] == 1: dfs(nx, ny)
        
        cnt = 0

        for i in range(n):
            for j in range(m):
                if matrix[i][j] == 1:
                    cnt += 1
                    dfs(i, j)
        answer.append(cnt)
    for i in answer:
        print(i, end="\n")


if __name__ == "__main__":
    main()