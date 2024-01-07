def dfs(n, k):
    if n == 1:
        return "11011"[:k].count("1")

    a, b = divmod(k, 5 ** (n - 1))

    if a <= 1:
        cnt = 4 ** (n - 1) * a + dfs(n - 1, b)

    elif a == 2:
        cnt = 2 * 4 ** (n - 1)

    elif a > 2:
        cnt = 4 ** (n - 1) * (a - 1) + dfs(n - 1, b)

    return cnt


def solution(n, l, r):
    answer = dfs(n, r) - dfs(n, l - 1)
    return answer