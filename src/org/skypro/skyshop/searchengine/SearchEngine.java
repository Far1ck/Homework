package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.Searchable;

public class SearchEngine {
    private Searchable[] searchlist;
    private int id = 0;

    public SearchEngine(int size) {
        searchlist = new Searchable[size];
    }

    public Searchable[] search(String target) {
        Searchable[] searchResult = new Searchable[5];
        int counter = 0;
        for (Searchable x : searchlist) {
            if (counter > 4) {
                break;
            } else if (x != null && x.getSearchTerm().contains(target)) {
                searchResult[counter++] = x;
            }
        }
        return searchResult;
    }

    public void add(Searchable searchObject) {
        if (id < searchlist.length) {
            searchlist[id++] = searchObject;
        }
    }
}
