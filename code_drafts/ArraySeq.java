package org.algo4j.collections;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Created by ice1000 on 2017/1/4.
 *
 * @author ice1000
 */
@SuppressWarnings("WeakerAccess")
public class ArraySeq<T> implements Seq<T> {
	private int header;
	private int length;
	private int maxSize;

	public static final int INITiAL_LENGTH = 0x5;

	public ArraySeq() {
		header = getInitPtr();
		length = 0;
		maxSize = INITiAL_LENGTH;
	}

	private static native int getInitPtr();

	private static native void setElement(int header, int offset, Object val);

	private static native void expandSize(int header, int currentSize);

	private static native Object[] getAll(int header, int length);

	@Override
	public int size() {
		return length;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(@NotNull Object o) {
		return false;
	}

	@NotNull
	@Override
	public Iterator<T> iterator() {
		return null;
	}

	@NotNull
	@Override
	public Object[] toArray() {
		return getAll(header, length);
	}

	@NotNull
	@Override
	public <T1> T1[] toArray(@NotNull T1[] a) {
		return (T1[]) getAll(header,length);
	}

	@Override
	public boolean add(T t) {
		setElement(header, length++, t);
		if (length >= maxSize) {
			expandSize(header, maxSize);
			maxSize <<= 1;
		}
		return true;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(@NotNull Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(@NotNull Collection<? extends T> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, @NotNull Collection<? extends T> c) {
		return false;
	}

	@Override
	public boolean removeAll(@NotNull Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(@NotNull Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {
	}

	@Override
	public T get(int index) {
		return null;
	}

	@Override
	public T set(int index, T element) {
		return null;
	}

	@Override
	public void add(int index, T element) {
	}

	@Override
	public T remove(int index) {
		return null;
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@NotNull
	@Override
	public ListIterator<T> listIterator() {
		return null;
	}

	@NotNull
	@Override
	public ListIterator<T> listIterator(int index) {
		return null;
	}

	@NotNull
	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return null;
	}
}
