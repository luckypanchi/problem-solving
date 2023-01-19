import sys

input = sys.stdin.readline


n = int(input())
numbers = sorted(list(map(int, input().split())))
x = int(input())

start, end = 0, n - 1
answer = 0

while start < end:
    for i in range(end, start, -1):
        if numbers[start] + numbers[i] == x:
            end = i
            answer += 1
            break
    start += 1

print(answer)
