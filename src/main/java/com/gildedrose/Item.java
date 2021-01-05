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

    void passOneDay() {
        updateQuality();

        updateSellIn();

        if (isExpired()) {
            updateAfterExpired();
        }
    }

    private boolean isExpired() {
        return this.sellIn < 0;
    }

    protected void updateAfterExpired() {
        if (this.quality > 0) {
            this.quality = this.quality - 1;
        }
    }

    protected void updateSellIn() {
        this.sellIn = this.sellIn - 1;
    }

    protected void updateQuality() {
        if (this.quality > 0) {
            this.quality = this.quality - 1;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
