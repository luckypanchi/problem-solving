import sys
input = sys.stdin.readline
from collections import deque

def main():
    n, m = map(int, input().split())
    matrix = [[0]*(n+1) for _ in range(n+1)]

    for _ in range(m):
        a, b = map(int, input().split())
        matrix[a][b] = 1
        matrix[b][a] = 1

    answer = [0]*(n+1)

    def getNum(i, j):
        que = deque()
        que.append((i, 1))

        while que:
            curr, cnt = que.popleft()
            if matrix[curr][j] == 1: return cnt
            else:
                for k in range(1, n+1):
                    if matrix[curr][k] == 1: que.append((k, cnt+1))

    for i in range(1, n+1):
        for j in range(1, n+1):
            if i == j: continue
            answer[i] += getNum(i, j)

    min = 9999
    idx = 0

    for i in range(1, n+1):
        
        if answer[i]<min:
            min = answer[i]
            idx = i    
    
    print(idx)

if __name__ == "__main__":
    main()