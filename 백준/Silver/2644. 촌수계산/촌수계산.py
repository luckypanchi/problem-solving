import sys
from collections import deque

def main():
    n = int(sys.stdin.readline())
    matrix = [[0]*(n+1) for _ in range(n+1)]
    start, dest = map(int, sys.stdin.readline().split())
    m = int(sys.stdin.readline())
    for _ in range(m):
        tmp1, tmp2 = map(int, sys.stdin.readline().split())
        matrix[tmp1][tmp2] = 1
        matrix[tmp2][tmp1] = 1
    
    visited = []
    answer = [0 for _ in range(n+1)]

    def bfs(s):
        que = deque()
        que.append(s)
        visited.append(s)
        while que:
            tmp = que.popleft()
            for i in range(n+1):     
                if matrix[i][tmp] == 1 and i not in visited:    
                    visited.append(i)
                    answer[i] = answer[tmp] + 1
                    que.append(i)

    bfs(start)
    print(answer[dest] if answer[dest] != 0 else -1)


if __name__ == "__main__":
    main()