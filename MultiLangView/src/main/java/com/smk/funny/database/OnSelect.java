package com.smk.funny.database;

import java.util.List;

public interface OnSelect<E> {
	public E find(String arg0, String arg1);
	public E selectRecord(Integer arg0);
	public List<E> selectRecords();
	public List<E> selectRecords(String arg0);
	public List<E> selectRecords(E value);
}
