package com.sergosoft.wagonlist;

import java.util.*;

import com.sergosoft.railwaymanager.railwaycar.RailwayCar;


/**
 * A custom list implementation for managing RailwayCar objects.
 * This class implements the List interface and supports dynamic resizing with an initial capacity of 15 elements
 * and an increase capacity by 30% when needed.
 */
public class RailwayCarList implements List<RailwayCar> {
    private RailwayCar[] railwayCars;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 15;

    /**
     * Default constructor that initializes the list with the initial capacity.
     */
    public RailwayCarList() {
        railwayCars = new RailwayCar[INITIAL_CAPACITY];
    }

    /**
     * Constructor that initializes the list and adds one RailwayCar.
     * @param railwayCar the RailwayCar object to add
     */
    public RailwayCarList(RailwayCar railwayCar) {
        this();
        this.add(railwayCar);
    }

    /**
     * Constructor that initializes the list with a collection of RailwayCar objects.
     * @param collection collection of RailwayCar objects to initialize the list
     */
    public RailwayCarList(Collection<? extends RailwayCar> collection) {
        railwayCars = new RailwayCar[Math.max(INITIAL_CAPACITY, collection.size())];
        addAll(collection);
    }

    /**
     * Increases the internal capacity of the list by 30% when needed.
     */
    private void increaseCapacity() {
        int increasedCapacity = (int) (railwayCars.length * 1.3);
        railwayCars = Arrays.copyOf(railwayCars, increasedCapacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(railwayCars[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(railwayCars[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(railwayCars, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(railwayCars, size, a.getClass());
        System.arraycopy(railwayCars, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public RailwayCar get(int index) {
        Objects.checkIndex(index, size);
        return railwayCars[index];
    }

    @Override
    public RailwayCar set(int index, RailwayCar element) {
        Objects.checkIndex(index, size);
        RailwayCar oldRailwayCar = railwayCars[index];
        railwayCars[index] = element;
        return oldRailwayCar;
    }

    @Override
    public boolean add(RailwayCar railwayCar) {
        if (size == railwayCars.length) {
            increaseCapacity();
        }
        railwayCars[size++] = railwayCar;
        return true;
    }

    @Override
    public void add(int index, RailwayCar element) {
        Objects.checkIndex(index, size + 1);
        if (size == railwayCars.length) {
            increaseCapacity();
        }
        System.arraycopy(railwayCars, index, railwayCars, index + 1, size - index);
        railwayCars[index] = element;
        size++;
    }

    @Override
    public RailwayCar remove(int index) {
        Objects.checkIndex(index, size);
        RailwayCar oldRailwayCar = railwayCars[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(railwayCars, index + 1, railwayCars, index, numMoved);
        }
        railwayCars[--size] = null;
        return oldRailwayCar;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends RailwayCar> c) {
        for (RailwayCar railwayCar : c) {
            add(railwayCar);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends RailwayCar> c) {
        Objects.checkIndex(index, size + 1);
        for (RailwayCar railwayCar : c) {
            add(index++, railwayCar);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            if (remove(o)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(railwayCars[i])) {
                remove(i--);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        Arrays.fill(railwayCars, 0, size, null);
        size = 0;
    }

    @Override
    public Iterator<RailwayCar> iterator() {
        return new Iterator<>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public RailwayCar next() {
                if (cursor >= size) {
                    throw new NoSuchElementException();
                }
                return railwayCars[cursor++];
            }
        };
    }

    @Override
    public ListIterator<RailwayCar> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<RailwayCar> listIterator(int index) {
        Objects.checkIndex(index, size + 1);
        return new ListIterator<>() {
            private int cursor = index;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public RailwayCar next() {
                if (cursor >= size) {
                    throw new NoSuchElementException();
                }
                return railwayCars[cursor++];
            }

            @Override
            public boolean hasPrevious() {
                return cursor > 0;
            }

            @Override
            public RailwayCar previous() {
                if (cursor <= 0) {
                    throw new NoSuchElementException();
                }
                return railwayCars[--cursor];
            }

            @Override
            public int nextIndex() {
                return cursor;
            }

            @Override
            public int previousIndex() {
                return cursor - 1;
            }

            @Override
            public void remove() {
                RailwayCarList.this.remove(--cursor);
            }

            @Override
            public void set(RailwayCar railwayCar) {
                RailwayCarList.this.set(cursor, railwayCar);
            }

            @Override
            public void add(RailwayCar railwayCar) {
                RailwayCarList.this.add(cursor++, railwayCar);
            }
        };
    }

    @Override
    public List<RailwayCar> subList(int fromIndex, int toIndex) {
        Objects.checkFromToIndex(fromIndex, toIndex, size);
        return new RailwayCarList(Arrays.asList(Arrays.copyOfRange(railwayCars, fromIndex, toIndex)));
    }
}
