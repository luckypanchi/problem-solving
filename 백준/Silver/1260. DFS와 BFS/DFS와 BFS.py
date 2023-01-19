from sys import stdin

def main():
    n, m, v = map(int, stdin.readline().split())
    matrix = [[0] * (n + 1) for _ in range(n + 1)]
    for _ in range(m):
        a, b = map(int, stdin.readline().split())
        matrix[a][b] = matrix[b][a] = 1

    def dfs(start, visited):
        visited += [start]
        for c in range(len(matrix[start])):
            if matrix[start][c] == 1 and (c not in visited):
                dfs(c, visited)
        return visited

    def bfs(start):
        visited = [start]
        queue = [start]
        while queue:
            n = queue.pop(0)
            for c in range(len(matrix[start])):
                if matrix[n][c] == 1 and (c not in visited):
                    visited.append(c)
                    queue.append(c)
        return visited

    print(*dfs(v,[]))
    print(*bfs(v))

main()