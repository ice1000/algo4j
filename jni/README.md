# About Jni library

As you see, I used both DEV-CPP and CLion right contribute the C++ codes.

## Code style

```c++
/// includes
#include "templates.hpp"  // there should be a space between filename and the word 'include'

// you should use 'using ns::func' instead of any other way to achieve same function.
using algo4j_util::swap;
using std::ostream;

/// classes
template<typename T1, typename T2>
class Pair {
public:
	T1 first;
	T2 second;

	// when there's nothing inside a pair of braces, put a space inside.
	Pair(const T1 &f, const T2 &s) :
		first(f),
		second(s) { }

	// explicit is necessary when there's zero or one params.
	explicit Pair() { }

	~Pair() { }

	// if a method can be constexpr, it's also necessary to declare it as one.
	// all-hail suffix return type
	constexpr auto operator<(const Pair &o) const -> const bool {
		return first == o.first ? second < o.second : first < o.first;
	}

	// optional
	friend auto operator<<(ostream &os, const Pair &pair) -> ostream& {
		os << "first: " << pair.first << " second: " << pair.second;
		return os;
	}
}

/// functions
template<typename T>
/// you should use suffix return type
auto bubble_sort (
		T *data,
		const jsize length) -> void {
	// try your best to use type-inference
	for (auto i = length - 1; i > 0; --i) {
		for (auto j = 0; j < i; ++j) {
			if (data[j] > data[i]) swap(data[i], data[j]);
		}
	}
}
// You have to declare suffix-return-type, like 'auto XXX(XXX xxx) -> type'.
// Mention that if there is something relevant to basic type like int, long or size_t,
// use JNI types like jint, jlong and jsize instead of them.
// if there's something that makes a line too long, you should start a new line as you see above.
// Functions with more than 2 parameters should follow format like the one above.

/// header files
namespace algo4j_bit {
	auto lowbit(const jlong) -> jlong;

	// no named params allowed
	auto add(
			jlong *,
			jint,
			jint,
			jlong
	) -> void;

	auto sum(
			jlong *,
			jint
	) -> jlong;
}

```

## Other rules

+ You can use math.h or string.h, but **NEVER** STL!
+ Don't use lambda expressions.
+ Put utility functions into [global/functions.cpp](./global/functions.cpp) or [global/templates.hpp](./global/templates.hpp)
+ Never let those so-called 'elegant' stuffs take unnecessary costs.

## Before building

Add `jni.h` and all other jni header files into your include path.

If you know Chinese well, view [This blog](http://ice1000.tech/2017/01/23/JNITutorial.html)

## Using command line

You can use CMake to build it. Simply follow 'CMakeLists.txt'.

## Using DEV-CPP(for Windows only)

if you're using 32 bit operating system, open `jni32.dev`, and `jni.dev` is for 64 bit users. <br/>
Then click to compile it.

## Using CLion

There is a CMakeLists.txt and a configuration file named `.idea` for CLion.<br/>
using CLion is much easier than other ways, and it's more recommended.
