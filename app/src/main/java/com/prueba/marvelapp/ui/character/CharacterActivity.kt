package com.prueba.marvelapp.ui.character

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import com.prueba.marvelapp.R
import com.prueba.marvelapp.di.component.DaggerActivityComponent
import com.prueba.marvelapp.di.module.ActivityModule
import com.prueba.marvelapp.models.Character
import com.prueba.marvelapp.ui.main.MainActivity
import com.prueba.marvelapp.util.ext.createProgressDialog
import com.prueba.marvelapp.util.ext.loadImageFromLink
import de.hdodenhof.circleimageview.CircleImageView
import javax.inject.Inject

class CharacterActivity : AppCompatActivity(), CharacterContract.View {

    @Inject
    lateinit var characterPresenter: CharacterContract.Presenter
    private var progressDialog: Dialog? = null
    private var btn_menu: ImageButton? = null
    private var img: CircleImageView? = null
    private var name: TextView? = null
    private var desc: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)

        btn_menu = findViewById(R.id.btn_return)
        img = findViewById(R.id.image_profile)
        name = findViewById(R.id.name_profile)
        desc = findViewById(R.id.desc_profile)

        injectDependency()
        characterPresenter.attach(this)

        loadObj()

        btn_menu?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    // load obj id of main
    private fun loadObj() {
        val id = intent.getIntExtra("OBJ_CHARACTER", 0)
        Log.e(TAG, "ID----------$id")
        characterPresenter.showCharacter(id)
    }

    // function that show data in inputs
    override fun showData(character: Character) {
        if (character != null) {
            img?.loadImageFromLink("${character.thumbnail.path}.${character.thumbnail.extension}")
            name?.text = character.name
            if (character.description.isNotEmpty()) {
                desc?.text = character.description
            } else
                desc?.text = getString(R.string.text_lorem_input)
        } else {
            img?.setImageResource(R.drawable.ic_not_profile)
            desc?.text = getString(R.string.text_lorem_input)
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
        val TAG = "CHARACTER"
    }
}