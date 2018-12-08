package a99000587.test

import a99000587.test.adapter.CateoryListAdapter
import a99000587.test.common.Utility
import a99000587.test.interfaces.ClickPosition
import a99000587.test.model.QuesAnsModel
import a99000587.test.model.SubCategoryModel
import a99000587.test.retrofit.DownlodableCallback
import a99000587.test.retrofit.RetrofitDataProvider
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_callist.*
import kotlinx.android.synthetic.main.toolbar.*

class CategoryList : AppCompatActivity() {

    var retrofitDataProvider: RetrofitDataProvider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_callist)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        retrofitDataProvider = RetrofitDataProvider(this)

        if (Utility.isNetworkAvailable(this@CategoryList)) {
            callCatApi()
        } else {
            Toast.makeText(this@CategoryList, "" + resources.getString(R.string.nointernet), Toast.LENGTH_SHORT).show()
        }

    }

    private fun callCatApi() {
        retrofitDataProvider!!.quizSubCat("softgalli-05012018", "1", "10", object : DownlodableCallback<SubCategoryModel> {
            override fun onSuccess(result: SubCategoryModel?) {
                if (result != null) {
                    if (result.data!!.size > 0) {
                        rv_list.adapter = CateoryListAdapter(this@CategoryList, result.data, object : ClickPosition {
                            override fun pos(position: Int) {
                                callQuesApi(result.data!![position].subcat_id, result.data!![position].subCatNme)
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

    private fun callQuesApi(subcat_id: String?, subCatNme: String?) {
        retrofitDataProvider!!.quizQuestion("softgalli-05012018", "10", subcat_id, object : DownlodableCallback<QuesAnsModel> {
            override fun onSuccess(result: QuesAnsModel?) {
                if (result != null) {
                    if (result.data!!.size > 0) {
                        startActivity(Intent(this@CategoryList, QuesAnsActivity::class.java).putParcelableArrayListExtra("list", result.data).putExtra("name", subCatNme))
                    }
                }
            }

            override fun onFailure(error: String?) {
            }

            override fun onUnauthorized(errorNumber: Int) {
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_item -> {
                if (Utility.isNetworkAvailable(this@CategoryList)) {
                    callCatApi()
                } else {
                    Toast.makeText(this@CategoryList, "" + resources.getString(R.string.nointernet), Toast.LENGTH_SHORT).show()
                }
                return true
            }


            else -> return super.onOptionsItemSelected(item)
        }
    }
}