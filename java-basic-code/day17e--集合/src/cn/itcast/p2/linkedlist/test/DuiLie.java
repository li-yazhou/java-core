package cn.itcast.p2.linkedlist.test;

import java.util.LinkedList;

public class DuiLie {
	private LinkedList link;

	public DuiLie() {
		link = new LinkedList();
	}

	/**
	 * 队列的添加元素的功能。
	 */
	public void myAdd(Object obj) {
		link.addLast(obj);
	}

	public Object myGet() {
		return link.removeFirst();
	}

	public boolean isNull() {
		return link.isEmpty();
	}
}
