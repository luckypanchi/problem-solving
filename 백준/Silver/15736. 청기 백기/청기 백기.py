import sys

input = sys.stdin.readline


n = int(input())

answer = 0
num = 1

while num * num <= n:
    answer += 1
    num += 1

print(answer)