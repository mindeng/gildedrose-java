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

        if (this.sellIn < 0) {
            updateAfterExpired();
        }
    }

    protected void updateAfterExpired() {
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

    protected void updateSellIn() {
        this.sellIn = this.sellIn - 1;
    }

    protected void updateQuality() {
        if (this.quality > 0) {
            this.quality = this.quality - 1;
        }
    }

    protected boolean isSulfuras() {
        return false;
    }

    protected boolean isBackstage() {
        return false;
    }

    protected boolean isAgedBrie() {
        return false;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
