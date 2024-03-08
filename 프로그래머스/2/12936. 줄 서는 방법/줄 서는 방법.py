def solution(n, k):

    factorial = [0] * (n + 1)
    factorial[0] = 1
    for i in range(1, n + 1):
        factorial[i] = factorial[i - 1] * i

    answer = [0] * n
    isUsed = [False] * (n + 1)
    for curr in range(n):
        count = 0
        f = factorial[n - 1 - curr]
        for number in range(1, n + 1):
            if isUsed[number]:
                continue

            if 1 + f * count <= k < 1 + f * (count + 1):
                isUsed[number] = True
                answer[curr] = number
                k -= f * count
                break

            count += 1

    return answer
