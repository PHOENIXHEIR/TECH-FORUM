/*
Note that this is just an example implementation, and there are many ways to implement a repository using List and HashSet. Depending on your specific use case and requirements, you may need to modify this code to better suit your needs.
*/
package com.practice.springbootdemo.repositories;

import com.practice.springbootdemo.models.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class CategoryRepository {

    private Set<Category> categories = new HashSet<>();

    public List<Category> getAllCategories() {
        return new ArrayList<>(categories);
    }

    public Category getCategoryById(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    public Category addCategory(Category category) {
        int newId = categories.size() + 1;
        category.setId(newId);
        categories.add(category);
        return category;
    }

    public void deleteCategory(int id) {
        Category category = getCategoryById(id);
        if (category != null) {
            categories.remove(category);
        }
    }

}
