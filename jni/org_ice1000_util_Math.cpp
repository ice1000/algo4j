///
/// Created by ice1000 on 2016/11/16.
///

#include "org_ice1000_util_Math.h"
#include "org_ice1000_public_functions.h"

using namespace ice1000_math;

/**
 * Class:     org_ice1000_util_Math
 * Method:    gcd
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_org_ice1000_util_Math_gcd(
		JNIEnv *env,
		jclass jc,
		jlong a,
		jlong b) {
	return gcd(a, b);
}

/**
 * Class:     org_ice1000_util_Math
 * Method:    sqrt
 * Signature: (D)D
 */
JNIEXPORT jdouble JNICALL Java_org_ice1000_util_Math_sqrt(
		JNIEnv *env,
		jclass jc,
		jdouble a) {
	return sqrt(a);
}
