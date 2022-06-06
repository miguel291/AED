from datetime import datetime
import math
import random

def sort(array, radix=10):
  if len(array) == 0:
    #print("No array to sort")
    return array

  # Determine minimum and maximum values
  minValue = min(array)
  maxValue = max(array)
  # Perform counting sort on each exponent/digit, starting at the least
  # significant digit
  #print(minValue)
  #print(maxValue)
  exponent = 1
  while (maxValue - minValue) / exponent >= 1:                    #number of algorithms in max value in array
    array = countingSortByDigit(array, radix, exponent, minValue)
    exponent *= radix

  return array

def countingSortByDigit(array, radix, exponent, minValue):
  bucketIndex = -1
  buckets = [0] * radix
  output = [None] * len(array)

  # Count frequencies
  for i in range(0, len(array)):
    bucketIndex = math.floor(((array[i] ) / exponent) % radix) #  - minValue
    buckets[bucketIndex] += 1

  # Compute cumulates
  for i in range(1, radix):
    buckets[i] += buckets[i - 1]

  # Move records
  for i in range(len(array) - 1, -1, -1):
    bucketIndex = math.floor(((array[i]) / exponent) % radix)    #  - minValue
    buckets[bucketIndex] -= 1
    output[buckets[bucketIndex]] = array[i]
  #print(output)
  return output

n = 1000
while n <= 10096000:
    size = n
    data = []
    print(n)
    #for i in range(size):
    #    data.append(random.randint(1, size))  # random numbers
    #for i in range(size):  # Reverse ordered numbers
    #    data.append(size - i)
    """
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
        """
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

    start_time = datetime.now()
    sorted = sort(data)
    end_time = datetime.now()
    print('Duration: {}'.format(end_time - start_time))
    n = n*2
