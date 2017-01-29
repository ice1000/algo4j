//
// Created by ice1000 on 2017/1/28.
//

#ifndef __ALGO4J_TRIE_H__
#define __ALGO4J_TRIE_H__

#include <jni.h>
#include <string.h>
#include "basics.hpp"

namespace algo4j_trie {

	typedef Node *node_ptr;

	struct Node {
	private:
		// alpha bet and space
		node_ptr next[27];
	public:
		bool hasElement;

		explicit Node();

		~Node();

		constexpr auto setNext(char sym, node_ptr newNode = new Node()) -> void;

		constexpr auto get(char sym) -> node_ptr;
	};

	constexpr auto make_node() -> Node *;

	struct Trie {
	private:
		node_ptr head;
	public:
		explicit Trie();

		~Trie();

		auto insert(char *word) -> void;

		auto exist(char *word) -> bool;
	};
}

#endif //__ALGO4J_TRIE_H__
