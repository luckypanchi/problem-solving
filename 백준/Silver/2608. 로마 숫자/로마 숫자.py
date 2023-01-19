import sys

input = sys.stdin.readline

symbols = {
    "I": 1,
    "V": 5,
    "X": 10,
    "L": 50,
    "C": 100,
    "D": 500,
    "M": 1000,
    "IV": 4,
    "IX": 9,
    "XL": 40,
    "XC": 90,
    "CD": 400,
    "CM": 900,
}


def to_number(string):
    num = 0
    i = 0
    while i < len(string):
        if i != len(string) - 1:
            tmp = string[i] + string[i + 1]
            if tmp in symbols:
                num += symbols[tmp]
                i += 2
                continue
        num += symbols[string[i]]
        i += 1
    return num


def to_symbol(num):
    snum = str(num)
    s = ""
    length = len(snum)
    for i in range(length, 0, -1):
        n = int(snum[length - i])
        if i == 4:
            s += "M" * n
        elif i == 3:
            if n == 9:
                s += "CM"
            elif n == 4:
                s += "CD"
            else:
                if n >= 5:
                    s += "D"
                    n -= 5
                s += "C" * n
        elif i == 2:
            if n == 9:
                s += "XC"
            elif n == 4:
                s += "XL"
            else:
                if n >= 5:
                    s += "L"
                    n -= 5
                s += "X" * n
        elif i == 1:
            if n == 9:
                s += "IX"
            elif n == 4:
                s += "IV"
            else:
                if n >= 5:
                    s += "V"
                    n -= 5
                s += "I" * n
    return s


a = input().strip()
b = input().strip()


SUM = to_number(a) + to_number(b)
STRING = to_symbol(SUM)

print(SUM)
print(STRING)
