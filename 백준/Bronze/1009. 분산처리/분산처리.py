import sys

input = sys.stdin.readline


tc = int(input())


for _ in range(tc):
    a, b = map(int, input().split())

    tmp = []
    res = 1
    while True:
        res = res * a % 10
        if res in tmp:
            break
        tmp.append(res)

    answer = tmp[(b - 1) % len(tmp)]
    if answer == 0:
        answer = 10

    print(answer)