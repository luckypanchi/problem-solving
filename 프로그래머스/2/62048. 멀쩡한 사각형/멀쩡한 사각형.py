import math


def solution(w, h):
    gcd = math.gcd(w, h)
    c = max(w // gcd, h // gcd)
    r = min(w // gcd, h // gcd)

    n = c / r
    result = r * c
    for i in range(r):
        result -= 2 * math.floor(n * i)

    answer = w * h - result * gcd

    return answer