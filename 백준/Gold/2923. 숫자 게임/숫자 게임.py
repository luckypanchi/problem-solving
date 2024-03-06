import sys
import copy

input = sys.stdin.readline


def solve():
    global counterA, counterB

    savedCounterA = copy.deepcopy(counterA)
    savedCounterB = copy.deepcopy(counterB)

    a, b = 1, 100

    result = 0
    while True:
        a, b = findFirstNoneZero(counterA, a, False), findFirstNoneZero(counterB, b, True)

        if a == -1 or b == -1:
            break

        _min = min(counterA[a], counterB[b])
        counterA[a] -= _min
        counterB[b] -= _min

        result = max(result, a + b)

    counterA = savedCounterA
    counterB = savedCounterB

    return result


def findFirstNoneZero(array, start, isReversed):
    if not isReversed:
        for i in range(start, 101):
            if array[i] > 0:
                return i
    else:
        for i in range(start, 0, -1):
            if array[i] > 0:
                return i

    return -1


n = int(input())
counterA = [0] * 101
counterB = [0] * 101

for _ in range(n):
    a, b = map(int, input().split())
    counterA[a] += 1
    counterB[b] += 1

    print(solve())