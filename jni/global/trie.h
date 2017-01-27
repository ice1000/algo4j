//
// Created by ice1000 on 2017/1/28.
//

#ifndef __ALGO4J_TRIE_H__
#define __ALGO4J_TRIE_H__

#include <jni.h>
#include "basics.hpp"

namespace algo4j_trie {

	struct Node {
	private:
		// alpha bet and space
		Node *next[27];
		typedef Node *node_ptr;
	public:
		bool hasElement;

		Node() : hasElement(false) {}

		auto setNext(char sym, Node *newNode) -> void {
			if (sym == ' ') next[26] = newNode;
			else next[sym - 'a'] = newNode;
		}
	};

	auto make_node() -> Node * {
		return new Node();
	}
}

#endif //__ALGO4J_TRIE_H__
