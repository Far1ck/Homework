package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.BestResultNotFound;
import org.skypro.skyshop.Searchable;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> searchlist;

    public SearchEngine() {
        searchlist = new HashSet<>();
    }

    public Set<Searchable> search(String target) {
        Set<Searchable> searchResult = new TreeSet<>((o1, o2) -> {
            int result = o2.getName().length() - o1.getName().length();
            return result != 0 ? result : o1.getName().compareTo(o2.getName());
        });
        for (Searchable x : searchlist) {
            if (x.getSearchTerm().contains(target)) {
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
        Searchable result = null;
        for (Searchable searchable : searchlist) {
            int count = 0;
            int index = 0;
            int indexOfSubstring = searchable.getSearchTerm().indexOf(search, index);
            while (indexOfSubstring != -1) {
                count++;
                index = indexOfSubstring + search.length();
                indexOfSubstring = searchable.getSearchTerm().indexOf(search, index);
            }
            if (count > maxCount) {
                maxCount = count;
                result = searchable;
            }
        }
        if (result != null) {
            return result;
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
