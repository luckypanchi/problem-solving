import sys

input = sys.stdin.readline


n = int(input())
numbers = list(map(int, input().split()))

flag = False
for i in range(n - 1, 0, -1):
    if numbers[i] < numbers[i - 1]:
        for j in range(n - 1, 0, -1):
            if numbers[i - 1] > numbers[j]:
                numbers[i - 1], numbers[j] = numbers[j], numbers[i - 1]
                numbers = numbers[:i] + sorted(numbers[i:], reverse=True)
                print(*numbers)
                exit()

print(-1)