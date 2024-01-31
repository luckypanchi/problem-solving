def solution(sequence, k):
    n = len(sequence)
    length = n + 1
    left, right = 0, 0
    s = sequence[right]
    answer = []

    while left < n and right < n:
        if s == k:
            currLength = right - left + 1
            if currLength < length:
                length = currLength
                answer = [left, right]

        if s <= k and right < n:
            right += 1
            if right < n:
                s += sequence[right]
        elif k < s and left < n:
            s -= sequence[left]
            left += 1

    return answer
