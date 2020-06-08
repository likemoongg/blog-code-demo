package net.likemoon.dictionary;

public class EnDictionary implements dictionary.spi.Dictionary{

    @Override
    public String getDefinition(String word){
        if (word.matches("[a-zA-Z]+")) {
            return "looking up English dictionary...";
        }
        return null;
    }
}