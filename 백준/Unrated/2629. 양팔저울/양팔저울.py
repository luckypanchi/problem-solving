import sys

input = sys.stdin.readline


n = int(input())
weights = list(map(int, input().split()))
m = int(input())
marbles = list(map(int, input().split()))

dp = [[False] * (30 * 500 + 1) for _ in range(n + 1)]
results = set()


def calc(idx, w):
    if dp[idx][w]:
        return

    dp[idx][w] = True
    results.add(w)

    if idx + 1 < n:
        calc(idx + 1, w)
        calc(idx + 1, w + weights[idx + 1])
        calc(idx + 1, abs(w - weights[idx + 1]))


calc(0, 0)
calc(0, weights[0])

for marble in marbles:
    if marble in results:
        print("Y", end=" ")
    else:
        print("N", end=" ")