package com.prueba.marvelapp.ui.main

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prueba.marvelapp.R
import com.prueba.marvelapp.api.Data
import com.prueba.marvelapp.di.component.DaggerActivityComponent
import com.prueba.marvelapp.di.module.ActivityModule
import com.prueba.marvelapp.models.Character
import com.prueba.marvelapp.util.ext.createProgressDialog
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var mainPresenter: MainContract.Presenter
    private var progressDialog: Dialog? = null
    private val mainAdapter = MainAdapter()
    private var list_characters = ArrayList<Character>()
    private var menu: ImageView? = null
    private var tv_pop: TextView? = null
    private var recycler: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu = findViewById(R.id.menu)
        recycler = findViewById(R.id.recycler_characters)

        injectDependency()
        mainPresenter.attach(this)
        mainPresenter.showCharacters()

        showRecycler()
        menu?.setOnClickListener{showDialogInfo()}

    }

    private fun showDialogInfo() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.popup_info)
        dialog.show()
        dialog.setCanceledOnTouchOutside(true)

    }

    // function show recycler
    override fun showRecycler() {
        recycler?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdapter
        }
    }

    // function that receives an answer the list of the method of the main class
    override fun loadDataSuccess(items: Data) {
        items.results.let {
            if (it != null) {
                mainAdapter.characters = it
            }
            mainAdapter.notifyDataSetChanged()
         }
    }

    // function inject dependencies
    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()
        activityComponent.inject(this)
    }

    override fun showProgressDialog() {
        progressDialog = createProgressDialog()
    }

    override fun dismissProgressDialog() {
        progressDialog?.dismiss()
    }

    companion object {
        val TAG = "MAIN"
    }
}