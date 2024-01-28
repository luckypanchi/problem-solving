def solve(array, startY, startX, number, depth):
    if depth <= 0:
        return

    last = (depth - 1) * 3 + number - 1
    s = last + number + 1

    array[startY][startX] = number
    number += 1

    if depth == 1:
        return

    for i in range(1, depth - 1):
        array[startY + i][startX] = number
        array[startY + i][startX + i] = s - number
        number += 1

    for i in range(depth):
        array[startY + depth - 1][startX + i] = number
        number += 1

    solve(array, startY + 2, startX + 1, last + 1, depth - 3)


def solution(n):
    result = [[0] * n for _ in range(n)]

    solve(result, 0, 0, 1, n)

    answer = []
    for i in range(n):
        for j in range(n):
            if result[i][j] != 0:
                answer.append(result[i][j])

    return answer
