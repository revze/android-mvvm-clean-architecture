package com.example.feature_games.presentation.gamesdetail

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.feature_games.R
import com.example.feature_games.di.Injector
import com.example.igdb.data.model.Games
import com.example.igdb.external.GlideApp
import com.example.igdb.external.constants.ActivityConstant.GamesDetailActivity.GAMES_ID
import com.example.igdb.external.constants.ActivityConstant.GamesDetailActivity.GAMES_NAME
import com.example.igdb.external.extensions.hide
import com.example.igdb.external.extensions.show
import com.example.igdb.presentation.base.BaseActivity
import com.example.igdb.presentation.base.BaseViewModelFactory
import kotlinx.android.synthetic.main.activity_games_detail.*
import javax.inject.Inject
import com.example.igdb.R as appR

class GamesDetailActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: BaseViewModelFactory<GamesDetailViewModel>

    private lateinit var viewModel: GamesDetailViewModel

    private var id = 0

    override fun getLayoutId() = R.layout.activity_games_detail

    override fun initDependencyInjection() {
        Injector.create(this).inject(this)
    }

    override fun getViewModelProvider() {
        viewModel = ViewModelProvider(this, viewModelFactory)[GamesDetailViewModel::class.java]
    }

    override fun onActivityReady(savedInstanceState: Bundle?) {
        id = intent.getIntExtra(GAMES_ID, 0)

        supportActionBar?.title = intent.getStringExtra(GAMES_NAME)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel.loadingLiveData.observe(this, loadingObserver)
        viewModel.errorLiveData.observe(this, errorObserver)
        viewModel.detailLiveData.observe(this, successObserver)

        viewModel.getGamesDetail(id)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private val loadingObserver = Observer<Boolean> {
        pb.show()
        sv_content.hide()
        tv_error.hide()
    }

    private val errorObserver = Observer<String> {
        pb.hide()
        sv_content.hide()
        tv_error.show()
        tv_error.text = it
    }

    private val successObserver = Observer<Games> {
        pb.hide()
        sv_content.show()
        tv_error.hide()

        val games = it
        games.screenshots?.let {
            if (it.isNotEmpty()) {
                val url = it[0].url.replace("//", "https://")
                    .replace("t_thumb", "t_screenshot_med")
                GlideApp.with(this).load(url).placeholder(appR.drawable.bg_placeholder_square)
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
}
