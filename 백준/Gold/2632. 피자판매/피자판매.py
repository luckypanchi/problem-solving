import sys
from collections import defaultdict

input = sys.stdin.readline


targetSize = int(input())
m, n = map(int, input().split())
pizzaA = [int(input()) for _ in range(m)]
pizzaB = [int(input()) for _ in range(n)]

pizzaASizes = defaultdict(int)
pizzaBSizes = defaultdict(int)

for start in range(m):
    size = 0
    for length in range(m - 1):
        idx = (start + length) % m
        size += pizzaA[idx]
        pizzaASizes[size] += 1

pizzaASizes[sum(pizzaA)] += 1

for start in range(n):
    size = 0
    for length in range(n - 1):
        idx = (start + length) % n
        size += pizzaB[idx]
        pizzaBSizes[size] += 1

pizzaBSizes[sum(pizzaB)] += 1

answer = pizzaASizes[targetSize] + pizzaBSizes[targetSize]

for pizzaASize in pizzaASizes:
    pizzaBSize = targetSize - pizzaASize
    answer += pizzaASizes[pizzaASize] * pizzaBSizes[pizzaBSize]

print(answer)