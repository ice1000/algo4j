//
// Created by ice1000 on 2017/1/28.
//

#include "trie.h"
#include <stdio.h>

using algo4j_trie::Node;
using algo4j_trie::Trie;

#define __goto_end_force(word) \
for (auto _ = 0; _ < len; ++_) { \
    if (now->getNext(word[_]) == nullptr) \
        now->setNext(word[_], new Node()); \
    now = now->getNext(word[_]); \
}

#define __goto_end_weak(word) \
for (auto _ = 0; _ < len; ++_) { \
    if (now->getNext(word[_]) == nullptr) \
        return false; \
    now = now->getNext(word[_]); \
}

#define __index(sym) ((sym) - 32)

algo4j_trie::Node::Node() : hasElement(false) {
	for (auto _ = 0; _ < (sizeof(next) / sizeof(next[0])); ++_) {
		next[0] = nullptr;
	}
}

algo4j_trie::Node::~Node() {
}

algo4j_trie::Trie::Trie() : head(new Node[96]()) {}

algo4j_trie::Trie::~Trie() {
	delete head;
}

auto algo4j_trie::Trie::insert(const jbyte *word, const jsize len) -> void {
	Node *now = head;
	__goto_end_force(word);
	now->hasElement = true;
}

auto algo4j_trie::Trie::exist(const jbyte *word, const jsize len) -> bool {
	Node *now = head;
	__goto_end_weak(word);
	return now->hasElement;
}

auto algo4j_trie::Trie::existPrefix(const jbyte *word, const jsize len) -> bool {
	Node *now = head;
	__goto_end_weak(word);
	return true;
}

auto Trie::getHead() const -> Node * {
	return head;
}

auto Trie::remove(const jbyte *word, const jsize len) -> void {
	Node *now = head;
	__goto_end_force(word);
	now->hasElement = false;
}

auto algo4j_trie::Node::setNext(jbyte sym, Node *newNode) -> void {
	printf("%d\n", __index(sym));
	next[__index(sym)] = newNode;
}

auto algo4j_trie::Node::getNext(jbyte sym) -> Node * {
	printf("%d\n", __index(sym));
	return next[__index(sym)];
}

#undef __index
#undef __goto_end_force
#undef __goto_end_weak



