package net.letscode.nau.languaged;

import net.letscode.nau.languaged.text.TranslatableText;
import net.letscode.nau.languaged.translation.TranslationKey;
import net.letscode.nau.languaged.translation.TranslationKeyNotFoundException;
import net.letscode.nau.utiled.ArrayUtil;

public class LanguageProvider {
    Language[] languages;
    Language CURRENT;

    public LanguageProvider() {
        this.languages = new Language[0];
    }

    public void addLanguage(Language language) {
        languages = ArrayUtil.addToArray(languages, language);
    }


    public void addLanguages(Language... languages) {
        for(Language language : languages) {
            this.languages = ArrayUtil.addToArray(this.languages, language);
        }
    }

    public void changeLanguage(Language language) {
        this.CURRENT = language;
    }

    public Language getCurrentLanguage() {
        return CURRENT;
    }

    public TranslationKey getTransKey(String id) {
        try{
            return CURRENT.getKey(id);
        } catch(TranslationKeyNotFoundException ignored) {};
        return null;
    }

    public String getKey(String id) {
        return this.getTransKey(id).key;
    }

    public String getKey(TranslatableText translatableText) {
        return this.getKey(translatableText.text);
    }

    public Language[] getLanguages() {
        return this.languages;
    }

    public String[] getLanguageNames() {
        String[] languagesNames = new String[this.languages.length];

        for(int i = 0;i<this.languages.length;i++) {
            languagesNames[i] = this.languages[i].name;
        }

        return languagesNames;
    }
}