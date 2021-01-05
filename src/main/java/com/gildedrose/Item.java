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

    private void updateQuality() {
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
