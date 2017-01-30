//
// Created by ice1000 on 2017/1/28.
//

#include "trie.h"

using algo4j_trie::Node;
using algo4j_trie::Trie;

#define __goto_end_force(word) \
for (auto _ = 0; word[_]; ++_) { \
    if (now->getNext(word[_]) == nullptr) \
        now->setNext(word[_], new Node()); \
    now = now->getNext(word[_]); \
}

#define __goto_end_weak(word) \
for (auto _ = 0; word[_]; ++_) { \
    if (now->getNext(word[_]) == nullptr) \
        return false; \
    now = now->getNext(word[_]); \
}

algo4j_trie::Node::Node() : hasElement(false) {
	for (auto _ = 0; _ < (sizeof(next) / sizeof(next[0])); ++_) {
		next[0] = nullptr;
	}
}

algo4j_trie::Node::~Node() {
}

algo4j_trie::Trie::Trie() : head(new Node()) { }

algo4j_trie::Trie::~Trie() {
	delete head;
}

auto algo4j_trie::Trie::insert(const char *word) -> void {
	Node *now = head;
	__goto_end_force(word);
	now->hasElement = true;
}

auto algo4j_trie::Trie::exist(const char *word) -> bool {
	Node *now = head;
	__goto_end_weak(word);
	return now->hasElement;
}

auto Trie::getHead() const -> Node * {
	return head;
}

auto Trie::remove(const char *word) -> void {
	Node *now = head;
	__goto_end_force(word);
	now->hasElement = false;
}

auto algo4j_trie::Node::setNext(char sym, Node *newNode) -> void {
	next[sym == ' ' ? 26 : sym - 'a'] = newNode;
}

auto algo4j_trie::Node::getNext(char sym) -> Node * {
	return next[sym == ' ' ? 26 : sym - 'a'];
}
