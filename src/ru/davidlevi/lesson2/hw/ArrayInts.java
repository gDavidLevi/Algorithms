package ru.davidlevi.lesson2.hw;

import com.sun.istack.internal.NotNull;

/**
 * Урок 2. Массивы и сортировка
 * <p>
 * Аналог ArrayList<Integer>
 */
public class ArrayInts {
    private int[] array;
    private int quantity; // количество элементов в массиве, а не его реальный размер
    private boolean isSorted; // сортирован ли?

    /**
     * Конструктор
     */
    private ArrayInts() {
        isSorted = false;
    }

    /**
     * Конструктор
     *
     * @param size размер массива
     */
    ArrayInts(int size) {
        this(); // конструктор без параметров
        this.quantity = 0;
        this.array = new int[size];
    }

    /**
     * Конструктор
     *
     * @param args int...
     */
    public ArrayInts(int... args) {
        this();
        this.quantity = args.length;
        this.array = args; // аналогично this.array = new int[args.length];
    }

    /**
     * Длинна массива
     *
     * @return int
     */
    public int length() {
        return this.quantity;
    }

    /**
     * Отсортирован ли массив?
     *
     * @return boolean
     */
    public boolean isSorted() {
        return this.isSorted;
    }

    /**
     * Возвращает элемент по индексу
     *
     * @param index int
     * @return int
     */
    public int get(int index) {
        if (index < 0 || index >= quantity)
            throw new ArrayIndexOutOfBoundsException("WTF!");
        return array[index];
    }

    /**
     * Устанавливает значение по индексу
     *
     * @param index int
     * @param value int
     */
    public void set(int index, int value) {
        if (index < 0 || index >= quantity)
            throw new ArrayIndexOutOfBoundsException("WTF!");
        array[index] = value;
    }

