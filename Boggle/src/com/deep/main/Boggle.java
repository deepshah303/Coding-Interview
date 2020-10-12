package com.deep.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.deep.trie.Trie;
import com.deep.trie.TrieNode;

public class Boggle {

	static String[] englishWordsArray = { "apple", "pickle", "side", "kick", "sick", "mood", "cat", "cats", "man",
			"super", "antman", "godzilla", "dog", "dot", "sine", "cos", "signal", "bitcoin", "cool", "zapper" };

	public static List<String> englishWordsList = Arrays.asList(englishWordsArray);

	public static char[][] boggle = { { 'c', 'n', 't', 's', 's' }, { 'd', 'a', 't', 'i', 'n' },
			{ 'o', 'o', 'm', 'e', 'l' }, { 's', 'i', 'k', 'n', 'd' }, { 'p', 'i', 'c', 'l', 'e' } };

	public static int[][] neighbours = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
			{ 1, 1 }

	};

	

	public static void main(String[] args) {

		TrieNode root = new TrieNode();

		for (int i = 0; i < englishWordsArray.length; i++) {
			Trie.insert(root, englishWordsArray[i]);
		}
		for (int i = 0; i < boggle.length; i++) {
			for (int j = 0; j < boggle[i].length; j++) {
				boolean[][] visited = new boolean[boggle.length][boggle[0].length];
				dfs(i, j, visited, "", root);
			}
		}

	}

	public static void dfs(int row, int col, boolean[][] visited, String currentWord, TrieNode root) {

		TrieNode traversal = root;
		if (visited[row][col])
			return;

		char letter = boggle[row][col];
		

		if (traversal.children[letter - 'a'] != null) {
			visited[row][col] = true;
			currentWord += letter;
			traversal = traversal.children[letter - 'a'];

			if (traversal.isEndOfWord) {
				System.out.println("Found : " + currentWord);
			}

			for (int i = 0; i < neighbours.length; i++) {

				int newRow = row + neighbours[i][0];
				int newCol = col + neighbours[i][1];

				if (newRow >= boggle.length || newCol >= boggle[0].length || newRow < 0 || newCol < 0)
					continue;

				dfs(newRow, newCol, visited, currentWord, traversal);
			}

		}

	}

}
