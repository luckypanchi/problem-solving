import sys

input = sys.stdin.readline

INF = float("inf")

n = int(input())
packs = [0] + list(map(int, input().split()))

for i in range(1, n + 1):
    left = 1
    right = i - 1
    while left <= right:
        packs[i] = min(packs[i], packs[left] + packs[right])
        left += 1
        right -= 1

print(packs[n])