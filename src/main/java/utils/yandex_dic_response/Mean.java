
package main.java.utils.yandex_dic_response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mean {

    @SerializedName("text")
    @Expose
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
