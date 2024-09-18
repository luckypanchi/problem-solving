import sys

input = sys.stdin.readline


def check(curr_degree, degree_set):
    if curr_degree in degree_set:
        return False

    if len(degree_set) != 0 and curr_degree <= max(degree_set):
        return False

    return True


n = int(input())
buildings = list(map(int, input().split()))

answers = [0] * n


for curr in range(n):
    degree = set()
    for _next in range(curr + 1, n):
        curr_degree = (buildings[_next] - buildings[curr]) / (_next - curr)
        if check(curr_degree, degree):
            degree.add(curr_degree)
            answers[curr] += 1

    degree = set()
    for _next in range(curr - 1, -1, -1):
        curr_degree = (buildings[_next] - buildings[curr]) / (curr - _next)
        if check(curr_degree, degree):
            degree.add(curr_degree)
            answers[curr] += 1


print(max(answers))