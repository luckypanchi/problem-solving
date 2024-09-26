import sys

input = sys.stdin.readline


n = int(input())
numbers = [0] + list(map(int, input().split()))
prefix_sum = [0] * (n + 1)
for i in range(1, n + 1):
    prefix_sum[i] = prefix_sum[i - 1] + numbers[i]

m = int(input())

for _ in range(m):
    start, end = map(int, input().split())
    print(prefix_sum[end] - prefix_sum[start - 1])