INF = float("inf")


def calcPoint(apeachShots, ryanShots):
    apeachPoint = 0
    ryanPoint = 0
    for i in range(11):
        if apeachShots[i] == 0 and ryanShots[i] == 0:
            continue

        if ryanShots[i] <= apeachShots[i]:
            apeachPoint += 10 - i
        else:
            ryanPoint += 10 - i

    return (apeachPoint, ryanPoint)


def cmpPointCount(old, new):
    for i in range(10, -1, -1):
        if old[i] < new[i]:
            return True
        elif new[i] < old[i]:
            return False


def solution(n, info):
    def comb(curr, prev):
        nonlocal diff, answer

        if curr == n:
            apeachPoint, ryanPoint = calcPoint(info, shotCount)
            if ryanPoint <= apeachPoint:
                return

            if diff < ryanPoint - apeachPoint:
                diff = ryanPoint - apeachPoint
                answer = shotCount[:]
            elif diff == ryanPoint - apeachPoint and cmpPointCount(answer, shotCount):
                answer = shotCount[:]

            return

        for i in range(prev, 11):
            shotCount[i] += 1
            comb(curr + 1, i)
            shotCount[i] -= 1

    answer = [-1]
    diff = -INF
    shotCount = [0] * 11

    comb(0, 0)

    return answer