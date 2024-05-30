def solution(distance, rocks, n):
    rocks.sort()
    rocks.append(distance)

    left = 1
    right = distance

    while left <= right:
        mid = (left + right) // 2
        count = 0
        prev = 0
        for rock in rocks:
            d = rock - prev
            if d < mid:
                count += 1
            else:
                prev = rock

        if n < count:
            right = mid - 1
        else:
            answer = mid
            left = mid + 1

    return answer
