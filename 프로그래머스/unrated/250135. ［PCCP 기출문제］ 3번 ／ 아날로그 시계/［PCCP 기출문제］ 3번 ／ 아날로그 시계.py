def getCount(h, m, s):
    hDegree = (h * 30 + m * 0.5 + s * 0.5 / 60) % 360
    mDegree = (m * 6 + s * 0.1) % 360
    sDegree = s * 6

    result = -1

    if mDegree <= sDegree:
        result += 1
    if hDegree <= sDegree:
        result += 1

    result += (h * 60 + m) * 2
    result -= h

    if h >= 12:
        result -= 2

    return result


def solution(h1, m1, s1, h2, m2, s2):
    answer = getCount(h2, m2, s2) - getCount(h1, m1, s1)

    if (h1 == 0 or h1 == 12) and m1 == 0 and s1 == 0:
        answer += 1

    return answer
