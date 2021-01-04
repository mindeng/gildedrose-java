package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public static void updateQuality(Item[] items) {
        for (Item item : items) {
            item.updateQuality();
        }
    }

}
