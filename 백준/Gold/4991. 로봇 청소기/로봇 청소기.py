import sys
input = sys.stdin.readline
import itertools
from collections import deque

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def main():
    answer = []

    def bfs(start):
        visited = [[0]*m for _ in range(n)]
        y, x = start
        visited[y][x] = 1
        que = deque()
        que.append(start)
        while que:
            y, x = que.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0<=nx<m and 0<=ny<n and not visited[ny][nx]:
                    if matrix[ny][nx] != 'x':
                        visited[ny][nx] = visited[y][x] + 1
                        que.append((ny, nx))
        return visited

    while True:
        m, n = map(int, input().split())

        if not n and not m: break
 
        matrix = [[x for x in input().strip()] for _ in range(n)]

        start = 0
        dest = []
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == 'o': start = (i, j)
                if matrix[i][j] == '*': dest.append((i, j))

        start_map = bfs(start)
        flag = 1
        cleaner = []
        for arr in dest:
            tmp = start_map[arr[0]][arr[1]]
            if not tmp:
                answer.append(-1)
                flag = 0
                break
            cleaner.append(tmp - 1)
        
        if flag:
            dest_map = [[0]*len(dest) for _ in range(len(dest))]
            
            for idx in range(len(dest)-1):
                visited = bfs(dest[idx])
                for i in range(idx+1, len(dest)):
                    dest_map[idx][i] = visited[dest[i][0]][dest[i][1]] - 1
                    dest_map[i][idx] = dest_map[idx][i]

            result = 9999
            sequence = list(itertools.permutations(range(len(dest))))

            for arr in sequence:
                sum = cleaner[arr[0]]
                startpoint = arr[0]
                for idx in range(1, len(dest)):
                    next = arr[idx]
                    sum += dest_map[startpoint][next]
                    startpoint = next
                result = min(sum, result)

            answer.append(result)                      

    for i in answer:
        print(i)


if __name__ == "__main__":
    main()