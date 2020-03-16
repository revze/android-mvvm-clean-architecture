package com.example.belajardagger.presentation.games.list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.belajardagger.R
import com.example.belajardagger.domain.common.State
import com.example.belajardagger.data.model.Games
import com.example.belajardagger.presentation.base.BaseFragment
import com.example.belajardagger.external.extensions.hide
import com.example.belajardagger.external.items.GamesItem
import com.example.belajardagger.external.extensions.show
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
        rv_games.adapter = adapter

        viewModel.result.observe(viewLifecycleOwner, observer)
        viewModel.getGames()
    }

    private val observer = Observer<State<List<Games>>> {
        when (it) {
            is State.Loading -> {
                rv_games.hide()
                pb.show()
                tv_error.hide()
            }
            is State.Success -> {
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
                pb.hide()
                rv_games.hide()
                tv_error.show()
                tv_error.text = it.message
            }
        }
    }
}
