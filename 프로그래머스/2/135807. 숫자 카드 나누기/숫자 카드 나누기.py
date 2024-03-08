def getGCD(big, small):
    if small == 0:
        return big
    else:
        return getGCD(small, big % small)


def check(opposite, gcd):
    for number in opposite:
        if number % gcd == 0:
            return False

    return True


def solution(arrayA, arrayB):
    length = len(arrayA)
    arrayA.sort()
    arrayB.sort()

    gcdA = arrayA[0]
    gcdB = arrayB[0]
    for i in range(1, length):
        gcdA = getGCD(arrayA[i], gcdA)
        gcdB = getGCD(arrayB[i], gcdB)

    answer = 0

    if check(arrayA, gcdB):
        answer = max(answer, gcdB)

    if check(arrayB, gcdA):
        answer = max(answer, gcdA)

    return answer
