import sys

input = sys.stdin.readline


n, a = map(int, input().split())

num = a
answer = 0
while num <= n:
    answer += n // num
    num *= a

print(answer)