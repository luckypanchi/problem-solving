import sys

input = sys.stdin.readline


def getParents(node):
    results = []
    while node != -1:
        results.append(node)
        node = parents[node]

    return results


tc = int(input())
for _ in range(tc):
    n = int(input())
    parents = [-1] * (n + 1)
    for _ in range(n - 1):
        a, b = map(int, input().split())
        parents[b] = a

    node1, node2 = map(int, input().split())

    parents1 = getParents(node1)
    parents2 = getParents(node2)

    answer = -1
    while parents1 and parents2:
        p1 = parents1.pop()
        p2 = parents2.pop()

        if p1 == p2:
            answer = p1
        else:
            break

    print(answer)