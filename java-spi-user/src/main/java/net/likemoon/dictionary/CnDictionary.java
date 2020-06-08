package net.likemoon.dictionary;

import dictionary.spi.Dictionary;

public class CnDictionary implements Dictionary {

    @Override
    public String getDefinition(String word){
        if (!word.matches("[a-zA-Z]+")) {
            return "正在查阅中文字典...";
        }
        return null;
    }
}