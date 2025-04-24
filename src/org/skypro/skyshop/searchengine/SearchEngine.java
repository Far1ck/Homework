package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.BestResultNotFound;
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

    public Searchable getTheBestSearchResult(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("В строке поиска пусто");
        }
        int maxCount = 0;
        int maxIndex = -1;
        for (int i = 0; i < searchlist.length; i++) {
            if (searchlist[i] == null) {
                break;
            }
            int count = 0;
            int index = 0;
            int indexOfSubstring = searchlist[i].getSearchTerm().indexOf(search, index);
            while (indexOfSubstring != -1) {
                count++;
                index = indexOfSubstring + search.length();
                indexOfSubstring = searchlist[i].getSearchTerm().indexOf(search, index);
            }
            if (count > maxCount) {
                maxCount = count;
                maxIndex = i;
            }
        }
        if (maxIndex != -1) {
            return searchlist[maxIndex];
        } else {
            throw new BestResultNotFound("Для запроса \"" + search + "\" не нашлось подходящей статьи");
        }
    }

    public void add(Searchable searchObject) {
        if (id < searchlist.length) {
            searchlist[id++] = searchObject;
        }
    }
}
