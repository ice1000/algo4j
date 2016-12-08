package org.ice1000.gen

import org.ice1000.test.print
import org.ice1000.test.println

/**
 * Created by ice1000 on 2016/12/7.
 *
 * @author ice1000
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
