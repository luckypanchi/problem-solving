import sys
import math

input = sys.stdin.readline


def solve(left, currSize):
    global answerCount

    if left == 0 or left == currSize:
        return

    answerCount += 1

    if currSize // 2 <= left < currSize:
        solve(left - currSize // 2, currSize // 2)
    else:
        solve(left, currSize // 2)


K = int(input())

answerSize = 2 ** math.ceil(math.log2(K))
answerCount = 0

solve(K, answerSize)

print(answerSize, answerCount)