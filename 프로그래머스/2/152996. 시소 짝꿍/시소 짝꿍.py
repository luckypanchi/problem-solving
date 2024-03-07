from collections import defaultdict, Counter


def solution(weights):
    totalWeights = defaultdict(list)
    counter = Counter(weights)
    answer = 0

    for w, count in counter.items():
        answer += count * (count - 1) // 2
        totalWeights[2 * w].append(w)
        totalWeights[3 * w].append(w)
        totalWeights[4 * w].append(w)

    for array in totalWeights.values():
        length = len(array)
        if length == 1:
            continue

        for i in range(length - 1):
            for j in range(i + 1, length):
                answer += counter[array[i]] * counter[array[j]]

    return answer
