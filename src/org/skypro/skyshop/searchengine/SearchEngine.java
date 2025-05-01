package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.BestResultNotFound;
import org.skypro.skyshop.Searchable;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchlist;

    public SearchEngine() {
        searchlist = new ArrayList<>();
    }

    public List<Searchable> search(String target) {
        List<Searchable> searchResult = new ArrayList<>();
        for (Searchable x : searchlist) {
            if (x != null && x.getSearchTerm().contains(target)) {
                searchResult.add(x);
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
        for (int i = 0; i < searchlist.size(); i++) {
            int count = 0;
            int index = 0;
            int indexOfSubstring = searchlist.get(i).getSearchTerm().indexOf(search, index);
            while (indexOfSubstring != -1) {
                count++;
                index = indexOfSubstring + search.length();
                indexOfSubstring = searchlist.get(i).getSearchTerm().indexOf(search, index);
            }
            if (count > maxCount) {
                maxCount = count;
                maxIndex = i;
            }
        }
        if (maxIndex != -1) {
            return searchlist.get(maxIndex);
        } else {
            throw new BestResultNotFound("Для запроса \"" + search + "\" не нашлось подходящей статьи");
        }
    }

    public void add(Searchable searchObject) {
        if (searchObject != null) {
            searchlist.add(searchObject);
        }
    }
}
