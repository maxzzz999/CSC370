import random
import string

testDict = {}

for x in range(100):
    str1 = ''.join(random.choices(string.ascii_uppercase + string.ascii_lowercase, k=3))
    if str1 in testDict:
        print('\n', testDict.get(str1), '\n')
    else:
        testDict.update({str1: random.randint(0, 100)})

for key in testDict:
    print(key, ' : ', testDict[key])
