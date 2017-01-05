@file:JvmMultifileClass
@file:JvmName("Extension")

/**
 * Created by ice1000 on 2017/1/4.
 *
 * @author ice1000
 */
package org.algo4j

import org.algo4j.math.BigInt
import org.jetbrains.annotations.Contract

@Contract(pure = true)
operator fun BigInt.plus(o: BigInt) =
		plus(o)

@Contract(pure = true)
operator fun BigInt.minus(o: BigInt) =
		minus(o)

@Contract(pure = true)
operator fun BigInt.times(o: BigInt) =
		times(o)

@Contract(pure = true)
operator fun BigInt.div(o: BigInt) =
		divide(o)

@Contract(pure = true)
operator fun BigInt.mod(o: BigInt) =
		mod(o)

@Contract(pure = true)
operator fun BigInt.compareTo(o: BigInt) =
		compareTo(o)
