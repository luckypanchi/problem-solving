class Date:
    def __init__(self, string):
        splited = string.split(".")
        self.year = int(splited[0])
        self.month = int(splited[1])
        self.day = int(splited[2])
        
    def __lt__(self, other):
        if self.year != other.year:
            return self.year < other.year
        elif self.month != other.month:
            return self.month < other.month
        else:
            return self.day < other.day
        

def solution(today, terms, privacies):
    today = Date(today)
    new_terms = {}
    for term in terms:
        term = term.split()
        new_terms[term[0]] = int(term[1])
    
    answer = []
    
    for idx, privacy in enumerate(privacies):
        privacy = privacy.split()
        date = Date(privacy[0])
        kind = privacy[1]
        
        date.month += new_terms[kind]
        date.day -= 1
        if date.day == 0:
            date.day = 28
            date.month -= 1
        while date.month > 12:
            date.year += 1
            date.month -= 12
        
        if date < today:
            answer.append(idx + 1)
            
    return answer