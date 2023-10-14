def solve(number):
    num = number
    cnt = 0

    while num % 2 == 1:
        cnt += 1
        num //= 2

    if cnt == 0:
        return number + 1
    else:
        return number + 2 ** (cnt - 1)


def solution(numbers):
    answer = []

    for num in numbers:
        answer.append(solve(num))

    return answer
