package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    protected void updateQuality() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }
    }

    @Override
    protected void updateQualityAfterExpired() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }
    }
}
