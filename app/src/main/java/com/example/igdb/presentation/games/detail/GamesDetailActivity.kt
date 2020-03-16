package com.example.igdb.presentation.games.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.igdb.R
import com.example.igdb.data.model.Games
import com.example.igdb.domain.common.State
import com.example.igdb.domain.common.State.*
import com.example.igdb.external.GlideApp
import com.example.igdb.external.extensions.hide
import com.example.igdb.external.extensions.show
import com.example.igdb.external.helper.DialogHelper
import com.example.igdb.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_games_detail.*
import javax.inject.Inject

class GamesDetailActivity : BaseActivity<GamesDetailViewModel>() {

    @Inject
    lateinit var dialogHelper: DialogHelper

    companion object {
        const val GAMES_ID = "games_id"
        const val GAMES_TITLE = "games_title"
    }

    private var id = 0

    override fun getLayoutId() = R.layout.activity_games_detail

    override fun getViewModelProvider() =
        ViewModelProvider(this, viewModelFactory)[GamesDetailViewModel::class.java]

    override fun onActivityReady(savedInstanceState: Bundle?) {
        supportActionBar?.title = intent.getStringExtra(GAMES_TITLE)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel.result.observe(this, observer)

        id = intent.getIntExtra(GAMES_ID, 0)

        viewModel.getDetail(id)
    }

    private val observer = Observer<State<Games>> {
        when (it) {
            is Loading -> {
                pb.show()
                sv_content.hide()
                tv_error.hide()
            }
            is Success -> {
                pb.hide()
                sv_content.show()
                tv_error.hide()

                val games = it.data
                games.screenshots?.let {
                    if (it.isNotEmpty()) {
                        val url = it[0].url.replace("//", "https://")
                            .replace("t_thumb", "t_screenshot_med")
                        GlideApp.with(this).load(url).placeholder(R.drawable.bg_placeholder_square)
                            .into(iv_screenshot)
                    }
                }
                tv_summary.text = games.summary
                games.websites.let {
                    if (!it.isNullOrEmpty()) {
                        tv_website.text = it[0].url
                    } else {
                        tv_website.text = "N/A"
                    }
                }
                tv_rating.text = games.rating?.toString() ?: "N/A"
                games.releaseDates.let {
                    if (!it.isNullOrEmpty()) {
                        tv_release_date.text =
                            textHelper.convertLongToFormattedDate(it[0].date, "EEEE, d MMMM yyyy")
                    } else {
                        tv_release_date.text = "N/A"
                    }
                }
                games.genres.let {
                    if (!it.isNullOrEmpty()) {
                        var genres = ""
                        for (genre in it) {
                            genres += "${genre.name}, "
                        }
                        tv_genre.text = genres
                    } else {
                        tv_genre.text = "N/A"
                    }
                }
                games.platforms.let {
                    if (!it.isNullOrEmpty()) {
                        var platforms = ""
                        for (platform in it) {
                            platforms += "${platform.name}, "
                        }
                        tv_platform.text = platforms
                    } else {
                        tv_release_date.text = "N/A"
                    }
                }
            }
            is Error -> {
                pb.hide()
                sv_content.hide()
                tv_error.show()
                tv_error.text = it.message
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
