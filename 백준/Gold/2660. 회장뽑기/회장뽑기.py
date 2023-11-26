import sys
from collections import defaultdict, deque

input = sys.stdin.readline

INF = float("inf")


n = int(input())
graph = defaultdict(list)

while True:
    a, b = map(int, input().split())
    if (a, b) == (-1, -1):
        break
    graph[a].append(b)
    graph[b].append(a)

distances = [0] * (n + 1)


def bfs(start):
    que = deque()
    visited = [-1] * (n + 1)

    que.append(start)
    visited[start] = 0

    while que:
        curr = que.popleft()

        for nextNode in graph[curr]:
            if visited[nextNode] == -1:
                visited[nextNode] = visited[curr] + 1
                que.append(nextNode)

    return max(visited)


for curr in range(1, n + 1):
    distances[curr] = bfs(curr)

answerPoint = INF
answerCount = 0
answer = []

for i in range(1, n + 1):
    if distances[i] < answerPoint:
        answerPoint = distances[i]
        answerCount = 1
        answer = [i]
    elif distances[i] == answerPoint:
        answerCount += 1
        answer.append(i)

print(answerPoint, answerCount)
print(*answer)