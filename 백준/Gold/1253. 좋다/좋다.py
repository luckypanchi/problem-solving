import sys

input = sys.stdin.readline


n = int(input())
numbers = sorted(list(map(int, input().split())))

answer = 0

for i in range(n):
    array = numbers[:i] + numbers[i + 1 :]
    left = 0
    right = n - 2

    while left < right:
        s = array[left] + array[right]
        if numbers[i] == s:
            answer += 1
            break
        elif numbers[i] < s:
            right -= 1
        else:
            left += 1

print(answer)