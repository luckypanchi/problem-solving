def solution(board, skill):
    n = len(board)
    m = len(board[0])
    prefixSum = [[0] * (m + 1) for _ in range(n + 1)]

    for type, r1, c1, r2, c2, degree in skill:
        if type == 1:
            degree = -degree

        prefixSum[r1][c1] += degree
        prefixSum[r1][c2 + 1] -= degree
        prefixSum[r2 + 1][c1] -= degree
        prefixSum[r2 + 1][c2 + 1] += degree

    for y in range(1, n + 1):
        for x in range(m + 1):
            prefixSum[y][x] += prefixSum[y - 1][x]

    for x in range(1, m + 1):
        for y in range(n + 1):
            prefixSum[y][x] += prefixSum[y][x - 1]

    answer = 0
    for y in range(n):
        for x in range(m):
            board[y][x] += prefixSum[y][x]
            if 0 < board[y][x]:
                answer += 1

    return answer
