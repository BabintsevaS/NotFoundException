package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)
public class TShirt extends Product {
    private String color;
    private String size;

    public TShirt(String color, String size) {
        this.color = color;
        this.size = size;
    }

    public TShirt(int id, String name, int price, String color, String size) {
        super(id, name, price);
        this.color = color;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TShirt tShirt = (TShirt) o;
        return color.equals(tShirt.color) && size.equals(tShirt.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, size);
    }
}
