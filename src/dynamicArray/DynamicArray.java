package dynamicArray;

import java.util.Iterator;

public class DynamicArray<E> implements Iterable<E> {
    private Node<E> head;
    private int maxValue;

    private class Node<H> {
        private H data;
        private Node<H> zero;
        private Node<H> one;

        Node() {
            data = null;
        }

        private H getData() {
            return data;
        }

        private void setData(H data) {
            this.data = data;
        }

        private Node<H> getZero() {
            if(zero == null) {
                zero = new Node<>();
            }
            return zero;
        }

        private Node<H> getOne() {
            if(one == null) {
                one = new Node<>();
            }
            return one;
        }
    }

    public DynamicArray() {
        head = new Node<>();
        maxValue = -1;
    }

    public int size() {
        return maxValue + 1;
    }

    public E get(int index) {
        if(index < 0) {
            throw new IllegalArgumentException("dynamicArray.DynamicArray.get(int index) index cannot be less than 0");
        }
        return getNode(index).getData();
    }

    public void set(int index, E data) {
        if(index < 0) {
            throw new IllegalArgumentException("dynamicArray.DynamicArray.set(int index) index cannot be less than 0");
        }
        getNode(index).setData(data);

        if(data == null && maxValue == index) {
            getNode(index).zero = null;
            getNode(index).one = null;
        } else if(index > maxValue) {
            maxValue = index;
        }
    }

    private int[] toBin(int dec) {
        if(dec < 0) {
            throw new IllegalArgumentException("dynamicArray.DynamicArray.toBin(int dec) negative int not allowed here");
        }
        int d = dec;
        int i = 0;

        while(d > 0) {
            d /= 2;
            i++;
        }

        d = dec;
        int[] bin = new int[i];
        i = 0;
        while(d > 0) {
            bin[i] = d % 2;
            d /= 2;
            i++;
        }

        return bin;
    }

    private Node<E> getNode(int index) {
        int[] binIndex = toBin(index);
        Node<E> cur = head;
        for(int i : binIndex) {
            if(i == 0) {
                cur = cur.getZero();
            } else {
                cur = cur.getOne();
            }
        }
        return cur;
    }

    public boolean isEmpty() {
        return maxValue == -1;
    }

    public boolean hasData(int index) {
        return getNode(index).data != null;
    }

    public void clear() {
        maxValue = -1;
        head = null;
    }

    @Override
    public Iterator<E> iterator() {
        return new DynamicArrayIterator();
    }

    private class DynamicArrayIterator implements Iterator<E> {
        private int cur;
        private int max;

        public DynamicArrayIterator() {
            cur = 0;
            max = maxValue;
        }

        @Override
        public boolean hasNext() {
            return cur <= max;
        }

        @Override
        public E next() {
            E res = get(cur);
            cur++;
            return res;
        }
    }
}
