
#include "../global/trie.h"
#include "../global/basics.hpp"
#include "Trie.h"

#include <stdio.h>

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using algo4j_trie::Trie;
using algo4j_trie::Node;

JNIEXPORT auto JNICALL Java_org_algo4j_tree_Trie_createTrie(
		JNIEnv *,
		jclass) -> jlong {
	return (jlong) new Trie();
}

JNIEXPORT auto JNICALL Java_org_algo4j_tree_Trie_deleteTrie(
		JNIEnv *,
		jclass,
    jlong ptr) -> void {
	delete (Trie *) ptr;
}

JNIEXPORT auto JNICALL Java_org_algo4j_tree_Trie_insert(
		JNIEnv *env,
		jobject,
		jlong ptr,
		jbyteArray _word) -> void {
	__JNI__FUNCTION__INIT__
	auto trie = (Trie *) ptr;
	__get(Byte, word);
	trie->insert(word, __len(word));
	__abort(Byte, word);
	__JNI__FUNCTION__CLEAN__
}

JNIEXPORT auto JNICALL Java_org_algo4j_tree_Trie_remove(
		JNIEnv *env,
		jobject,
		jlong ptr,
		jbyteArray _word) -> void {
	__JNI__FUNCTION__INIT__
	auto trie = (Trie *) ptr;
	__get(Byte, word);
	trie->remove(word, __len(word));
	__abort(Byte, word);
	__JNI__FUNCTION__CLEAN__
}

JNIEXPORT auto JNICALL Java_org_algo4j_tree_Trie_contains(
		JNIEnv *env,
		jobject,
		jlong ptr,
		jbyteArray _word) -> jboolean {
	__JNI__FUNCTION__INIT__
	auto trie = (Trie *) ptr;
	__get(Byte, word);
	auto ret = trie->exist(word, __len(word));
	__abort(Byte, word);
	__JNI__FUNCTION__CLEAN__
	return ret ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT auto JNICALL Java_org_algo4j_tree_Trie_containsPrefix(
		JNIEnv *env,
		jobject,
		jlong ptr,
		jbyteArray _word) -> jboolean {
	__JNI__FUNCTION__INIT__
	auto trie = (Trie *) ptr;
	__get(Byte, word);
	auto ret = trie->existPrefix(word, __len(word));
	__abort(Byte, word);
	__JNI__FUNCTION__CLEAN__
	return ret ? JNI_TRUE : JNI_FALSE;
}



#pragma clang diagnostic pop