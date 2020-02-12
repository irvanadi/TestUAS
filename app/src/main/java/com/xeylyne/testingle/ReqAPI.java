package com.xeylyne.testingle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ReqAPI {

    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("result")
    @Expose
    private ArrayList<ResultAPI> result = null;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ArrayList<ResultAPI> getResult() {
        return result;
    }

    public void setResult(ArrayList<ResultAPI> result) {
        this.result = result;
    }
}
