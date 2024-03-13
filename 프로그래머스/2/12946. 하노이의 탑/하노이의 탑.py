def move(n, curr, start, dest):
    if curr == n:
        return []

    result = []

    mid = 6 - start - dest

    result.extend(move(n, curr + 1, start, mid))
    result.append([start, dest])
    result.extend(move(n, curr + 1, mid, dest))

    return result


def solution(n):
    answer = move(n, 0, 1, 3)
    return answer
