import sys

input = sys.stdin.readline


n = int(input())

x = []
y = []

for _ in range(n):
    a, b = map(int, input().split())
    x.append(a)
    y.append(b)

x.append(x[0])
y.append(y[0])

res1 = 0
res2 = 0
for i in range(n):
    res1 += x[i] * y[i + 1]
    res2 += y[i] * x[i + 1]

answer = round(abs(res1 - res2) / 2, 1)

print(answer)