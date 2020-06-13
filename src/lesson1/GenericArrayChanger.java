package lesson1;

import java.util.ArrayList;

public class GenericArrayChanger<T> {

    private T[] array;

    public GenericArrayChanger(T... array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    /**
     * 1. Написать метод, который меняет два элемента массива местами.
     * (массив может быть любого ссылочного типа).
    */
    public void changeElements(int k, int l) {
        T temp;
        if (k < array.length && k >= 0 && l < array.length && l >= 0) {
            temp = array[k];
            array[k] = array[l];
            array[l] = temp;
        }
        else
            System.out.println("Index(es) out of bounds!");
    }

    /**
     * 2. Написать метод, который преобразует массив в ArrayList.
     * */
    public ArrayList<T> reorganizeToArrayList() {
        ArrayList<T> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
}
