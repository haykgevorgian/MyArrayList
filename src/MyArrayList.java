import java.util.*;

class MyArrayList<E> implements List<E> {
    private int arraySize;
    private int capacity = 10;
    private Object[] array;
    public MyArrayList() {
        array = new Object[capacity];
    }

    public MyArrayList(int s) {
        while(s > capacity) {
            capacity *= 2;
        }
        array = new Object[capacity];
    }
    @Override
    public boolean add(E element) {
        if(arraySize >= capacity) {
            capacity *= 2;
            Object[] otherArray = new Object[capacity];
            for(int i = 0; i < arraySize; i++) {
                otherArray[i] = this.get(i);
            }
            array = otherArray;
        }
        set(arraySize++,element);
        return true;
    }
    @Override
    public void add(int index, E element) {
        if(arraySize >= capacity) {
            capacity *= 2;
        }
        Object[] otherArray = new Object[capacity];
        for(int i = 0; i < index; i++) {
            otherArray[i] = get(i);
        }
        for(int i = size(); i > index; i--) {
            otherArray[i] = get(i - 1);
        }
        otherArray[index] = element;
        array = otherArray;
        arraySize++;
    }
    @Override
    public E get(int index) {
        return (E) array[index];
    }
    @Override
    public E set(int index, E element) {
        E temp = get(index);
        array[index] = element;
        return temp;
    }
    @Override
    public boolean remove(Object element) {
        for(int i = 0; i < size(); i++) {
            if(element == get(i)) {
                for(int j = i; j < size() - 1; j++) {
                    set(j,get(j + 1));
                }
                arraySize--;
                return true;
            }
        }
        return false;
    }
    @Override
    public E remove(int index) {
        E temp = get(index);
        for(int j = index; j < size() - 1; j++) {
            set(j,get(j + 1));
        }
        arraySize--;
        return temp;
    }
    @Override
    public int size() {
        return arraySize;
    }
    @Override
    public boolean isEmpty() {
        return arraySize == 0;
    }
    @Override
    public boolean contains(Object o) {
        for(Object x : array) {
            if(x == o) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < arraySize; i++) {
            if(get(i) == o) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object o) {
        for(int i = arraySize - 1; i >= 0; i--) {
            if(get(i) == o) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public void clear() {
        for(int i = 0; i < arraySize; i++) {
            set(i,null);
        }
        arraySize = 0;
    }
    @Override
    public Object[] toArray() {
        Object[] otherArray = new Object[arraySize];
        for(int i = 0; i < size(); i++){
            otherArray[i] = get(i);
        }
        return otherArray;
    }
    @Override
    public <T> T[] toArray(T[] array){
        if(array.length >= size()) {
            for(int i = 0; i < size(); i++) {
                array[i] = (T) this.array[i];
            }
            return array;
        }
        else {
            T[] newArray = (T[]) new Object[size()];
            for (int i = 0; i < size(); i++) {
                newArray[i] = (T) this.array[i];
            }
            return newArray;
        }
    }
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        List<E> otherList = new MyArrayList<>(toIndex - fromIndex);
        for(int i = fromIndex; i < toIndex; i++) {
            otherList.add(get(i));
        }
        return otherList;
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for(int i = 0; i < arraySize; i ++) {
            if(c.contains(array[i])){
                modified = true;
                remove(array[i]);
                i--;
            }
        }
        return modified;
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for(int i = 0; i < arraySize; i ++) {
            if(!c.contains(array[i])){
                modified = true;
                remove(array[i]);
                i--;
            }
        }
        return modified;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object element : c) {
            if(!this.contains(element)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        for(E element : c) {
            add(element);
        }
        return true;
    }
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean modified = false;
        E[] e = (E[]) c.toArray();
        for(E element : e) {
            add(index,element);
            index++;
            modified = true;
        }
        return modified;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MyArrayList<?>){
            MyArrayList<E> element = (MyArrayList<E>) obj;
            if(size() != element.size()) {
                return false;
            }
            for(int i = 0; i < size(); i++) {
                if(element.get(i) != this.get(i))
                    return false;
            }
            return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(arraySize, arraySize);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
    @Override
    public String toString() {
        if(arraySize == 0) {
            return "[ ]";
        }
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < arraySize - 1; i++) {
            sb.append(" ").append(array[i]).append(",");
        }
        sb.append(" ").append(array[arraySize - 1]).append("]");
        return sb.toString();
    }



    @Override
    public Iterator<E> iterator() {
        Iterator<E> iter = new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
        return iter;
    }
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }
}
