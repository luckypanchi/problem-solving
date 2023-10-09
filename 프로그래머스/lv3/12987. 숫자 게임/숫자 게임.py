def upper_bound(arr, k):
    left, right = 0, len(arr) - 1

    while left < right:
        mid = (left + right) // 2
        if k < arr[mid]:
            right = mid
        else:
            left = mid + 1
    return left


def solution(A, B):
    answer = 0
    A.sort()
    B.sort()

    for a in A:
        result = upper_bound(B, a)
        if a < B[result]:
            answer += 1
        del B[result]

    return answer