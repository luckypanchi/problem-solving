import sys

input = sys.stdin.readline


n = int(input())
honey = list(map(int, input().split()))

total = sum(honey)
answer = 0

lost = honey[0]
for i in range(1, n - 1):
    lost += honey[i]
    answer = max(answer, total - honey[0] - honey[i] + total - lost)

honey.reverse()
lost = honey[0]
for i in range(1, n - 1):
    lost += honey[i]
    answer = max(answer, total - honey[0] - honey[i] + total - lost)

for i in range(1, n - 1):
    answer = max(answer, total - honey[0] - honey[-1] + honey[i])

print(answer)
