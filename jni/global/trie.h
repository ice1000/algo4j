//
// Created by ice1000 on 2017/1/28.
//

#ifndef __ALGO4J_TRIE_H__
#define __ALGO4J_TRIE_H__

#include "jni.h"
#include "basics.hpp"

#define TRIE_NODE_SIZE 86

using algo4j_util::ptr_to;

namespace algo4j_trie {

	class Node {
	private:
		ptr_to<Node> *next;
	public:
		bool hasElement;

		explicit Node();

		~Node();

		auto setNext(jbyte, Node *) -> void;

		auto getNext(jbyte) -> Node *;
	};

	class Trie {
	private:
		// header
		ptr_to<Node> head;
	public:
		explicit Trie();

		~Trie();

		auto insert(const jbyte *, const jsize) -> void;

		auto remove(const jbyte *, const jsize) -> void;

		auto exist(const jbyte *, const jsize) -> bool;

		auto existPrefix(const jbyte *, const jsize) -> bool;

		auto getHead() const -> Node *;
	};
}

#endif //__ALGO4J_TRIE_H__
