package a99000587.test.retrofit;


import a99000587.test.model.CategoryModel;
import a99000587.test.model.QuesAnsModel;
import a99000587.test.model.SubCategoryModel;

/**
 * Created by Shankar on 1/27/2018.
 */

public interface ServiceMethods {
    void quizCat(String school_id, String class_id, DownlodableCallback<CategoryModel> callback);

    void quizSubCat(String school_id, String catId, String class_id, DownlodableCallback<SubCategoryModel> callback);

    void quizQuestion(String school_id, String subCatId, String class_id, DownlodableCallback<QuesAnsModel> callback);

}
