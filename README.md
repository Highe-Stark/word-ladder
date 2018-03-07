Word Ladder
===========

## Definition

> Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that: 
>
> Only one letter can be changed at a time.
> Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
> For example, 
>
> Given:
> _beginWord_ = "hit"
> _endWord_ = "cog"
> _wordList_ = ["hot","dot","dog","lot","log","cog"]
> As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
> return its length 5.
>
> Note:
> * Return 0 if there is no such transformation sequence.
> * All words have the same length.
> * All words contain only lowercase alphabetic characters.
> * You may assume no duplicates in the word list.
> * You may assume beginWord and endWord are non-empty and are not the same.

 from https://leetcode.com/problems/word-ladder/description/

## Instruction

1. Download the repository

		git clone https://github.com/Highe-Stark/word-ladder.git  // clone with HTTP
		git clone git@github.com:Highe-Stark/word-ladder.git  // clone with SSH

2. compile

		cd word-ladder/src/
		make

3. Run 

		java Entry [-d <path>] [-b <begin word>] [-e <end word>]
	           

4. Test
  
	Modify makefile and test.sh in the component directory, changing "/opt/java/jdk-9.0.4/lib/junit-4.9.jar" to the path where your junit locates.

		cd components
		make Test
		./test.sh

## Description

-d \<path\>
  the path where the dictionary file is.

-b \<begin\>
  the word that the ladder start from.

-e \<end\>
  the destination word.

