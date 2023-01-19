import sys
from collections import deque

input = sys.stdin.readline


def main():
    a, b = map(int, input().split())

    def bfs():
        que = deque()
        que.append((a, 1))
        visited = [a]
        while que:
            num, cnt = que.popleft()

            if num <= b:
                if num == b:
                    print(cnt)
                    return

                if 2 * num not in visited:
                    visited.append(2 * num)
                    que.append((2 * num, cnt + 1))
                if 10 * num + 1 not in visited:
                    visited.append(10 * num + 1)
                    que.append((10 * num + 1, cnt + 1))
        print(-1)

    bfs()


main()
