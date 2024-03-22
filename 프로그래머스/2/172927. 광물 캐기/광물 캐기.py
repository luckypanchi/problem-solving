def getCost(typ, round):
    if typ == 0:
        return sum(round)
    elif typ == 1:
        return round[0] + round[1] + 5 * round[2]
    elif typ == 2:
        return round[0] + 5 * round[1] + 25 * round[2]


def solution(picks, minerals):
    minerals = minerals[: 5 * sum(picks)]
    rounds = []
    for i in range(0, len(minerals), 5):
        curr = [0, 0, 0]
        for j in range(min(5, len(minerals) - i)):
            if minerals[i + j] == "stone":
                curr[0] += 1
            elif minerals[i + j] == "iron":
                curr[1] += 1
            elif minerals[i + j] == "diamond":
                curr[2] += 1
        rounds.append(curr)

    rounds.sort(key=lambda x: (x[2], x[1], x[0]), reverse=True)

    answer = 0
    curr = 0
    for typ in range(3):
        for _ in range(picks[typ]):
            if curr < len(rounds):
                answer += getCost(typ, rounds[curr])
                curr += 1

    return answer