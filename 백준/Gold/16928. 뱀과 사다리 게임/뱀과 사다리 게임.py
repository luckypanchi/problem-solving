import sys
from collections import deque

input = sys.stdin.readline


def main():
    n, m = map(int, input().split())
    ladders = [-1] * 100
    for _ in range(n + m):
        a, b = map(int, input().split())
        ladders[a - 1] = b - 1

    visited = [0] * 100

    def bfs():
        que = deque()
        que.append((0, 0))
        visited[0] = 1
        while que:
            curr, cnt = que.popleft()

            if curr == 99:
                print(cnt)
                return

            for i in range(1, 7):
                p = curr + i
                if p < 100 and visited[p] == 0:
                    visited[p] = 1
                    if ladders[p] != -1:
                        p = ladders[p]
                        visited[p] = 1
                    que.append((p, cnt + 1))

    bfs()


main()
