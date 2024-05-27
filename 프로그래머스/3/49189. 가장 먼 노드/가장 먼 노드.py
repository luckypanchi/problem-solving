from collections import defaultdict, deque


def solution(n, edge):
    graph = defaultdict(list)
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)

    results = [0] * (n + 1)
    visited = [False] * (n + 1)
    visited[1] = True

    que = deque()
    que.append((1, 0))

    while que:
        curr, depth = que.popleft()
        results[curr] = depth

        for nextNode in graph[curr]:
            if not visited[nextNode]:
                visited[nextNode] = True
                que.append((nextNode, depth + 1))

    answer = results.count(max(results))
    return answer
