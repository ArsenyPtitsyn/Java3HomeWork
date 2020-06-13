package lesson1;

public class GenericArrayChanger<T> {

    private T[] array;

    public GenericArrayChanger(T... array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public void changeElements(int k, int l) {
        T temp;
        if (k < array.length && l < array.length) {
            temp = array[k];
            array[k] = array[l];
            array[l] = temp;
        }
        else
            System.out.println("Too big index(es)!");
    }
}
