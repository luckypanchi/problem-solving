import sys

input = sys.stdin.readline


d, n = map(int, input().split())
ovens = list(map(int, input().split()))
pizzas = list(map(int, input().split()))

for i in range(d - 1):
    if ovens[i] < ovens[i + 1]:
        ovens[i + 1] = ovens[i]

p_idx = 0
answer = 0
for i in range(d - 1, -1, -1):
    if pizzas[p_idx] <= ovens[i]:
        p_idx += 1

    if p_idx == n:
        answer = i + 1
        break


print(answer)