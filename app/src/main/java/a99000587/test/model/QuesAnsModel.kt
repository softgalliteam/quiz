package a99000587.test.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class QuesAnsModel : Parcelable {
    @SerializedName("ques_id")
    var ques_id: String?= null
    @SerializedName("subCatId")
    var subCatId: String?= null
    @SerializedName("question")
    var question: String?= null
    @SerializedName("optionFirst")
    var optionFirst: String?= null
    @SerializedName("optionSecond")
    var optionSecond: String?= null
    @SerializedName("optionThird")
    var optionThird: String?= null
    @SerializedName("optionFourth")
    var optionFourth: String?= null
    @SerializedName("answer")
    var answer: String?= null
}