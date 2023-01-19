import sys

def main():
    n, v = map(int, sys.stdin.readline().split())
    matrix = [[0]*(n+1) for _ in range(n+1)]
    for _ in range(v):
        a, b = map(int, sys.stdin.readline().split())
        matrix[a][b] = matrix[b][a] = 1
    visited = [0]*(n+1)

    def dfs(start):
        visited[start] = 1
        for i in range(len(matrix[start])):
            if matrix[start][i] == 1 and visited[i] == 0:
                dfs(i)
    
    answer = 0

    for i in range(1, n+1):
        if visited[i] == 0:
            answer += 1
            dfs(i)

    
    print(answer)


if __name__ == "__main__":
    main()