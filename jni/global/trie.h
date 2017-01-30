//
// Created by ice1000 on 2017/1/28.
//

#ifndef __ALGO4J_TRIE_H__
#define __ALGO4J_TRIE_H__

#include <jni.h>
#include <string.h>
#include "basics.hpp"

namespace algo4j_trie {

	struct Node {
	private:
		// alpha bet and space
		Node *next[27];
	public:
		bool hasElement;

		explicit Node();

		~Node();

		auto setNext(char, Node *) -> void;

		auto getNext(char) -> Node *;
	};

	struct Trie {
	private:
		// header
		Node *head;
	public:
		explicit Trie();

		~Trie();

		auto insert(const char *word) -> void;

		auto remove(const char *word) -> void;

		auto exist(const char *word) -> bool;

		auto existPrefixi(const char *word) -> bool {
			Node *now = head;
			for (auto _ = 0; word[_]; ++_) {
				if (now->getNext(word[_]) == nullptr)
					return false;
				now = now->getNext(word[_]);
			}
			return true;
		}

		auto getHead() const -> Node *;
	};
}

#endif //__ALGO4J_TRIE_H__
