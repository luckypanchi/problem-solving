def solution(n, times):
    left = 1
    right = max(times) * n
    answer = 0

    while left <= right:
        mid = (left + right) // 2
        people = 0
        for time in times:
            people += mid // time

        if n <= people:
            answer = mid
            right = mid - 1
        else:
            left = mid + 1

    return answer
