package com.file.lock;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Entity {
    private String val1;
    private String val2;
    private String val3;

    public Entity(String val1, String val2, String val3) {
        this.val1 = val1;
        this.val2 = val2;
        this.val3 = val3;
    }

    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1;
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2;
    }

    public String getVal3() {
        return val3;
    }

    public void setVal3(String val3) {
        this.val3 = val3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Entity entity = (Entity) o;

        return new EqualsBuilder()
                .append(val1, entity.val1)
                .append(val2, entity.val2)
                .append(val3, entity.val3)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(val1)
                .append(val2)
                .append(val3)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Entity{" +
                "val1='" + val1 + '\'' +
                ", val2='" + val2 + '\'' +
                ", val3='" + val3 + '\'' +
                '}';
    }
}
