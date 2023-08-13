string = list(input().strip())

for s in string:
    if s.islower():
        print(s.upper(), end="")
    elif s.isupper():
        print(s.lower(), end="")
        