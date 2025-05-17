package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
