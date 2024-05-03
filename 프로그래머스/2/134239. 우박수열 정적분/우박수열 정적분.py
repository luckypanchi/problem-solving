def collatzGuess(k):
    results = [k]

    while k > 1:
        if k % 2 == 0:
            k = k // 2
        else:
            k = 3 * k + 1

        results.append(k)

    return results


def solution(k, ranges):

    collatz = collatzGuess(k)
    n = len(collatz) - 1

    areas = [0.0]
    for x in range(1, n + 1):
        areas.append(areas[-1] + 0.5 * (collatz[x - 1] + collatz[x]))

    answer = []

    for start, end in ranges:
        end = n + end

        if end < start:
            answer.append(-1.0)
            continue

        answer.append(areas[end] - areas[start])

    return answer