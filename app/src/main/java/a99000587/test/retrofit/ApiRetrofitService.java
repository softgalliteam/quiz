package a99000587.test.retrofit;


import a99000587.test.model.CategoryModel;
import a99000587.test.model.QuesAnsModel;
import a99000587.test.model.SubCategoryModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Shankar on 1/27/2018.
 */

public interface ApiRetrofitService {
    @Headers("x-api-key: 1a!2b@3c#4d$5e%6f^")
    @POST(ApiUrl.QUIZ_CATEGORY)
    @FormUrlEncoded
    Call<CategoryModel> getQuizCat(@Field("school_id") String school_id, @Field("class_id") String class_id);

    @Headers("x-api-key: 1a!2b@3c#4d$5e%6f^")
    @POST(ApiUrl.QUIZ_SUBCATEGORY)
    @FormUrlEncoded
    Call<SubCategoryModel> getQuizSubCat(@Field("school_id") String school_id, @Field("catId") String catId, @Field("class_id") String class_id);

    @Headers("x-api-key: 1a!2b@3c#4d$5e%6f^")
    @POST(ApiUrl.QUIZ_QUESTION)
    @FormUrlEncoded
    Call<QuesAnsModel> getQuizQues(@Field("school_id") String school_id, @Field("subCatId") String subCatId, @Field("class_id") String class_id);


}
