import sys
from collections import deque

dx = [1, 2, 2, 1, -1, -2, -2, -1]
dy = [2, 1, -1, -2, -2, -1, 1, 2]

def main():
    testcase = int(sys.stdin.readline())
    result = []
    for _ in range(testcase):
        length = int(sys.stdin.readline())
        s1, s2 = map(int, sys.stdin.readline().split())
        d1, d2 = map(int, sys.stdin.readline().split())
        cnt = [[0]*length for _ in range(length)]

        if s1 == d1 and s2 == d2:
            result.append(0)
            continue

        else: 
            def bfs():
                que = deque()
                que.append((s1, s2))
                while que:
                    x, y = que.popleft()
                    for i in range(8):
                        nx = x + dx[i]
                        ny = y + dy[i]
                        if 0<=nx<length and 0<=ny<length and cnt[ny][nx] == 0:
                            que.append((nx, ny))
                            cnt[ny][nx] = cnt[y][x] + 1
                            if nx == d1 and ny == d2:
                                return
            bfs()

            result.append(cnt[d2][d1])
    
    for i in result:
        print(i, end="\n")

if __name__ == "__main__":
    main()