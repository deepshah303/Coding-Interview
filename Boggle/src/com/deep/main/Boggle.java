package com.deep.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.deep.trie.Trie;
import com.deep.trie.TrieNode;

public class Boggle {

	
	static String[] englishWordsArray = { "apple", "pickle", "side", "kick", "sick", "mood", "cat", "cats", "man", "super",
			"antman", "godzilla", "dog", "dot", "sine", "cos", "signal", "bitcoin", "cool", "zapper" };
	
	public static List<String> englishWordsList = Arrays.asList(englishWordsArray);

	public static void main(String[] args) {
		
		TrieNode root = new TrieNode();
		
		for(int i=0 ; i < englishWordsArray.length ; i++){
			Trie.insert(root, englishWordsArray[i]);
		}
		System.out.println(root);
	}

}
