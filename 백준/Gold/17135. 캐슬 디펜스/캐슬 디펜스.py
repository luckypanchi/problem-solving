import sys
input = sys.stdin.readline
from collections import deque
import copy

dx = [-1, 0, 1]
dy = [0, -1, 0]

def pArr(arr):
    for i in arr:
        print(i)

def main():
    n, m, d = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]

    endline = 0
    for i in range(n):
        if 1 in matrix[i]:
            endline = n-i
            break
    
    matrix.append([0]*m)

    def moveDown(array):
        for i in range(n-1,0,-1):
            array[i] = array[i-1]
        array[0] = [0]*m
    
    def gameStart(a, b, c): 
        cnt = 0
        tmpArray = copy.deepcopy(matrix)
        for _ in range(endline):
            enemy = []
            for start in [a, b, c]:
                que = deque()
                r = 1
                que.append((n-1, start, r))
                while que:
                    y, x, r = que.popleft()
                    if tmpArray[y][x] == 1:
                        enemy.append((y, x))
                        break
                    for i in range(3):
                        nx = x + dx[i]
                        ny = y + dy[i]
                        if 0<=nx<m and 0<=ny<n and r+1 <= d:
                            que.append((ny, nx, r+1))
                
            enemy = list(set(enemy))
            if enemy:
                for arr in enemy:
                    y, x = arr
                    tmpArray[y][x] = 0
                    cnt += 1 
            
            moveDown(tmpArray)
    
        return cnt

    
    result = []
    for i in range(m-2):
        matrix[n][i] = '#'
        for j in range(i+1, m-1):
            matrix[n][j] = '#'
            for k in range(j+1, m):
                matrix[n][k] = '#'
                result.append(gameStart(i, j, k))                
                matrix[n][k] = 0
            matrix[n][j] = 0
        matrix[n][i] = 0

    answer = max(result)
    print(answer)



if __name__ == "__main__":
    main()