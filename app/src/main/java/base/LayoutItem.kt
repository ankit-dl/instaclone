package base

import com.ankit.inguram.R

sealed class LayoutItem {

    class FeedItem(val id: Int) : LayoutItem()
}