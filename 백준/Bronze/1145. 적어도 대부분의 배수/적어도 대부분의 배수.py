import sys

input = sys.stdin.readline


numbers = list(map(int, input().split()))

target = min(numbers)
while True:
    cnt = 0
    for num in numbers:
        if target % num == 0:
            cnt += 1

    if cnt >= 3:
        break

    target += 1

print(target)