import sys

input = sys.stdin.readline


a = input().strip()
b = input().strip()


if sorted(a) != sorted(b):
    print(-1)
    sys.exit()

answer = 0

length = len(a)
j = length - 1

for i in range(length - 1, -1, -1):
    if a[i] != b[j]:
        answer += 1
    else:
        j -= 1


print(answer)