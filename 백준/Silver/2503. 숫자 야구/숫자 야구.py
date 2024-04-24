import sys

input = sys.stdin.readline


n = int(input())
results = [list(map(int, input().split())) for _ in range(n)]

answer = 0
for target in range(100, 1000):
    target = list(str(target))
    if len(set(target)) != 3 or "0" in target:
        continue

    flag = True
    for numbers, strike, ball in results:
        numbers = list(str(numbers))
        s = 0
        b = 0
        for num in range(1, 10):
            num = str(num)
            if num in target and num in numbers:
                if target.index(num) == numbers.index(num):
                    s += 1
                else:
                    b += 1

        if s != strike or b != ball:
            flag = False
            break

    if flag:
        answer += 1

print(answer)
