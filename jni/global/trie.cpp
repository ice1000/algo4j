//
// Created by ice1000 on 2017/1/28.
//

#include "trie.h"

using algo4j_trie::node_ptr;

algo4j_trie::Node::Node() : hasElement(false) { }

algo4j_trie::Node::~Node() {
	delete[] next;
}

auto algo4j_trie::make_node() -> node_ptr {
	return new Node();
}

algo4j_trie::Trie::Trie() : head(make_node()) { }

algo4j_trie::Trie::~Trie() {
	delete head;
}

auto algo4j_trie::Trie::insert(char *word) -> void {
	node_ptr now = head;
	for (auto _ = 0; word[_]; ++_) {
		if (now->get(word[_]) == nullptr)
			now->setNext(word[_]);
		now = now->get(word[_]);
	}
}

auto algo4j_trie::Trie::exist(char *word) -> bool {
	node_ptr now = head;
	for (auto _ = 0; word[_]; ++_) {
		if (now->get(word[_]) == nullptr)
			return false;
	}
	return true;
}

auto algo4j_trie::Node::setNext(char sym, node_ptr newNode) -> void {
	next[sym == ' ' ? 26 : sym - 'a'] = newNode;
}

auto algo4j_trie::Node::get(char sym) -> node_ptr {
	return next[sym == '0' ? 26 : sym - 'a'];
}
