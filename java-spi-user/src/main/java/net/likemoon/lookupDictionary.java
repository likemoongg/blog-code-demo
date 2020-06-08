package net.likemoon;

import dictionary.DictionaryService;

public class lookupDictionary {
    public static void main(String[] args) {
        DictionaryService dictionaryService = DictionaryService.getInstance();
        System.out.println(dictionaryService.getDefinition("english"));
        System.out.println(dictionaryService.getDefinition("中文"));
    }
}
