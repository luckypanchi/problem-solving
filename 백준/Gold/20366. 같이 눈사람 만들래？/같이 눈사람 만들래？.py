import sys

input = sys.stdin.readline

INF = float("inf")


n = int(input())
numbers = sorted(list(map(int, input().split())))
answer = INF


for i in range(n):
    for j in range(i + 3, n):
        left = i + 1
        right = j - 1
        while left < right:
            diff = numbers[i] + numbers[j] - (numbers[left] + numbers[right])
            answer = min(answer, abs(diff))

            if diff < 0:
                right -= 1
            else:
                left += 1

print(answer)