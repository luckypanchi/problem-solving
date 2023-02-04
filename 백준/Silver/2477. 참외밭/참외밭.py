import sys

input = sys.stdin.readline


n = int(input())
widths = [[] for _ in range(5)]
targets = [(1, 3), (4, 1), (2, 4), (3, 2)]
moves = [list(map(int, input().split())) for _ in range(6)]
minus = -1
for i in range(6):
    a, b = moves[i]
    widths[a].append(b)

    if minus == -1:
        nxt_i = (i + 1) % 6
        c, d = moves[nxt_i]
        if (a, c) in targets:
            minus = b * d

total = max(max(widths[1]), max(widths[2])) * max(max(widths[3]), max(widths[4]))

print((total - minus) * n)
