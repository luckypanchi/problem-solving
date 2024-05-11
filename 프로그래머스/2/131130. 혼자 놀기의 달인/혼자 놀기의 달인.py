def solution(cards):
    answer = 0

    for start1 in cards:
        isOpened = [False] * (len(cards) + 1)

        curr = start1
        count1 = 0
        while not isOpened[curr]:
            count1 += 1
            isOpened[curr] = True
            curr = cards[curr - 1]

        if isOpened[1:].count(False) == 0:
            answer = max(answer, 0)
            break

        for start2 in cards:
            if isOpened[start2]:
                continue

            curr = start2
            count2 = 0
            while not isOpened[curr]:
                count2 += 1
                isOpened[curr] = True
                curr = cards[curr - 1]

            answer = max(answer, count1 * count2)

    return answer