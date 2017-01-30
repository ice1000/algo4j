package org.algo4j.tree.segtree;

/**
 * Created by Phosphorus15 on 2017/1/30.
 */
@SuppressWarnings("WeakerAccess")
public interface SegmentTree {
    int query(int l, int r, QueryType query);

    int update(int l, int r, int increment);

    int set(int l, int r, int value);

    int size();
}
