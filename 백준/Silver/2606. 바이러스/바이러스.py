import sys

def main():
    n = int(sys.stdin.readline())
    m = int(sys.stdin.readline())
    visited = [0]*(n+1)
    matrix = [[0]*(n+1) for _ in range(n+1)]
    
    for _ in range(m):
        a, b = map(int, sys.stdin.readline().split())
        matrix[a][b] = matrix[b][a] = 1

    def dfs(visited, start, length):
        visited[start] = 1
        for i in range(length):
            if matrix[start][i] == 1 and visited[i] == 0:
                dfs(visited, i, length)

    dfs(visited, 1, n+1)
    print(visited.count(1)-1)

main()