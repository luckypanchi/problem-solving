import sys

input = sys.stdin.readline


tc = int(input())
for _ in range(tc):
    x1, y1, x2, y2 = map(int, input().split())
    n = int(input())
    answer = 0
    for _ in range(n):
        x, y, r = map(int, input().split())
        res1 = (x1 - x) ** 2 + (y1 - y) ** 2
        res2 = (x2 - x) ** 2 + (y2 - y) ** 2
        if (res1 < r ** 2 and res2 > r ** 2) or (res1 > r ** 2 and res2 < r ** 2):
            answer += 1

    print(answer)


