package a99000587.test.model

import com.google.gson.annotations.SerializedName

class SubCategoryModel {

    @SerializedName("id")
    var subcat_id: String?= null
    @SerializedName("subCatNme")
    var subCatNme: String?= null
    @SerializedName("catId")
    var catId: String?= null
    @SerializedName("school_id")
    var school_id: String?= null
}