from datetime import datetime
import math
import random

def switcharoo(first,second,arr):
    temp = 0
    if(arr[first]>arr[second]):
            temp = arr[first]
            arr[first] = arr[second]
            arr[second]= temp
    return arr

def quicksort(A, lo, hi):
    if (hi - lo < 31):
        for i in range(lo, hi):
            key = A[i]
            j = i-1                             #insertion
            while j >=0 and key < A[j] :
                    A[j+1] = A[j]
                    j -= 1
            A[j+1] = key
        #print(arr)
        return(A)
    else:
    #if ( hi>lo):
        p = partition(A, lo, hi)
        quicksort(A, lo, p - 1)
        quicksort(A, p + 1, hi)

def partition(arr, lo, hi) :
    media = int(math.floor((hi-lo)/2))
    arr = switcharoo(lo, lo+media, arr)
    arr = switcharoo(lo, hi-1, arr)
    arr = switcharoo(lo+media, hi-1 ,arr)
    pivot = arr[lo +media]
    i = lo
    for j in range(lo,hi) :
        if (arr[j] < pivot) :
            arr = switcharoo(i, j, arr)
            i = i + 1
    arr = switcharoo(i, hi, arr)
    return i


n = 1000
while n <= 10096000:
    size = n
    data = []
    print(n)
    for i in range(size):
        data.append(random.randint(1, size))  # random numbers

    #for i in range(size):  # Reverse ordered numbers
    #    data.append(size - i)

    ranList = []
    for i in range(5):
        ranList.append(random.randint(1, 100))
    for i in range(size):
        if (i + 1) in ranList:
            data.append(random.randint(1, size))            #5% out of order                                                            # 5 % data out of order
        elif((i + 1) % 100 == 0):
            for j in range(5):
                ranList[j] = random.randint(i + 1, i + 101)
            data.append(i + 1)
        else:
            data.append(i + 1)

    start_time = datetime.now()
    quicksort(data,0, n-1)
    end_time = datetime.now()
    print('Duration: {}'.format(end_time - start_time))
    n = n*2

'''
    choosen = random.randint(1, 100)
    for i in range(size):
        if (i + 1 == choosen):
            data.append(random.randint(1, size))
                   # 1 % data out of order
        elif((i + 1) % 100 == 0):
            choosen = random.randint(i + 1, i + 101)
            data.append(i + 1)
        else:
            data.append(i + 1)
'''
