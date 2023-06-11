import sys

input = sys.stdin.readline


n, m = map(int, input().split())
numbers = sorted(list(map(int, input().split())))

answers = set()

result = [0] * m
visited = [False] * n


def perm(idx):
    if idx == m:
        answers.add(tuple(result))
        return

    for i in range(n):
        if not visited[i]:
            visited[i] = True
            result[idx] = numbers[i]
            perm(idx + 1)
            visited[i] = False


perm(0)

answers = sorted(list(answers))

for ans in answers:
    print(*ans)