    /**
     * Преобразование в строку
     *
     * @return String
     */
    @Override
    public String toString() {
        int iMax = quantity - 1;
        if (iMax == -1) return "[]";
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; ; i++) {
            builder.append(array[i]);
            if (i == iMax)
                return builder.append(']').toString();
            builder.append(", ");
        }
    }

    /**
     * Добавляет значение в массив
     *
     * @param value int
     */
    public void append(int value) {
        // Если не хватает места в массиве для добавления элемента, то...
        if (quantity >= array.length - 1) {
            int[] temp = array; // копируем (сохраняем) текущий массив в temp
            array = new int[quantity * 2]; // создаем новый массив двойного размера
            System.arraycopy(temp, 0, array, 0, quantity); // копирование значений из temp в array (int[quantity * 2])
        }
        array[quantity++] = value; // добавлем уже само значение
    }

    /**
     * Удалить последний элемент
     *
     * @return boolean
     */
    public boolean remove() {
        if (quantity == 0) return false;
        this.quantity--; // уменьшаем количество элементов в массиве
        return true;
    }

    /**
     * Есть ли элемент внутри массива?
     * Линейный поиск.
     *
     * @param value int
     * @return boolean
     */
    public boolean isInArray(int value) {
        // Линейный поиск
        for (int i = 0; i < quantity; i++)
            if (array[i] == value) return true;
        return false;
    }

    /**
     * Поиск значения
     * (Бинарный поиск)
     *
     * @param value int
     * @return int
     */
    public int find(int value) {
        // Сначала массив должен быть отсортирован
        if (!isSorted)
            throw new RuntimeException("Попытка поиска в несортированном массиве");
        // Бинарный поиск
        int l = 0;
        int r = quantity;
        int m;
        while (l < r) {
            // k << n == k * 2 ^ n
            // k >> n == k / 2 ^ n
            m = (l + r) >> 1;        // 8 = 00001000 >> 2 = 00000010 = 2
            if (value == array[m]) {
                return m;
            } else {
                if (value < array[m]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }

    /**
     * Обмен значений
     *
     * @param a int
     * @param b int
     */
    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * Пузырьковая сортировка
     */
    public void sortBubble() {
        for (int i = 0; i < quantity; i++) {
            for (int j = 0; j < quantity - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
        isSorted = true; // наш массив осортирован
    }

    /**
     * Сортировка перемешиванием или улучшенная Пузырьковая сортировка
     * Сложность: O(n), в худшем случае O(n^2) если сортировка в обратном порядке
     */
    public void cocktailSort() {
        int left = 0;
        int right = quantity - 1;
        do {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                }
            }
            left++;
        } while (left < right);
    }

    /**
     * Метод меняет местами значения элементов массива
     *
     * @param array  @NotNull int[]
     * @param first  int
     * @param second int
     */
    private void swap(@NotNull int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * Сортировка подсчётом
     */
    public void countingSort() {
        int minElement = min();
        int maxElement = max();
        // Создание копии
        int[] tempArray = new int[quantity];
        System.arraycopy(array, 0, tempArray, 0, quantity);
        // Сортировка
        for (int element : tempArray) {
            if (element < minElement) {
                minElement = element;
            }
            if (element > maxElement) {
                maxElement = element;
            }
        }
        int[] buckets = new int[maxElement - minElement + 1];
        for (int element : tempArray) {
            buckets[element - minElement]++;
        }
        int arrayIndex = 0;
        for (int i = 0; i < buckets.length; i++)
            for (int j = buckets[i]; j > 0; j--) {
                tempArray[arrayIndex++] = i + minElement;
            }
        // Вернуть результат
        array = tempArray;
    }

    /**
     * Поиск минимального элемента в массиве
     *
     * @return int
     */
    public int min() {
        if (array.length > 0) {
            int min = array[0];
            for (int i = 0; i < quantity; i++) {
                if (array[i] < min)
                    min = array[i];
            }
            return min;
        } else throw new RuntimeException("Пустой массив");
    }

    /**
     * Поиск максимального элемента в массиве
     *
     * @return int
     */
    public int max() {
        if (array.length > 0) {
            int max = array[0];
            for (int i = 0; i < quantity; i++) {
                if (array[i] > max)
                    max = array[i];
            }
            return max;
        } else throw new RuntimeException("Пустой массив");
    }

    /**
     * Сортировка методом выбора
     */
    public void sortSelect() {
        int f;
        for (int i = 0; i < quantity; i++) {
            f = i;
            for (int j = i + 1; j < quantity; j++)
                if (array[j] < array[f]) {
                    f = j;
                }
            swap(i, f);
        }
        isSorted = true; // наш массив осортирован
    }

    /**
     * Сортировка вставками
     */
    public void sortInsert() {
        for (int i = 1; i < quantity; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
        isSorted = true;
    }


    //todo homework

    /**
     * Удаление элемента массива по индексу
     *
     * @param index int
     * @return boolean
     */
    public boolean delete(int index) {
        if (index >= quantity)
            return false;
        int[] tempArray = array;
        int tempArraySize = quantity;
        int resultSize = tempArraySize - 1;
        int[] result = new int[resultSize];
        int indexResult = 0;
        for (int i = 0; i < tempArraySize; i++)
            if (i != index) {
                result[indexResult] = tempArray[i];
                indexResult++;
            }
        array = result;
        quantity = resultSize;
        return true;
        /*
        // или
            if (index >= quantity || index < 0)
                throw new ArrayIndexOutOfBoundsException("" + index);
            System.arraycopy(array, index + 1, array, index, quantity - index - 1);
            quantity--;
            return true;
         */
    }

    /**
     * Удаление всех элементов со значением
     *
     * @param value int
     * @return boolean
     */
    public boolean deleteAll(int value) {
        boolean responce = false;
        int[] temp = array;
        int tempArraySize = quantity;
        int resultSize = tempArraySize - 1;
        int[] result = new int[resultSize];
        int indexResult = 0;
        for (int i = 0; i < tempArraySize; i++) {
            if (temp[i] != value) {
                result[indexResult] = temp[i];
                indexResult++;
            }
        }
        array = result;
        quantity = resultSize;
        sortBubble();
        if (find(value) == -1)
            responce = true;
        return responce;
        /*
        // или
            boolean success = false;
            for (int i = 0; i < size; i++) {
                if (arr[i] == value) {
                    delete(i);
                    i--;
                    success = true;
                }
            }
            return success;
         */
    }

    /**
     * Удалить все элементы
     *
     * @return boolean
     */
    public boolean deleteAll() {
        quantity = 0;
        return true;
    }
}
