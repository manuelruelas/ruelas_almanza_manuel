package org.example;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /// init array with words
        ArrayList<String> words = new ArrayList<String>();
        words.add("a");
        words.add("aaa");
        words.add("aaa");
        System.out.println(longestStrings(words));

    }
    /// Returns an array with the longest words of the given array.
    public static ArrayList<String> longestStrings(ArrayList<String> words) {
        int longestWord = Integer.MIN_VALUE;
        ArrayList<String> result = new ArrayList<String>();
        for (String word : words) {
            if (word.length() > longestWord) {
                longestWord = word.length();
                result.clear();
                result.add(word);
            } else if (word.length() == longestWord) {
                result.add(word);
            }
        }

        return result;
    }
}