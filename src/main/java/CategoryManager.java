package main.java;

import java.util.HashSet;


public class CategoryManager {

    private HashSet<String> categories = new HashSet<>();

    public void addCategory(String nameofcategory) {
        if (categories.contains(nameofcategory)) {
            throw new main.java.exceptions.DuplicateCategoryException("Категорія " + nameofcategory + " вже існує!");
        }
        categories.add(nameofcategory);
    }

    public HashSet<String> getCategories() {
        return new HashSet<>(categories);
    }

    ;

}
