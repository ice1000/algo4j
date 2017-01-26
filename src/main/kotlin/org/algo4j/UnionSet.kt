@file:JvmMultifileClass
@file:JvmName("Extension")

/**
 * Created by ice1000 on 2017/1/4.
 *
 * @author ice1000
 */
package org.algo4j

import org.algo4j.tree.UnionSet
import org.jetbrains.annotations.Contract

@Contract(pure = false)
operator fun UnionSet.get(index: Int) =
		find(index)
