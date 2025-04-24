package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

public class Article implements Searchable {
    private String name;
    private String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return name + "\n" + text + "\n";
    }

    public String getName() {
        return name;
    }

    @Override
    public String getSearchTerm() {
        return this.toString();
    }

    @Override
    public String getTypeOfContent() {
        return "ARTICLE";
    }
}
