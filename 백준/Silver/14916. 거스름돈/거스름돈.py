import sys

input = sys.stdin.readline

n = int(input())

answer = 0

while n > 0:
    if n % 5 == 0:
        answer += n // 5
        break
    answer += 1
    n -= 2

if n < 0:
    print(-1)
else:
    print(answer)
