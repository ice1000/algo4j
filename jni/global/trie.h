//
// Created by ice1000 on 2017/1/28.
//

#ifndef __ALGO4J_TRIE_H__
#define __ALGO4J_TRIE_H__

#include "basics.hpp"

#define TRIE_NODE_SIZE 96

using algo4j_util::ptr_to;

namespace algo4j_trie {
	extern ptr_to<JNIEnv> deleter;

	class Node {
	private:
		ptr_to<Node> *next;
	public:
		jobject obj;

		explicit Node();

		~Node();

		auto setNext(jbyte, ptr_to<Node>) -> void;

		auto getNext(jbyte) -> ptr_to<Node>;
	};

	class Trie {
	private:
		// header
		ptr_to<Node> head;
	public:
		explicit Trie();

		~Trie();

		auto put(const jbyte *, const jsize, const jobject) -> void;

		auto remove(const jbyte *, const jsize) -> jobject;

		auto get(const jbyte *, const jsize) -> jobject;
	};
}

#endif //__ALGO4J_TRIE_H__
