import java.util.*;

/**
 * Реалізація типізованої колекції на базі двозв'язного списку.
 *
 * @param <T> Тип об'єктів у колекції.
 */
public class LinkedListAircraft<T> implements List<T> {
    /**
     * Вузол двозв'язного списку.
     * Кожен вузол містить дані і посилання на попередній та наступний вузли.
     *
     * @param <E> Тип даних у вузлі.
     */
    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    // Посилання на елементи списку та кількість
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Конструктори

    /**
     * Конструктор за замовчуванням для створення порожнього списку.
     */
    public LinkedListAircraft() {
        head = tail = null;
        size = 0;
    }

    /**
     * Конструктор для створення списку з одного елемента.
     *
     * @param element Елемент для додавання в список.
     */
    public LinkedListAircraft(T element) {
        this();
        add(element);
    }

    /**
     * Конструктор для створення списку з іншої колекції.
     *
     * @param collection Колекція елементів для додавання.
     */
    public LinkedListAircraft(Collection<? extends T> collection) {
        this();
        addAll(collection);
    }

    // Основні методи List
    /**
     * Повертає кількість елементів у списку.
     *
     * @return Розмір списку.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Перевіряє, чи порожній список.
     *
     * @return true, якщо список порожній, інакше false.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Перевіряє, чи міститься елемент у списку.
     *
     * @param o Елемент для пошуку.
     * @return true, якщо елемент знайдений, інакше false.
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * Повертає ітератор для проходження по списку.
     *
     * @return Ітератор для списку.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (current == null) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Повертає масив, що містить всі елементи списку.
     *
     * @return Масив, що містить елементи списку.
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (Node<T> current = head; current != null; current = current.next) {
            array[index++] = current.data;
        }
        return array;
    }


    /**
     * Повертає типізований масив, що містить всі елементи списку.
     *
     * @param a Масив, в який будуть записані елементи списку.
     * @param <E> Тип елементів масиву.
     * @return Типізований масив з елементами списку.
     */
    @Override
    public <E> E[] toArray(E[] a) {
        if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        int index = 0;
        Object[] result = a;
        for (Node<T> current = head; current != null; current = current.next) {
            result[index++] = current.data;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    /**
     * Додає елемент до кінця списку.
     *
     * @param t Елемент для додавання.
     * @return true, якщо елемент успішно додано.
     */
    @Override
    public boolean add(T t) {
        Node<T> newNode = new Node<>(t);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * Видаляє перше входження елемента зі списку.
     *
     * @param o Елемент для видалення.
     * @return true, якщо елемент був видалений.
     */
    @Override
    public boolean remove(Object o) {
        for (Node<T> current = head; current != null; current = current.next) {
            if (Objects.equals(current.data, o)) {
                unlink(current);
                return true;
            }
        }
        return false;
    }

    /**
     * Перевіряє, чи містить список всі елементи з колекції.
     *
     * @param c Колекція елементів для перевірки.
     * @return true, якщо всі елементи містяться в списку.
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) return false;
        }
        return true;
    }

    /**
     * Додає всі елементи з іншої колекції до списку.
     *
     * @param c Колекція елементів для додавання.
     * @return true, якщо елементи були успішно додані.
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Метод не підтримується.");
    }

    /**
     * Видаляє всі елементи зі списку, що є в іншій колекції.
     *
     * @param c Колекція елементів для видалення.
     * @return true, якщо елементи були видалені.
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            modified |= remove(o);
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Метод не підтримується.");
    }

    /**
     * Очищає список, видаляючи всі елементи.
     */
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * Повертає елемент за заданим індексом.
     *
     * @param index Індекс елемента.
     * @return Елемент за індексом.
     */
    @Override
    public T get(int index) {
        return nodeAt(index).data;
    }

    /**
     * Замінює елемент за заданим індексом.
     *
     * @param index Індекс елемента.
     * @param element Новий елемент.
     * @return Старий елемент.
     */
    @Override
    public T set(int index, T element) {
        Node<T> targetNode = nodeAt(index);
        T oldValue = targetNode.data;
        targetNode.data = element;
        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException("Метод не підтримується.");
    }

    @Override
    public T remove(int index) {
        Node<T> targetNode = nodeAt(index);
        T data = targetNode.data;
        unlink(targetNode);
        return data;
    }

    /**
     * Повертає індекс першого входження елемента.
     *
     * @param o Елемент для пошуку.
     * @return Індекс елемента, або -1, якщо елемент не знайдений.
     */
    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (Node<T> current = head; current != null; current = current.next) {
            if (Objects.equals(current.data, o)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = size - 1;
        for (Node<T> current = tail; current != null; current = current.prev) {
            if (Objects.equals(current.data, o)) {
                return index;
            }
            index--;
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Метод не підтримується.");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Метод не підтримується.");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Метод не підтримується.");
    }

    // Допоміжні методи

    /**
     * Допоміжний метод для отримання вузла за індексом.
     *
     * @param index Індекс вузла.
     * @return Вузол за індексом.
     */
    private Node<T> nodeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = (index < size / 2) ? head : tail;
        int currentIndex = (index < size / 2) ? 0 : size - 1;
        while (currentIndex != index) {
            current = (index < size / 2) ? current.next : current.prev;
            currentIndex += (index < size / 2) ? 1 : -1;
        }
        return current;
    }

    /**
     * Видаляє вузол з двозв'язного списку.
     *
     * @param node Вузол, який потрібно видалити.
     */
    private void unlink(Node<T> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        size--;
    }
}