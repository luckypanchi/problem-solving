import sys

input = sys.stdin.readline

INF = float("inf")


n, k = map(int, input().split())
numbers = list(map(int, input().split()))

positions = []

for i in range(n):
    if numbers[i] == 1:
        positions.append(i)


if len(positions) < k:
    print(-1)
    sys.exit()


length = len(positions)
answer = INF

for start in range(length - k + 1):
    end = start + k - 1
    answer = min(answer, positions[end] - positions[start] + 1)

print(answer)