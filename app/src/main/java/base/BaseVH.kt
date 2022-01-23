package base

import actions.FeedDelegate
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import com.ankit.inguram.R
import com.ankit.inguram.data.model.Feed
import com.ankit.inguram.databinding.FeedItemBinding


abstract class BaseVH<T : RVItem, L>(binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    open lateinit var delegate: Delegate<L>
    abstract fun bind(data: T, position: Int)
}

class FeedVH(private val binding: FeedItemBinding, override var delegate: Delegate<FeedDelegate>) :
    BaseVH<Feed, FeedDelegate>(binding) {

    override fun bind(data: Feed, position: Int) {
        binding.imageView.load(data.imageUrl) {
            placeholder(R.drawable.ic_launcher_background)
        }
        binding.title.text = "Decccccccccccc"
        binding.root.setOnClickListener {
            delegate.click(FeedDelegate.OnFeedClick(data.imageUrl ?: "empty"))
        }

    }


}

object VHFactory {
    fun getVH(
        viewType: Int,
        layoutInflater: LayoutInflater,
        delegate: Delegate<*>
    ): BaseVH<RVItem, *> {
        return when (viewType) {

            R.layout.feed_item -> {
                var del: Delegate<FeedDelegate> = delegate as Delegate<FeedDelegate>
                FeedVH(FeedItemBinding.inflate(layoutInflater), del) as BaseVH<RVItem, *>
            }

            else -> {
                TODO()
            }
        }

    }
}