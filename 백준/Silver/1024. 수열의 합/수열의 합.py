import sys

input = sys.stdin.readline


n, min_length = map(int, input().split())

answer = -1
for length in range(min_length, 101):
    if 0 <= n - length * (length - 1) // 2 and (n - length * (length - 1) // 2) % length == 0:
        start = (n - length * (length - 1) // 2) // length
        answer = []
        for i in range(length):
            answer.append(start + i)
        break

if answer == -1:
    print(answer)
else:
    print(*answer)