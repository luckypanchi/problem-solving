def solution(n):
    columnCheck = [False] * n
    daegakCheck1 = [False] * (2 * n + 1)
    daegakCheck2 = [False] * (2 * n + 1)

    answer = 0

    def check(y, x):
        if columnCheck[x] or daegakCheck1[y + x] or daegakCheck2[n + x - y]:
            return False

        return True

    def mark(y, x):
        columnCheck[x] = True
        daegakCheck1[y + x] = True
        daegakCheck2[n + x - y] = True

    def unmark(y, x):
        columnCheck[x] = False
        daegakCheck1[y + x] = False
        daegakCheck2[n + x - y] = False

    def solve(y):
        nonlocal answer
        if y == n:
            answer += 1
            return

        for x in range(n):
            if check(y, x):
                mark(y, x)
                solve(y + 1)
                unmark(y, x)

    solve(0)

    return answer
