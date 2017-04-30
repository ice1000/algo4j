//
// Created by ice1000 on 2017/1/28.
//

#include "trie.h"
//#include <stdio.h>

using algo4j_trie::Node;
using algo4j_trie::Trie;

#define __goto_end_force(word) \
for (auto _ = 0; _ < len; ++_) { \
    if (nullptr == now->getNext(word[_])) \
        now->setNext(word[_], new Node()); \
    now = now->getNext(word[_]); \
}

#define __goto_end_weak(word, value) \
for (auto _ = 0; _ < len; ++_) { \
      if (nullptr == now->getNext(word[_])) \
        return value; \
    now = now->getNext(word[_]); \
}

#define __index(sym) ((sym) - 32)

algo4j_trie::Node::Node() : obj(nullptr), next(new ptr_to<Node>[TRIE_NODE_SIZE]{}) { }

algo4j_trie::Node::~Node() {
	if (nullptr != deleter and nullptr != obj)
		deleter->DeleteGlobalRef(obj);
	for (auto _ = 0; _ < TRIE_NODE_SIZE; ++_) {
		if (nullptr != next[_]) delete next[_];
	}
	delete[] next;
}

algo4j_trie::Trie::Trie() : head(new Node()) { }

algo4j_trie::Trie::~Trie() {
	delete head;
}

auto algo4j_trie::Trie::put(const jbyte *word, const jsize len, const jobject obj) -> void {
	auto now = head;
	__goto_end_force(word);
	now->obj = obj;
}

auto algo4j_trie::Trie::get(const jbyte *word, const jsize len) -> jobject {
	auto now = head;
	__goto_end_weak(word, nullptr);
	return now->obj;
}

auto Trie::remove(const jbyte *word, const jsize len) -> jobject {
	auto now = head;
	__goto_end_force(word);
	auto ret = now->obj;
	now->obj = nullptr;
	return ret;
}

auto algo4j_trie::Node::setNext(jbyte sym, ptr_to<Node> newNode) -> void {
	next[__index(sym)] = newNode;
}

auto algo4j_trie::Node::getNext(jbyte sym) -> ptr_to<Node> {
	return next[__index(sym)];
}

#undef __index
#undef __goto_end_force
#undef __goto_end_weak



