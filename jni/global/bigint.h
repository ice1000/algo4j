//
// header for BigInt class
//

#include "jni.h"

#ifndef __BIG_INT_H__
#define __BIG_INT_H__

//using std::istream;
//using std::ostream;

namespace algo4j_int {
	inline auto head_offset(
			jbyte *a,
			jsize len
	) -> jsize;

	class BigInt {
	private:
		jbyte *data;
		jsize len;
		jsize offset;

	public:
		explicit BigInt(jbyte *_data, jsize _len);

		explicit BigInt(const char *_data, jsize _len);

		BigInt(const BigInt &) = delete;

		BigInt(BigInt &&) = delete;

		auto operator=(const BigInt &) -> BigInt & = delete;

		auto operator=(BigInt &&) -> BigInt & = delete;

		auto data_trim() -> jbyte *;

		auto len_trim() -> jsize;
	};

	auto compare(
			jbyte *a,
			jbyte *b,
			jsize a_len,
			jsize b_len
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

	auto rem(
			jbyte *a,
			jbyte *b,
			jsize a_len,
			jsize b_len
	) -> BigInt *;

}

#endif /// __BIG_INT_H__

