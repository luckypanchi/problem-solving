import sys
from collections import defaultdict

input = sys.stdin.readline


t = int(input())
n = int(input())
a = list(map(int, input().split()))
m = int(input())
b = list(map(int, input().split()))

a_dict = defaultdict(int)
b_dict = defaultdict(int)

for ai in range(n):
    for aj in range(ai + 1, n + 1):
        a_dict[sum(a[ai:aj])] += 1

for bi in range(m):
    for bj in range(bi + 1, m + 1):
        b_dict[sum(b[bi:bj])] += 1

answer = 0

for a in a_dict:
    if t - a in b_dict:
        answer += a_dict[a] * b_dict[t - a]

print(answer)