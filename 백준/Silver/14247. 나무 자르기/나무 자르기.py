import sys

input = sys.stdin.readline


n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

array = sorted([(a[i], b[i]) for i in range(n)], key=lambda x: x[1])

answer = 0
for i in range(n):
    answer += array[i][0] + array[i][1] * i

print(answer)