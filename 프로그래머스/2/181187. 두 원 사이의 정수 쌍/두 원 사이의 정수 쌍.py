import math


def count(r1, r2, x):
    if r1 < x:
        return int((r2**2 - x**2) ** 0.5) + 1
    else:
        return int((r2**2 - x**2) ** 0.5) - math.ceil((r1**2 - x**2) ** 0.5) + 1


def solution(r1, r2):
    side = 0
    for x in range(1, r2 + 1):
        side += count(r1, r2, x)
    answer = 4 * side
    return answer


print(solution(2, 3))
