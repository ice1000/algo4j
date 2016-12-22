//
// header for BigInt class
//

#include <jni.h>

#include <iostream>

#ifndef __BIG_INT_H__
#define __BIG_INT_H__

using std::istream;
using std::ostream;


namespace algo4j_int {
	auto compare(jbyte *a, jbyte *b, jsize a_len, jsize b_len) -> jsize;

	class BigInt {
	public:
		jbyte *data;
		jsize len;

		explicit BigInt(jbyte *_data, jsize _len);

		~BigInt() {
			delete data;
		}

		auto operator+(const BigInt &o) const -> const BigInt &;

		auto operator-(const BigInt &o) const -> const BigInt &;

		auto operator*(const BigInt &o) const -> const BigInt &;

		auto operator/(const BigInt &o) const -> BigInt &;

		auto operator[](const jsize index) const -> jbyte;

		auto operator<(const BigInt &o) const -> const bool;

		auto operator==(const BigInt &o) const -> const bool;

		auto operator<=(const BigInt &o) const -> const bool;

		auto operator>(const BigInt &o) const -> const bool;

		auto operator>=(const BigInt &o) const -> const bool;

		auto operator!=(const BigInt &o) const -> const bool;

		auto times_10() -> BigInt &;

		friend auto operator<<(ostream &os, const BigInt &o) -> ostream &;

		friend auto operator>>(istream &is, BigInt &o) -> istream &;	};
}

#endif /// __BIG_INT_H__

