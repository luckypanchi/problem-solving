from itertools import combinations
from collections import defaultdict


def solution(orders, course):
    counter = defaultdict(int)

    for order in orders:
        for n in course:
            for com in list(combinations(list(order), n)):
                com = sorted(list(com))
                counter["".join(com)] += 1

    result = defaultdict(list)
    maxOrder = defaultdict(int)
    for k, v in counter.items():
        if v == 1:
            continue

        courseLength = len(k)

        if maxOrder[courseLength] == v:
            result[courseLength].append(k)
        elif maxOrder[courseLength] < v:
            maxOrder[courseLength] = v
            result[courseLength].clear()
            result[courseLength].append(k)

    answer = []
    for count in course:
        answer += result[count]

    answer.sort()
    return answer