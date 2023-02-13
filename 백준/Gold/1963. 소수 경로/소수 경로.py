import sys
from collections import deque

input = sys.stdin.readline

d = [1000, 100, 10, 1, -1000, -100, -10, -1]

seive = [True] * 10000
m = int(10000**0.5)
for i in range(2, m + 1):
    if seive[i] is True:
        for j in range(i + i, 10000, i):
            seive[j] = False


def bfs(a, b):
    que = deque()
    que.append((a, 0))
    visited = [False] * 10000
    visited[a] = True

    while que:
        curr, cnt = que.popleft()
        for i in range(8):
            nxt = curr
            arr = list(str(curr))
            arr[4 - len(str(abs(d[i])))] = "0"
            start = int("".join(arr))
            dest = start + abs(d[i]) * 10
            for _ in range(9):
                nxt += d[i]
                if 1000 <= nxt < 10000 and start <= nxt < dest:
                    if not visited[nxt] and seive[nxt]:
                        visited[nxt] = True
                        que.append((nxt, cnt + 1))
                        if nxt == b:
                            return cnt + 1
                else:
                    break

    return -1


tc = int(input())
for _ in range(tc):
    a, b = map(int, input().split())

    if a == b:
        print(0)
    else:
        result = bfs(a, b)
        if result == -1:
            print("Impossible")
        else:
            print(result)