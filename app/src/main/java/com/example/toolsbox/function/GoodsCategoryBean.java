package com.example.toolsbox.function;

import androidx.annotation.NonNull;

import com.github.gzuliyujiang.wheelview.contract.TextProvider;

import java.io.Serializable;

public class GoodsCategoryBean implements Serializable, TextProvider {
    private int id;
    private String name;

    public GoodsCategoryBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String provideText() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return "GoodsCategoryBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}

