package com.example.feature_games.presentation.gameslist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.feature_games.R
import com.example.feature_games.di.Injector
import com.example.igdb.data.model.Games
import com.example.igdb.domain.common.State
import com.example.igdb.external.extensions.hide
import com.example.igdb.external.extensions.show
import com.example.igdb.external.helper.ActivityNavigation
import com.example.igdb.external.items.GamesItem
import com.example.igdb.presentation.base.BaseViewModelFactory
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_games_list.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class GamesListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: BaseViewModelFactory<GamesListViewModel>

    @Inject
    lateinit var activityNavigation: ActivityNavigation

    private val adapter = GroupAdapter<GroupieViewHolder>()

    private lateinit var viewModel: GamesListViewModel

    override fun onAttach(context: Context) {
        Injector.create(requireActivity()).inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel =
            ViewModelProvider(requireActivity(), viewModelFactory)[GamesListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
                        ) {
                            activityNavigation.toGamesDetail(games.id, games.name)
                        }
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
