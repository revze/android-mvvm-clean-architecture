package com.example.igdb.presentation.games.list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.igdb.R
import com.example.igdb.data.model.Games
import com.example.igdb.domain.common.State
import com.example.igdb.external.extensions.hide
import com.example.igdb.external.extensions.show
import com.example.igdb.external.items.GamesItem
import com.example.igdb.presentation.base.BaseFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.games_fragment.*

class GamesFragment : BaseFragment<GamesViewModel>() {

    companion object {
        fun newInstance() = GamesFragment()
    }

    private val adapter = GroupAdapter<GroupieViewHolder>()

    override fun getLayoutId() = R.layout.games_fragment

    override fun getViewModelProvider() =
        ViewModelProvider(requireActivity(), viewModelFactory)[GamesViewModel::class.java]

    override fun onFragmentReady(view: View, savedInstanceState: Bundle?) {
        viewModel.result.observe(viewLifecycleOwner, observer)

        rv_games.adapter = adapter
        sr_games.setOnRefreshListener {
            adapter.clear()
            viewModel.getGames()
        }
        viewModel.getGames()
    }

    private val observer = Observer<State<List<Games>>> {
        when (it) {
            is State.Loading -> {
                sr_games.isRefreshing = false
                sr_games.isEnabled = false
                rv_games.hide()
                pb.show()
                tv_error.hide()
            }
            is State.Success -> {
                sr_games.isEnabled = true
                for (games in it.data) {
                    adapter.add(
                        GamesItem(
                            games
                        )
                    )
                }
                pb.hide()
                rv_games.show()
                tv_error.hide()
            }
            is State.Error -> {
                sr_games.isEnabled = true
                pb.hide()
                rv_games.hide()
                tv_error.show()
                tv_error.text = it.message
            }
        }
    }
}
