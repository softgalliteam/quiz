package a99000587.test

import a99000587.test.common.Utility
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.toolbar.*

class CategoryList: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_callist)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        if (Utility.isNetworkAvailable(this@CategoryList)) {
            callCatApi()
        } else {
            Toast.makeText(this@CategoryList, "" + resources.getString(R.string.nointernet), Toast.LENGTH_SHORT).show()
        }

    }

    private fun callCatApi() {

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