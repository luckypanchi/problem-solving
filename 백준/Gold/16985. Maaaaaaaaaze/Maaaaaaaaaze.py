import sys
input = sys.stdin.readline
from collections import deque
import itertools
import copy

dx = [1, 0, -1, 0, 0, 0]
dy = [0, -1, 0, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

def main():
    matrix = [[list(map(int, input().split())) for _ in range(5)] for _ in range(5)]
    tmpArr = [[[0]*5 for _ in range(5)] for _ in range(5)]

    def rotate(idx):
        tmp = [[0]*5 for _ in range(5)]

        for i in range(5):
            for j in range(5):
                tmp[j][4-i] = tmpArr[idx][i][j]

        tmpArr[idx] = tmp

    def bfs():
        que = deque()
        que.append((0, 0, 0))
        visited = [[[0]*5 for _ in range(5)] for _ in range(5)] 
        visited[0][0][0] = 1
        while que:
            z,y,x = que.popleft()
            for i in range(6):
                nx = x + dx[i]
                ny = y + dy[i]
                nz = z + dz[i]
                if 0<=nx<5 and 0<=ny<5 and 0<=nz<5 and tmpArr[nz][ny][nx] != 0 and visited[nz][ny][nx] == 0:
                    visited[nz][ny][nx] = visited[z][y][x] + 1
                    que.append((nz, ny, nx))
        return visited[4][4][4] - 1

    answer = 9999

    def maze(idx):
        nonlocal answer
        if idx == 5:
            if tmpArr[4][4][4]:
                result = bfs()
                if result != -1: answer = min(answer, result)
                if result == 12: 
                    print(12)
                    sys.exit()
            return

        for _ in range(4):
            if tmpArr[0][0][0]:
                maze(idx+1)
            rotate(idx)

    for arr in itertools.permutations(range(5)):
        for idx in range(5):
            tmpArr[arr[idx]] = matrix[idx]
        maze(0)    
        
    if answer == 9999: answer = -1
    print(answer)


if __name__ == "__main__":
    main()