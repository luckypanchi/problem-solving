LIMIT = 10000000
INF = float("inf")


def f(num):
    if num == 1:
        return 0

    res = -INF

    for i in range(1, int(num**0.5) + 1):
        if num % i == 0:
            if i <= LIMIT:
                res = max(res, i)
            if num // i <= LIMIT and i != 1:
                res = max(res, num // i)

    return res


def solution(begin, end):
    answer = []
    for num in range(begin, end + 1):
        answer.append(f(num))

    return answer
