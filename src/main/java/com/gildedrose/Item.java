package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    static Item createAgedBrie(int sellIn, int quality) {
        return new Item("Aged Brie", sellIn, quality);
    }

    static Item createSulfuras(int sellIn, int quality) {
        return new Item("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    static Item createBackstage(int sellIn, int quality) {
        return new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    void updateQuality() {
        if (!isAgedBrie()
                && !isBackstage()) {
            if (this.quality > 0) {
                if (!isSulfuras()) {
                    this.quality = this.quality - 1;
                }
            }
        } else {
            if (this.quality < 50) {
                this.quality = this.quality + 1;

                if (isBackstage()) {
                    if (this.sellIn < 11) {
                        if (this.quality < 50) {
                            this.quality = this.quality + 1;
                        }
                    }

                    if (this.sellIn < 6) {
                        if (this.quality < 50) {
                            this.quality = this.quality + 1;
                        }
                    }
                }
            }
        }

        if (!isSulfuras()) {
            this.sellIn = this.sellIn - 1;
        }

        if (this.sellIn < 0) {
            if (!isAgedBrie()) {
                if (!isBackstage()) {
                    if (this.quality > 0) {
                        if (!isSulfuras()) {
                            this.quality = this.quality - 1;
                        }
                    }
                } else this.quality = 0;
            } else {
                if (this.quality < 50) {
                    this.quality = this.quality + 1;
                }
            }
        }
    }

    private boolean isSulfuras() {
        return this.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstage() {
        return this.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie() {
        return this.name.equals("Aged Brie");
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
