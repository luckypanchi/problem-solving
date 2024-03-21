import heapq


def solution(n, k, enemy):
    rounds = len(enemy)
    if rounds <= k:
        return rounds

    h = []
    answer = 0
    for i in range(rounds):
        if len(h) < k:
            answer += 1
            heapq.heappush(h, enemy[i])
            continue

        if h[0] < enemy[i]:
            t = heapq.heappop(h)
            heapq.heappush(h, enemy[i])
        else:
            t = enemy[i]

        n -= t
        if n < 0:
            break

        answer += 1

    return answer
