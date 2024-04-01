import sys

input = sys.stdin.readline


n = int(input())
numbers = list(map(int, input().split()))
isVisited = [False] * 100001

left, right = 0, 0
answer = 0

while left < n and right < n:
    if not isVisited[numbers[right]]:
        isVisited[numbers[right]] = True
        right += 1
        answer += right - left
    else:
        isVisited[numbers[left]] = False
        left += 1

print(answer)
