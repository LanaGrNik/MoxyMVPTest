package com.moxy.moxymvptest.model.main;

import java.util.ArrayList;
import java.util.List;

public class SelectorData {

    private int selectedId;
    private List<Variant> variants;

    public int getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public List<String> getStringVariants() {
        List<String> stringList = new ArrayList<>();
        for (Variant variant: variants) {
            stringList.add(variant.getText());
        }
        return stringList;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }
}
