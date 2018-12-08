package a99000587.test

import a99000587.test.adapter.CategoryAdapter
import a99000587.test.common.Utility
import a99000587.test.interfaces.ClickPosition
import a99000587.test.model.CategoryModel
import a99000587.test.retrofit.DownlodableCallback
import a99000587.test.retrofit.RetrofitDataProvider
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_callist.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    var retrofitDataProvider: RetrofitDataProvider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        retrofitDataProvider = RetrofitDataProvider(this)

        if (Utility.isNetworkAvailable(this@MainActivity)) {
            callCatApi()
        } else {
            Toast.makeText(this@MainActivity, "" + resources.getString(R.string.nointernet), Toast.LENGTH_SHORT).show()
        }


    }

    private fun callCatApi() {
        retrofitDataProvider!!.quizCat("softgalli-05012018", "10", object : DownlodableCallback<CategoryModel> {
            override fun onSuccess(result: CategoryModel?) {
                if (result != null) {
                    if (result.data!!.size > 0) {
                        rv_category.adapter = CategoryAdapter(this@MainActivity, result.data, object : ClickPosition {
                            override fun pos(position: Int) {
                                startActivity(Intent(this@MainActivity, CategoryList::class.java).putExtra("id", result.data!![position].cat_id).putExtra("name", result.data!![position].catName))
                            }

                            override fun pos(position: Int, name: String?, count: Int) {
                            }
                        })
                    }
                }
            }

            override fun onFailure(error: String?) {
            }

            override fun onUnauthorized(errorNumber: Int) {
            }

        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }


}
