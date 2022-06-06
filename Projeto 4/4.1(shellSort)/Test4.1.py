# Test version
import random
import math
from datetime import datetime


def shellSort(array, n, increments):
    k = 1
    length = len(increments)
    while k <= length:
        interval = increments[length-k]
        k += 1
       # print (interval)
        for i in range(interval, n):
            temp = array[i]
            j = i
            while j >= interval and array[j - interval] > temp:
                array[j] = array[j - interval]
                j -= interval
            array[j] = temp


#size = int(input())
n = 1000
while n <= 1024000:
    size = n
    print(n)
    countador = 0
    data = []
    # for i in range(size):
    #    data.append(random.randint(1, size))  # random numbers
    for i in range(size):  # Reverse ordered numbers
        data.append(size - i)

    '''choosen = random.randint(1, 100)
    print(choosen)
    for i in range(size):
        if (i + 1 == choosen):
            data.append(random.randint(1, size))
            countador += 1                       # 1 % data out of order
        elif((i + 1) % 100 == 0):
            choosen = random.randint(i + 1, i + 101)
            data.append(i + 1)
        else:
            data.append(i + 1)
'''
    '''ranList = []
    for i in range(5):
        ranList.append(random.randint(1, 100))
    # print(ranList)
    print(n)
    for i in range(size):
        if (i + 1) in ranList:
            data.append(random.randint(1, size))
            countador += 1  # 5 % data out of order
        elif((i + 1) % 100 == 0):
            for j in range(5):
                ranList[j] = random.randint(i + 1, i + 101)
            data.append(i + 1)
        else:
            data.append(i + 1)'''

    #print("Contadorzinho: " + str(countador))
    # print(data)
    increments = []
    # increments.append(1)  # Needed for Papernov & Stasevich and Sedgewick
    increments.append(math.floor(size/2))  # Needed for Base shellSort
    i = 0
    while (True):
        i = i + 1
        num = math.floor(increments[i-1]/2)  # Base shellSort
        # num = pow(4, i+1) + 3*pow(2, i) + 1   # Sedgewick
        # num = pow(2, i) + 1  # Papernov & Stasevich'''
        # num = pow(2, i) - 1  # Hibbard
        # num = (pow(3, i) - 1) // 2  # Knuth
        if (num > 0):     # < Size or > 0 in the base version
            increments.append(num)
        else:
            break

    increments.reverse()  # Only used for base version
    # print(increments)
    # print(len(increments))
    print("*********************")
    start_time = datetime.now()
    shellSort(data, size, increments)
    end_time = datetime.now()
    print('Duration: {}'.format(end_time - start_time))
    n = n*2
    # print(data)
