### Task 1
HAS BEEN ADDED TO Oneplus18. Done in golang.

### Task 2 - Time Complexities for Data Structures
Calculate the worst-case time complexity for the operations (Find, Insert and Remove) in the following:

* Unsorted Array
* Sorted Array
* Unsorted Singly Linked List
* Sorted Singly Linked List

Calculate the average and worst case time complexity for the operations (Find, Insert and Remove):

* Hash Table (You can assume that the number of elements is equal to the size of the table)

Let n be the number of elements and present the solution in a table as shown
below. As usual you should **motivate your answers**.

| Operation   | Unsorted Array   | Sorted Array   | Unsorted SLL   | Sorted SLL   | Hash table (Average) | Hash table (Worst)  |
| ----------- | ---------------- | -------------- | -------------- | ------------ | ----------------     | ------------------- |
| Find        |We have to traverse: O(n) & theta(n)|O(log(n)) with binary search. Though theta(log(n)/2) because element will on avg be in middle and we can stop when passing a point.|Will need to traverse = O(n), theta(n)|We have to traverse: O(n), though theta(n/2) because element will on avg be in middle and we can stop when passing a point.|Assuming it is well implemented with little or no collisions and clustering, theta(1) to calculate hash and find.|Maximum clustering and we essentially just have a unsorted SLL. O(n)|
| Insert      |We need to use Find, giving O(n) & theta(n) (If array is full, we cannot insert ).|We use Find - O(log(n)) & theta(log(n)/2).  (If array is full, we cannot insert - making it a dynamic table which is not the question (?)) |Same argument as above. O(1), theta(1)|We need to use Find - O(n) & theta(n/2)|Same argument as above. US SLL has theta(1) for insert though.|Same argument as above, O(n)|
| Remove      |We need to to use Find with O(n) theta(n) first, and removal (setting to null) adds O(1) = O(n) & theta(n)|Need to use Find first with O(log(n)) & theta(log(n)/2),  removal (setting to null) adds O(1) not changing O or theta.|First Find O(n) and then remove adds O(1) = O(n), theta(n)|Need to Find and remove - O(n), theta(n/2)|Same argument as above. theta(1)|Same argument as above, US SLL has removal O(n) for removal.|

> **Assistant's note:** When it comes to arrays and linked lists, the average
> and worst case time complexities for these operations are the same, so it is
> not interesting to calculate both.

### Task 3 - Dynamic Tables
The `ArrayList` in Java is a convenient wrapper to make the primitive arrays
more flexible.  However, arrays are fixed in size at the point of creation,
i.e. they have a certain `capacity`. This means there is a cost involved if we
grow beyond the intial capacity by adding more elements than can be stored.
But, the API for `Arraylist` states, "*The add operation runs in amortized
constant time*".

Consider an `Arraylist` that grows from it's initial size of zero with a
sequence of calls to `add(E e)`, to a size of 20 elements.

```java
ArrayList list = new ArrayList();

// Adding elements
for(int i = 0; i<20; i++) {
    list.add(new Object());
}
```

Answer the following:

1. What is the initial capacity of an `ArrayList`'s internal array?  
**Answer**: 10 with 
```java
private static final int DEFAULT_CAPACITY = 10; 
```

2. At what size does the internal array grow, and by how much?  
**Answer**: When the list size == capacity and it grows by a factor of 1 + 0.5 (bitshift)

```java
private int newCapacity(int minCapacity) { 
        // overflow-conscious code 
        int oldCapacity = elementData.length; 
        int newCapacity = oldCapacity + (oldCapacity >> 1); 
        if (newCapacity - minCapacity <= 0) { 
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) 
                return Math.max(DEFAULT_CAPACITY, minCapacity); 
            if (minCapacity < 0) // overflow 
                throw new OutOfMemoryError(); 
            return minCapacity; 
        } 
        return (newCapacity - MAX_ARRAY_SIZE <= 0) 
            ? newCapacity 
            : hugeCapacity(minCapacity); 
    } 

```

3. Explain what really happens by the term "grow" in this context?  
**Answer**: It creates a copy of the current array, using Arrays.copyOf(array, newsize).
```java
private Object[] grow(int minCapacity) { 
        return elementData = Arrays.copyOf(elementData, 
                                           newCapacity(minCapacity)); 
    } 
```

4. What is the capacity of the internal array once 20 elements have been added?  
**Answer**: The capacity goes 10 -> 15 -> 22. It is hence 22 at the point of 20 elements length.

5. If objects were removed, would the size of the internal array change also?  
**Answer**: No, no function is called to reduce the capacity after removal.

6. What is the worst, average, and best-case time complexity of the `add(E e)`
   method of `Arraylist`?  
   **Answer**: Worst case is (n), as the full array must be copied to a larger array. 
   Average case can be calculated through ammortized cost:
        For each insert +1 (totaling +n)
        Each copy requires +3n
        Hence each operation requires 4n in ammortization. For n operations, that gives 4n/n = 4
   The average case is then (1)
   Best case would be that there is an available element to add in, giving (1)
