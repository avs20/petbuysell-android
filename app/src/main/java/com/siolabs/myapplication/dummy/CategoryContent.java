package com.siolabs.myapplication.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class CategoryContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<CategoryItem> ITEMS = new ArrayList<CategoryItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, CategoryItem> ITEM_MAP = new HashMap<String, CategoryItem>();

    static {
        // Add 3 sample items.
        
//        addItem(new CategoryItem(("1","Dogs"));
        

        addItem(new CategoryItem("1", "Dogs"));
        addItem(new CategoryItem("2", "Birds"));
        addItem(new CategoryItem("3", "Fishes"));
        addItem(new CategoryItem("3", "Reptiles"));
        addItem(new CategoryItem("3", "Corals"));
        addItem(new CategoryItem("3", "Others"));
    }

    private static void addItem(CategoryItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class CategoryItem {
        public String id;
        public String content;
        
        

        public CategoryItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
