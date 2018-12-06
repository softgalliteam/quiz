package a99000587.test.model

import com.google.gson.annotations.SerializedName

class CategoryModel {

    @SerializedName("cat_id")
    var cat_id: String?= null
    @SerializedName("catName")
    var catName: String?= null
    @SerializedName("catIcon")
    var catIcon: String?= null
}