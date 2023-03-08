package datastruct;

import java.util.Arrays;

public class MyUnsortedList<E> implements UnsortedList<E> {

    private static class Link<E> {
        final E element;
        Link<E> next;

        private Link(E element) {
            this.element = element;
        }
    }

    private Link<E> head;
    private int size;

    private MyUnsortedList() {
        this.head = null;
        this.size = 0;
    }

    @SafeVarargs
    public static <E> MyUnsortedList<E> of(E... elements) {
        return of(Arrays.asList(elements));
    }

    public static <E> MyUnsortedList<E> of(Iterable<E> elements) {
        MyUnsortedList<E> list = new MyUnsortedList<>();
        for (E element : elements) {
            list.append(element);
        }
        return list;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void prepend(E element) {
        size++;
        Link<E> newHead = new Link<>(element);
        newHead.next = head;
        head = newHead;
    }

    @Override
    public void append(E element) {
        insert(element, size);
    }

    @Override
    public void insert(E elem, int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException();
        }
        if (pos == 0) {
            prepend(elem);
            return;
        }

        Link<E> prevLink = head;
        while (pos-- > 1) {
            prevLink = prevLink.next;
        }

        size++;
        Link<E> inserted = new Link<>(elem);
        Link<E> nextLink = prevLink.next;
        prevLink.next = inserted;
        inserted.next = nextLink;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyListException();
        }

        size--;
        Link<E> oldHead = head;
        head = oldHead.next;

        return oldHead.element;
    }

    @Override
    public E popLast() throws EmptyListException{
    	if (size == 0) {
    		throw new EmptyListException();
    	}
    	return remove(size - 1);
    }

    @Override
    public E remove(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (pos == 0) {
            return pop();
        }

        Link<E> prevLink = head;
        while (--pos > 0) {
            prevLink = prevLink.next;
        }

        Link<E> removed = prevLink.next;
        prevLink.next = removed.next;
        size--;
        return removed.element;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MyUnsortedList)) {
            return false;
        }

        @SuppressWarnings("unchecked")
        MyUnsortedList<E> that = (MyUnsortedList<E>) obj;
        if (this.size != that.size) {
            return false;
        }

        Link<E> thisLink = this.head;
        Link<E> thatLink = that.head;
        while (thisLink != null) {
            if (thatLink == null || (thisLink.element==null && thatLink.element!=null) || !thisLink.element.equals(thatLink.element)) {
                return false;
            }
            thisLink = thisLink.next;
            thatLink = thatLink.next;
        }

        return thatLink == null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("MyUnsortedList { size = ");
        builder.append(size);
        builder.append(", [");

        MyUnsortedList.Link<E> link = head;
        while (link != null) {
            builder.append(link.element);
            link = link.next;
            if (link != null) {
                builder.append(", ");
            }
        }

        return builder.append("] }").toString();
    }
}
