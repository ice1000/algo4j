//
// Created by ice1000 on 2017/1/28.
//

#include "trie.h"
#include <string.h>
#include "basics.hpp"

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

#define __index(sym) (sym == ' ' ? 26 : sym - 'a')

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

auto algo4j_trie::Trie::insert(const jbyte *word) -> void {
	Node *now = head;
	__goto_end_force(word);
	now->hasElement = true;
}

auto algo4j_trie::Trie::exist(const jbyte *word) -> bool {
	Node *now = head;
	__goto_end_weak(word);
	return now->hasElement;
}

auto algo4j_trie::Trie::existPrefix(const jbyte *word) -> bool {
	Node *now = head;
	__goto_end_weak(word);
	return true;
}

auto Trie::getHead() const -> Node * {
	return head;
}

auto Trie::remove(const jbyte *word) -> void {
	Node *now = head;
	__goto_end_force(word);
	now->hasElement = false;
}

auto algo4j_trie::Node::setNext(jbyte sym, Node *newNode) -> void {
	next[__index(sym)] = newNode;
}

auto algo4j_trie::Node::getNext(jbyte sym) -> Node * {
	return next[__index(sym)];
}

#undef __index
#undef __goto_end_force
#undef __goto_end_weak



