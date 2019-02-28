//
// Created by Phosphorus15 on 2019/2/26.
//

#ifndef JNI_SEGTREE_H
#define JNI_SEGTREE_H

namespace SegtreeUtil {

    template<typename T>
    inline auto select(T a, T b, int mode) -> T {
        if (mode == 0) return (a > b) ? a : b;
        else if (mode == 1) return (a > b) ? b : a;
        else return (a + b);
    }

    auto set(jint x, jint value, jint length, jint *segments, jint mode) -> void {
        segments[length + x] = value;
        x >>= 1;
        for (; x >= 1; x >>= 1) {
            segments[x] = SegtreeUtil::select(segments[x << 1], segments[x << 1 | 1], mode);
        }
    }

    auto query(jint mode, jint l, jint r, jint *segments, jint length) -> jint {
        jint ans = 0;
        if (l == r) return segments[l];
        l += length;
        r += length;
        jint limit = 1;
        while (limit <= length << 1) limit <<= 1;
        limit >>= 1;
        if (limit <= r && l < limit)
            ans = select(query(mode, limit - length, r - length, segments, length),
                         query(mode, l - length, limit - 1 - length, segments, length),
                         mode);
        else {
            ans = SegtreeUtil::select(segments[l], segments[r], mode);
            for (; l ^ r ^ 1; l >>= 1, r >>= 1) {
                if ((~l) & 1 && l != 1) ans = select(segments[l ^ 1], ans, mode);
                if (r & 1 && r != 1) ans = select(segments[r ^ 1], ans, mode);
            }
        }
        return ans;
    }
}

#endif //JNI_SEGTREE_H
