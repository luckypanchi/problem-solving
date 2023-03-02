import sys

input = sys.stdin.readline


def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])

    return parents[x]


def union(a, b):
    p_a = find(a)
    p_b = find(b)

    if p_a < p_b:
        parents[p_b] = p_a
    elif p_b < p_a:
        parents[p_a] = p_b


g = int(input())
p = int(input())
parents = list(range(g +1))
answer = 0

for _ in range(p):
    target = int(input())
    parent = find(target)
    if parent == 0:
        break
    else:
        answer += 1
        union(parent - 1, parent)

print(answer)