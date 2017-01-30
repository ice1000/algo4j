//
// Created by ice1000 on 2017/1/28.
//

#ifndef __ALGO4J_TRIE_H__
#define __ALGO4J_TRIE_H__

#include <jni.h>

namespace algo4j_trie {

	struct Node {
	private:
		// alpha bet and space
		Node *next[27];
	public:
		bool hasElement;

		explicit Node();

		~Node();

		auto setNext(jbyte, Node *) -> void;

		auto getNext(jbyte) -> Node *;
	};

	struct Trie {
	private:
		// header
		Node *head;
	public:
		explicit Trie();

		~Trie();

		auto insert(const jbyte *word) -> void;

		auto remove(const jbyte *word) -> void;

		auto exist(const jbyte *word) -> bool;

		auto existPrefix(const jbyte *word) -> bool;

		auto getHead() const -> Node *;
	};
}

#endif //__ALGO4J_TRIE_H__
