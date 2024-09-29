import sys

input = sys.stdin.readline


def solve():
    while numbers:
        target = numbers.pop()

        for i in range(len(numbers)):
            left = i
            right = len(numbers) - 1

            while left <= right:
                s = numbers[i] + numbers[left] + numbers[right]
                if s == target:
                    return target
                elif s < target:
                    left += 1
                else:
                    right -= 1


n = int(input())
numbers = [int(input()) for _ in range(n)]

numbers.sort()
answer = solve()

print(answer)