import sys
from collections import deque

input = sys.stdin.readline


def bfs():
    que = deque([(n, 0)])
    visited = [[-1, -1] for _ in range(500001)]
    visited[n][0] = 0

    while que:
        curr, time = que.popleft()

        d = [1, -1, curr]
        for i in range(3):
            nxt = curr + d[i]
            if 0 <= nxt < 500001 and visited[nxt][(time + 1) % 2] == -1:
                visited[nxt][(time + 1) % 2] = time + 1
                que.append((nxt, time + 1))

    time = 0
    target = k
    while target < 500001:
        if -1 < visited[target][time % 2] <= time:
            return time

        time += 1
        target += time

    return -1


n, k = map(int, input().split())

answer = bfs()
print(answer)

"""
7 37
5

10 57 
5

21 70 
4

18 58 
4

18 66 
4

16 50 
4

34 0 
8
"""