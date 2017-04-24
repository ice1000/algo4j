//
// header for BigInt class
//

#include "jni.h"

//#include <iostream>

#ifndef __BIG_INT_H__
#define __BIG_INT_H__

//using std::istream;
//using std::ostream;

namespace algo4j_int {
	class BigInt {
	public:
		jbyte *data;
		jsize len;

		explicit BigInt(jbyte *_data, jsize _len);

//		friend auto operator<<(ostream &os, const BigInt &o) -> ostream &;
//
//		friend auto operator>>(istream &is, BigInt &o) -> istream &;
	};

	auto compare(
			const jbyte *a,
			const jbyte *b,
			const jsize a_len,
			const jsize b_len
	) -> jint;

	auto plus(
			jbyte *a,
			jbyte *b,
			jsize a_len,
			jsize b_len
	) -> BigInt *;

	auto minus(
			jbyte *a,
			jbyte *b,
			jsize a_len,
			jsize b_len
	) -> BigInt *;

	auto times(
			jbyte *a,
			jbyte *b,
			jsize a_len,
			jsize b_len
	) -> BigInt *;

	auto times_bf(
			jbyte *a,
			jbyte *b,
			jsize a_len,
			jsize b_len
	) -> BigInt *;

	auto divide(
			jbyte *a,
			jbyte *b,
			jsize a_len,
			jsize b_len
	) -> BigInt *;
}

#endif /// __BIG_INT_H__

