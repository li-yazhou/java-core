package org.alpha.javabase.javaprimer.javaprimer_code.chap17_Collection.src.cn.itcast.p2.linkedlist.test;

import java.util.LinkedList;

public class DuiLie {
	private LinkedList link;

	public DuiLie() {
		link = new LinkedList();
	}

	/**
	 * ���е����Ԫ�صĹ��ܡ�
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
