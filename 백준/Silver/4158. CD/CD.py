import sys

input = sys.stdin.readline


while True:
    n, m = map(int, input().split())
    if n == 0 and m == 0:
        break

    sg = [int(input()) for _ in range(n)]
    sy = [int(input()) for _ in range(n)]

    pointer1 = 0
    pointer2 = 0
    answer = 0
    while pointer1 < n and pointer2 < m:
        if sg[pointer1] == sy[pointer2]:
            answer += 1
            pointer1 += 1
            pointer2 += 1
        elif sg[pointer1] < sy[pointer2]:
            pointer1 += 1
        else:
            pointer2 += 1

    print(answer)