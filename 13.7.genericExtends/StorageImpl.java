public class StorageImpl<T> implements Storage137<T> {

  private T[] array;

  public StorageImpl(int capacity) {
    array = (T[]) (new Object[capacity]);
  }

  @Override
  public void add(T item, int index) {
    array[index] = item;
  }

  @Override
  public T get(int index) {
    return array[index];
  }

}
