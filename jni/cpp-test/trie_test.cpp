//
// Created by ice1000 on 2017/1/30.
//

#include "../global/trie.cpp"
#include <stdio.h>

using algo4j_trie::Trie;
using algo4j_trie::Node;

auto main(const int argc, const char *argv[]) -> int {
	auto node = new Node();
	printf("%p\n", node->getNext('a'));
	node->setNext('a', new Node());
	printf("%p\n", node->getNext('a'));
	auto trie = new Trie();
	puts(
			trie->exist("van")
			? "true"
			: "false"
	);
	printf("%p\n", trie->getHead()->getNext('v'));
	trie->insert("van");
	printf("%p\n", trie->getHead()->getNext('v'));
	printf("%p\n", trie->getHead()->getNext('v')->getNext('a'));
	printf("%p\n", trie->getHead()->getNext('v')->getNext('a')->getNext('n'));
	puts(
			trie->exist("van")
			? "true"
			: "false"
	);
	puts(
			trie->exist("vand")
			? "true"
			: "false"
	);
	puts(
			trie->exist("va")
			? "true"
			: "false"
	);
	return 0;
}
