from collections import defaultdict


def solution(gems):
    n = len(set(gems))
    counter = defaultdict(int)

    start = 0
    end = 0
    minLength = len(gems) + 1
    answer = []

    counter[gems[0]] += 1

    while start <= end and end < len(gems):
        if len(counter) == n and end - start < minLength:
            minLength = end - start
            answer = [start + 1, end + 1]

        if len(counter) < n and end + 1 < len(gems):
            end += 1
            counter[gems[end]] += 1
        else:
            counter[gems[start]] -= 1
            if counter[gems[start]] == 0:
                del counter[gems[start]]
            start += 1

    return answer
