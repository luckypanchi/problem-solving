import sys
input = sys.stdin.readline
from collections import deque

def main():
    start, dest = map(int, input().split())
    visited = [-1]*100001
    answer = []
    visited[start] = start

    def bfs():
        nonlocal answer

        que = deque()
        que.append(start)

        while que:
            curr = que.popleft()

            if curr == dest: 
                idx = curr
                while idx != start:
                    answer.append(idx)
                    idx = visited[idx]
                answer.append(start)
                break

            for point in (curr-1, curr+1, 2*curr):
                if 0<=point<100001 and visited[point] == -1:
                    visited[point] = curr
                    que.append(point)

    bfs()

    print(len(answer)-1)
    print(*answer[::-1])


if __name__ == "__main__":
    main()