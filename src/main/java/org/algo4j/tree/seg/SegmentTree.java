package org.algo4j.tree.seg;

import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.Contract;

/**
 * Created by Phosphorus15 on 2019/2/23.
 *
 * @author Phosphorus15
 */
public interface SegmentTree<T> {

	@Flow(sourceIsContainer = true)
	@Contract(pure = true)
	T query(int l, int r);

	@Contract(pure = true)
	void set(int l, int r, T value);

	@Contract(pure = true)
	int size();

}
