from collections import defaultdict, deque

INF = float("inf")


def bfs(n, graph, start, end):
    que = deque()
    visited = [False] * (n + 1)

    que.append(1)
    visited[1] = True
    cnt = 1

    while que:
        curr = que.popleft()

        for nextNode in graph[curr]:
            if (
                visited[nextNode]
                or (curr == start and nextNode == end)
                or (curr == end and nextNode == start)
            ):
                continue

            visited[nextNode] = True
            que.append(nextNode)
            cnt += 1

    return cnt


def solution(n, wires):
    graph = defaultdict(list)

    for a, b in wires:
        graph[a].append(b)
        graph[b].append(a)

    answer = INF

    for a, b in wires:
        result = bfs(n, graph, a, b)
        answer = min(answer, abs(2 * result - n))

    return answer
