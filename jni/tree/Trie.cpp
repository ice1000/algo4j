
#include "../global/trie.h"
#include "Trie.h"

#pragma clang diagnostic push
#pragma ide diagnostic ignored "OCUnusedGlobalDeclarationInspection"

using algo4j_trie::Trie;
using algo4j_trie::Node;

// extern
namespace algo4j_trie {
	JNIEnv *deleter;
}

using algo4j_trie::deleter;

JNIEXPORT auto JNICALL Java_org_algo4j_tree_Trie_createTrie(
		JNIEnv *,
		jclass) -> jlong {
	return (jlong) new Trie();
}

JNIEXPORT auto JNICALL Java_org_algo4j_tree_Trie_deleteTrie(
		JNIEnv *env,
		jclass,
		jlong ptr) -> void {
	deleter = env;
	delete (Trie *) ptr;
}

JNIEXPORT auto JNICALL Java_org_algo4j_tree_Trie_set(
		JNIEnv *env,
		jobject,
		jlong ptr,
		jbyteArray _word,
		jobject _obj) -> void {
	__JNI__FUNCTION__INIT__
	auto trie = (Trie *) ptr;
	__get(Byte, word);
	auto obj = env->NewGlobalRef(_obj);
	trie->put(word, __len(word), obj);
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
	auto ref = trie->remove(word, __len(word));
	env->DeleteGlobalRef(ref);
	__abort(Byte, word);
	__JNI__FUNCTION__CLEAN__
}

JNIEXPORT auto JNICALL Java_org_algo4j_tree_Trie_get(
		JNIEnv *env,
		jobject,
		jlong ptr,
		jbyteArray _word) -> jobject {
	__JNI__FUNCTION__INIT__
	auto trie = (Trie *) ptr;
	__get(Byte, word);
	auto ret = trie->get(word, __len(word));
	__abort(Byte, word);
	__JNI__FUNCTION__CLEAN__
	return ret;
}

#pragma clang diagnostic pop