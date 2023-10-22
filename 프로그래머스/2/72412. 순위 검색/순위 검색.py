from itertools import combinations
from collections import defaultdict


def lowerBound(arr, k):
    left, right = 0, len(arr)

    while left < right:
        mid = (left + right) // 2
        if arr[mid] < k:
            left = mid + 1
        else:
            right = mid
    return left


def solution(information, query):
    answer = []
    infoDict = defaultdict(list)

    for info in information:
        splitedInfo = info.split()
        key = splitedInfo[:-1]
        value = int(splitedInfo[-1])

        for j in range(5):
            for comb in combinations(key, j):
                tmp = "".join(comb)
                infoDict[tmp].append(value)

    for k in infoDict:
        infoDict[k].sort()

    for q in query:
        splitedQ = q.split()
        key = splitedQ[:-1]
        value = int(splitedQ[-1])

        while "and" in key:
            key.remove("and")
        while "-" in key:
            key.remove("-")
        key = "".join(key)

        if key in infoDict:
            scores = infoDict[key]
            if scores:
                idx = lowerBound(scores, value)
                answer.append(len(scores) - idx)
        else:
            answer.append(0)

    return answer