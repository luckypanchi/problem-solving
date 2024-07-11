from collections import defaultdict


def solution(edges):
    inCount = defaultdict(int)
    outCount = defaultdict(int)

    end = -1
    for a, b in edges:
        end = max(end, a, b)
        outCount[a] += 1
        inCount[b] += 1

    answer = [0] * 4
    for node in range(1, end + 1):
        if inCount[node] == 0 and outCount[node] > 1:
            answer[0] = node
        elif inCount[node] > 0 and outCount[node] == 0:
            answer[2] += 1
        elif inCount[node] > 1 and outCount[node] == 2:
            answer[3] += 1

    answer[1] = outCount[answer[0]] - answer[2] - answer[3]

    return answer
