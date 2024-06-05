import sys

input = sys.stdin.readline


n = int(input())
numbers = sorted(list(map(int, input().split())))
x = int(input())

answer = 0
start = 0
end = n - 1
while start < end:
    if numbers[start] + numbers[end] == x:
        answer += 1
        start += 1
        end -= 1
    elif numbers[start] + numbers[end] < x:
        start += 1
    else:
        end -= 1

print(answer)