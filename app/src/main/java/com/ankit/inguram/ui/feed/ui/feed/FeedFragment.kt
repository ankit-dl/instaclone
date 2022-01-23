package com.ankit.inguram.ui.feed.ui.feed

import actions.FeedDelegate
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.viewModels
import base.Delegate
import com.ankit.inguram.R
import com.ankit.inguram.data.model.Feed
import com.ankit.inguram.databinding.FragmentFeedBinding
import com.ankit.inguram.mapper.FeedMapper

class FeedFragment : Fragment(), Delegate<FeedDelegate> {

    companion object {
        fun newInstance() = FeedFragment()
    }

    lateinit var binding: FragmentFeedBinding
    private val viewModel: FeedViewModel by viewModels()

    private val adapter: BaseAdapter by lazy {
        BaseAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedBinding.inflate(inflater)
        return binding.root
        //  return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvFeed.adapter = adapter

        viewModel.feedLiveData.observe({ lifecycle }) {
            val data = it.map { link ->


            }


        }
        //  viewModel = V
        val feed = arguments?.getString("feed")
        feed?.let {
            viewModel.updateFeed(it)
        }


    }

    override fun click(data: FeedDelegate) {
        when (data) {
            is FeedDelegate.OnFeedClick -> {
                Toast.makeText(requireContext(), data.url, Toast.LENGTH_SHORT).show()
            }
        }

    }

}