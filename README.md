# DynamicArray

## Description

```java
class DynamicArray<E> implements iterable<E>
```

DynamicArray is a java datatype that acts like an array, but does't need to be initialized with a value.
It essentially acts like an array that doesn't have a max index, while not having the time cost or memory overhead of something like a linked list.
Unlike Arraylist, any index can be set using .set(index, value) whereas calling that method using Arraylist would throw an array out of bounds exception.
It is implemented in a tree like structure so, it initially has no elements allocated and only allocates elements in the array when either that element is being acceded or certain elements after it are being accessed.

DynamicArray's strong suit is in random access of indexes in the array. It matches arrays, ArrayLists, and LinkedLists in speed and memory usage at small numbered indexes and beats all of them at large numbered indexes.
Its downside is in iterating over the whole array. Arrays, ArrayLists, and LinkedLists are all faster and use less memory when it comes to iteration.

## Methods

```java
public DynamicArray()   O(1)
``` 

```java
public int size()   O(1)
```

```java
public E get(int index)   O(log(index))
```

```java
public void set(int index, E data)   O(log(index))
```

```java
public boolean hasData(int index)   O(O(log(index)))
```

```java
public boolean isEmpty()   O(1)
```

```java
public void clear()   O(1)
```

```java
public Iterator<E> iterator()   O(1)    iterating using the iterator takes O(size() * log(size()))
```