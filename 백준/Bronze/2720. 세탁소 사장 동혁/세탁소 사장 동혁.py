import sys

input = sys.stdin.readline


tc = int(input())

m = [25, 10, 5, 1]
answer = []

for _ in range(tc):
    money = int(input())
    counts = [0] * 4

    for idx, n in enumerate(m):
        counts[idx] += money // n
        money = money % n

    answer.append(counts)

for result in answer:
    print(*result)
