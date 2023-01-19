import sys
from collections import deque

input = sys.stdin.readline


n, k = map(int, input().split())

visited = [-1] * 100001
answer = 0

que = deque()
que.append(n)
visited[n] = 0

while que:
    curr = que.popleft()

    if curr == k:
        answer += 1
        continue

    for nxt in (curr + 1, curr - 1, curr * 2):
        if 0 <= nxt < 100001 and (
            visited[nxt] == -1 or visited[nxt] == visited[curr] + 1
        ):
            visited[nxt] = visited[curr] + 1
            que.append(nxt)

print(visited[k])
print(answer)
