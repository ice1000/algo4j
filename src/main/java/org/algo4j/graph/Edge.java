package org.algo4j.graph;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * Created by ice1000 on 2017/1/8.
 *
 * @author ice1000
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public class Edge implements
		Cloneable,
		Serializable {
	public final int target;
	public final int depart;
	public final int value;

	@Contract(pure = true)
	public Edge(int target, int depart, int value) {
		this.target = target;
		this.depart = depart;
		this.value = value;
	}

	@Contract(pure = true)
	public Edge(int target, int depart) {
		this(target, depart, 1);
	}

	@Contract(pure = true)
	public int getTarget() {
		return target;
	}

	@Contract(pure = true)
	public int getDepart() {
		return depart;
	}

	@Contract(pure = true)
	public int getValue() {
		return value;
	}

	@Override
	@NotNull
	@Contract(value = " -> !null", pure = true)
	public Edge clone() {
		return new Edge(target, depart, value);
	}
}
