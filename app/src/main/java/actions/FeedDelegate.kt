package actions

sealed class FeedDelegate {

    class OnFeedClick(val url: String) : FeedDelegate()
}