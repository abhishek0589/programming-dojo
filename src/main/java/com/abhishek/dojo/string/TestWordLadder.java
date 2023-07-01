package com.abhishek.dojo.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestWordLadder {

	public static void main(String[] args) {
        String beginWord = "leet",endWord="code";
        ArrayList<String> strings = new ArrayList<String>();
        //"lest", "leet", "lose", "code", "lode", "robe", "lost"
        strings.add("leet");
        strings.add("lest");
        strings.add("lose");
        strings.add("code");
        strings.add("robe");
        strings.add("lost");
        strings.add("lode");
        // leet, lest, lost, lose, lode, code
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add(beginWord);
        printTransformation(endWord,linkedList,strings);

    }

    private static void printTransformation(String endWord,LinkedList<String> list,List<String> strings){
        for (int k = 0;k<strings.size();k++) {
            String beginWord = list.getLast();
            int count=0;
            String string = strings.get(k);
            if(beginWord.length() != string.length())
                continue;
            else{
                for(int i=0;i<string.length();i++){
                    if(string.charAt(i) != beginWord.charAt(i))
                        count ++;
                }

                if(count >1)
                    continue;
                else if(count ==1){
                    beginWord = string;
                    if(beginWord.equals(endWord)){
                        list.add(string);
                        break;
                    }
                    else{
                        //recursively call this method with previous string
                        if(k==strings.size()-1){
                            list.removeLast();
                        }
                        list.add(string);
                        int innerCount = 0;
                        for(int i=0;i<endWord.length();i++){
                            if(string.charAt(i) != endWord.charAt(i))
                                innerCount ++;
                        }
                        if(innerCount==1) {
                            list.add(endWord);
                            break;
                        }
                    }
                }

            }
        }
        System.out.println(list);
    }
}
