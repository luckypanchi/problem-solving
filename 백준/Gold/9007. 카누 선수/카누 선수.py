import sys

input = sys.stdin.readline

INF = float("inf")


tc = int(input())
for _ in range(tc):
    k, n = map(int, input().split())
    weights = [list(map(int, input().split())) for _ in range(4)]
    group1 = []
    group2 = []
    for i in range(n):
        for j in range(n):
            group1.append(weights[0][i] + weights[1][j])
            group2.append(weights[2][i] + weights[3][j])

    group1.sort()
    group2.sort()

    start = 0
    end = n**2 - 1
    answer = INF
    while start < n**2 and 0 <= end:
        s = group1[start] + group2[end]
        if s == k:
            answer = s
            break
        elif abs(s - k) < abs(answer - k):
            answer = s
        elif abs(s - k) == abs(answer - k):
            answer = min(answer, s)

        if s < k:
            start += 1
        else:
            end -= 1

    print(answer)