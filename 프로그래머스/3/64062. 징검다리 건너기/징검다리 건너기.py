def solution(stones, k):
    answer = 0

    start, end = 1, max(stones)
    while start <= end:
        count = 0
        mid = (start + end) // 2

        for stone in stones:
            if (stone - mid) <= 0:
                count += 1
                if k <= count:
                    break
            else:
                count = 0

        if k <= count:
            end = mid - 1
        else:
            start = mid + 1
            answer = mid + 1

    return answer