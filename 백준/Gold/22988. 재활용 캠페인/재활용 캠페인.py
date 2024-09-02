import sys

input = sys.stdin.readline


n, x = map(int, input().split())
hair_essences = sorted(list(map(int, input().split())))

answer = 0

while hair_essences and hair_essences[-1] == x:
    answer += 1
    hair_essences.pop()

left = 0
right = len(hair_essences) - 1
leftover = len(hair_essences)

while left < right:
    if hair_essences[left] + hair_essences[right] >= x / 2:
        left += 1
        right -= 1
        answer += 1
        leftover -= 2
    else:
        left += 1

answer += leftover // 3

print(answer)