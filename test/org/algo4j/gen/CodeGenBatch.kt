package org.algo4j.gen

import org.algo4j.test.print
import org.algo4j.test.println

/**
 * Created by algo4j on 2016/12/7.
 *
 * @author algo4j
 */

fun main(args: Array<String>) {
	"@echo off".println()
	listOf(
			"global",
			"graph",
			"bit",
			"math",
			"util"
	).forEach { path ->
		"""
cd $path
if exist *.o (
	del /f /s /q *.o
)
cd ..
""".print()
	}
	"\n\n\n\n".println()
	listOf(
			"layout",
			"o",
			"a",
			"exe",
			"def",
			"log"
	).forEach { suffix ->
		"""
if exist *.$suffix (
	del /f /s /q *.$suffix
)
""".print()
	}
	"\n\n\n\n".println()
	listOf(
			"build",
			"cmake-build-debug"
	).forEach { dir ->
		"""
if exist $dir (
	rd /s /q $dir
)
""".print()
	}
}
