package net.letscode.nau.languaged;


import net.letscode.nau.languaged.translation.TranslationKey;
import net.letscode.nau.languaged.translation.TranslationKeyNotFoundException;
import net.letscode.nau.utiled.ArrayUtil;

public class Language {
    public String name;
    public String id;

    TranslationKey[] translationKeys;

    public Language(String name, String id) {
        this.name = name;
        this.id = id;
        this.translationKeys = new TranslationKey[0];
    }

    public void addKey(String id, String key) {
        this.addKey(new TranslationKey(id, key));
    }

    public void addKey(TranslationKey transKey) {
        translationKeys = ArrayUtil.addToArray(translationKeys, transKey);
    }

    public TranslationKey getKey(String id) throws TranslationKeyNotFoundException {
        for(TranslationKey transKey : translationKeys) {
            if(transKey.id.equals(id)) {
                return transKey;
            }
        }

        throw new TranslationKeyNotFoundException("Translation key with the id \"" + id + "\" could not be found.");
    }
}
