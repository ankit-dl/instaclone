package com.ankit.inguram.ui.feed.ui.feed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ankit.inguram.R
import com.ankit.inguram.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    lateinit var binding: FragmentFeedBinding
    private lateinit var viewModel: FeedViewModel

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

        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        val feed = arguments?.get("feed")
        binding.feedtv.text = feed.toString()


    }

}