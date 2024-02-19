import sys

input = sys.stdin.readline


def cut(pivotLength):
    currLength = 0
    count = 0

    for piece in pieces:
        currLength += piece
        if currLength > pivotLength:
            currLength = piece
            count += 1

    return count, currLength if count == C else pieces[-1]


L, K, C = map(int, input().split())
array = list(map(int, input().split())) + [0, L]
array.sort()
pieces = [array[i + 1] - array[i] for i in range(0, len(array) - 1)][::-1]

maxLength = max(pieces)
answerLength = 0
answerFristPosition = 0

left, right = 0, L
while left <= right:
    mid = (left + right) // 2

    if maxLength > mid:
        left = mid + 1
        continue

    count, firstPosition = cut(mid)
    if count <= C:
        answerLength = mid
        answerFristPosition = firstPosition
        right = mid - 1
    else:
        left = mid + 1

print(answerLength, answerFristPosition)