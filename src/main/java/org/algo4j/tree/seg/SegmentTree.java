package org.algo4j.tree.seg;

import org.jetbrains.annotations.Contract;

/**
 * Created by Phosphorus15 on 2017/1/30.
 *
 * @author Phosphorus15
 */
@SuppressWarnings("WeakerAccess")
public interface SegmentTree {
	@Contract(pure = true)
	int queryMin(int l, int r);

	@Contract(pure = true)
	int queryMax(int l, int r);

	@Contract(pure = true)
	int querySum(int l, int r);

	int update(int l, int r, int increment);

	int set(int l, int r, int value);

	@Contract(pure = true)
	int size();
}
