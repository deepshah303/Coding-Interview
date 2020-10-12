package com.deep.trie;

public class Trie {

	public static void insert(TrieNode root, String word) {

		TrieNode trieCrawl = root;

		int index;
		
		for(int i = 0 ; i < word.length() ; i++){
			index = word.charAt(i) - 'a';
			if(trieCrawl.children[index] == null){
				trieCrawl.children[index] = new TrieNode();
			}
			trieCrawl = trieCrawl.children[index];
			
		}
		trieCrawl.isEndOfWord = true;
	}

}
