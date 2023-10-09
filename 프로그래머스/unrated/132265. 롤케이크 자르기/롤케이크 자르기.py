from collections import defaultdict, Counter


def solution(topping):
    left = defaultdict(int)
    right = Counter(topping)

    answer = 0

    for i in range(len(topping)):
        curr = topping[i]
        left[curr] += 1
        right[curr] -= 1
        if right[curr] == 0:
            del right[curr]

        if len(left) == len(right):
            answer += 1

    return answer
