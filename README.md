# dynamicArray.DynamicArray

## Description

```java
class DynamicArray<E> implements iterable<E>
```

dynamicArray.DynamicArray is a java datatype that acts like an array, but does't need to be initialized with a value when initialized.
It essentially acts like an array that doesn't have a max index, while not having the time cost or memory overhead of something like a linked list.
Unlike Arraylist, any index can be set using .set(index, value) whereas calling that method using Arraylist would throw an array out of bounds exception.
It is implemented in a tree like structure so, it initially has no elements allocated and only allocates elements in the array when either that element is being acceded or certain elements after it are being accessed.

dynamicArray.DynamicArray's string suit is in random access of indexes in the array. It matches arrays, ArrayLists, and LinkedList in speed and memory usage at small numbered indexes and beats all of them at large numbered indexes.
Its downside is in iterating over the whole array. Arrays, ArrayLists, and LinkedLists are all faster and use less memory when it comes to iteration.

## Methods

```java
public dynamicArray.DynamicArray()
```

```java
public int size()
```

```java
public E get(int index)
```

```java
public void set(int index, E data)
```

```java
fun hasData(index: Long): Boolean
```

```java
public boolean isEmpty()
```

```java
public boolean hasData(int index)
```

```java
public boolean hasData(int index)
```

```java
public void clear()
```

```java
public Iterator<E> iterator()
```