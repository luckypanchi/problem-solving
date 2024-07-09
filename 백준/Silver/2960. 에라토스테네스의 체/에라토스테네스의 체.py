import sys

input = sys.stdin.readline


n, k = map(int, input().split())

numbers = [True] * (n + 1)
cnt = 0

for num in range(2, n + 1):
    if numbers[num]:
        numbers[num] = False
        cnt += 1
        if cnt == k:
            print(num)
            sys.exit()

        for i in range(num + num, n + 1, num):
            if numbers[i]:
                numbers[i] = False
                cnt += 1
                if cnt == k:
                    print(i)
                    sys.exit()