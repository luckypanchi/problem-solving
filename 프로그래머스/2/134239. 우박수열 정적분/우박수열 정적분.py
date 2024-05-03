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
    answer = []

    for start, end in ranges:
        end = n + end

        if end < start:
            answer.append(-1.0)
            continue

        result = 0.0
        for x in range(start, end):
            result += 0.5 * (collatz[x] + collatz[x + 1])

        answer.append(result)

    return answer