from functools import cmp_to_key


def cmp(x, y):
    if str(y) + str(x) < str(x) + str(y):
        return -1
    else:
        return 1


def solution(numbers):
    numbers.sort(key=cmp_to_key(cmp))
    return str(int("".join(list(map(str, numbers)))))
