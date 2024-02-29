import sys

input = sys.stdin.readline


tc = int(input())

for _ in range(tc):
    n, k, t, m = map(int, input().split())
    scores = [[0] * (k + 1) for _ in range(n + 1)]
    count = [0] * (n + 1)
    last = [-1] * (n + 1)
    final = [0] * (n + 1)

    for idx in range(m):
        i, j, s = map(int, input().split())
        scores[i][j] = max(scores[i][j], s)
        count[i] += 1
        last[i] = idx

    for i in range(1, n + 1):
        final[i] += sum(scores[i])

    array = []
    for i in range(1, n + 1):
        array.append((i, final[i], count[i], last[i]))

    array.sort(key=lambda x: (-x[1], x[2], x[3]))

    for i in range(n):
        if array[i][0] == t:
            print(i + 1)