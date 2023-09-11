import sys

input = sys.stdin.readline


d, k = map(int, input().split())
dp1 = [0] * (d + 1)
dp2 = [0] * (d + 1)

dp1[1] = 1
dp1[2] = 0
dp2[1] = 0
dp2[2] = 1

for i in range(3, d + 1):
    dp1[i] = dp1[i - 1] + dp1[i - 2]
    dp2[i] = dp2[i - 1] + dp2[i - 2]

for a in range(1, k):
    for b in range(1, k):
        if dp1[d] * a + dp2[d] * b == k:
            print(a)
            print(b)
            sys.exit()
