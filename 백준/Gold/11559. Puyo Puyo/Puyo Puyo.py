import sys
input = sys.stdin.readline
from collections import deque

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def main():
    matrix = [list(input().strip()) for _ in range(12)]
    
    def bfs(curr, color):
        y, x = curr
        que = deque()
        que.append((y, x))
        tmp = []
        while que:
            y, x = que.popleft()
            tmp.append((y, x))
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0<=nx<6 and 0<=ny<12 and (ny, nx) not in tmp and matrix[ny][nx] == color:
                    que.append((ny, nx))
        return tmp if len(tmp) >= 4 else 0

    def goDown():
        for j in range(6):
            tmp = []
            for i in range(12):
                if matrix[i][j] != '.':
                    tmp.append(matrix[i][j])
            tmp = ['.']*(12-len(tmp)) + tmp
            for i in range(12):
                matrix[i][j] = tmp[i]

    answer = 0
    stop = False
    while True:
        arr = []
        for i in range(11, -1, -1):
            for j in range(6):
                for color in ['R', 'G', 'B', 'P', 'Y']:
                    if matrix[i][j] == color:
                        tmp = bfs((i, j), color)
                        if tmp: 
                            for item in tmp:
                                arr.append(item)
                        break
        if arr:
            answer += 1
            for k in arr:
                matrix[k[0]][k[1]] = '.'
            goDown()
        else: break

    print(answer)

if __name__ == "__main__":
    main()