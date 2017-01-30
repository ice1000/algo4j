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
			trie->exist((jbyte*)"van van")
			? "true"
			: "false"
	);
	trie->insert((jbyte*)"van van");
	puts(
			trie->exist((jbyte*)"van van")
			? "true"
			: "false"
	);
//	printf("%p\n", trie->getHead()->getNext('v'));
//	printf("%p\n", trie->getHead()->getNext('v')->getNext('a'));
//	printf("%p\n", trie->getHead()->getNext('v')->getNext('a')->getNext('n'));
	puts(
			trie->exist((jbyte*)"van van")
			? "true"
			: "false"
	);
	puts(
			trie->exist((jbyte*)"van vand")
			? "true"
			: "false"
	);
	puts(
			trie->exist((jbyte*)"van va")
			? "true"
			: "false"
	);
	puts(
			trie->existPrefix((jbyte*)"van")
			? "true"
			: "false"
	);
	trie->remove((jbyte*)"van van");
	puts(
			trie->exist((jbyte*)"van van")
			? "true"
			: "false"
	);
	return 0;
}
