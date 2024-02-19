package ch.unifr.algo2023.teacher.fundamentals;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<T> implements IStack<T> {
	private T[] array;
	private int count;

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		array = (T[]) new Object[4];
		count = 0;
	}

	@Override
	public void push(T element) {
		if (count == array.length) {
			array = Arrays.copyOf(array, array.length * 2);
		}
		array[count] = element;
		count++;
	}

	@Override
	public T peek() {
		return array[count - 1];
	}

	@Override
	public T pop() {
		T elem = array[count - 1];
		array[count - 1] = null;
		count--;

		if (count < array.length / 4) {
			array = Arrays.copyOf(array, array.length / 2);
		}

		return elem;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<>() {

			private int posIter = 0;

			@Override
			public boolean hasNext() {
				return posIter < count;
			}

			@Override
			public T next() {
				T item = array[posIter];
				posIter++;
				return item;
			}
		};
	}

}
