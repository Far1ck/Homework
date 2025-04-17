package org.skypro.skyshop;

public interface Searchable {
    String getName();
    String getSearchTerm();
    String getTypeOfContent();
    default String getStringRepresentation() {
        return this.getName() + " - " + this.getTypeOfContent();
    }
}
