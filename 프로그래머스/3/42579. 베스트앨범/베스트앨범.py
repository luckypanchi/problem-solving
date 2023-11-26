from collections import defaultdict

byGenre = defaultdict(int)
counter = defaultdict(int)


def solution(genres, plays):
    n = len(genres)

    for i in range(n):
        byGenre[genres[i]] += plays[i]

    result = []
    for i in range(n):
        result.append((i, plays[i], genres[i]))

    result.sort(key=lambda x: (-byGenre[x[2]], -x[1], x[0]))

    answer = []
    for i in range(n):
        if counter[result[i][2]] < 2:
            answer.append(result[i][0])
        counter[result[i][2]] += 1

    return answer
