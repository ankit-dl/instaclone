package com.ankit.inguram.data.model

import base.RVItem

class Feed(val imageUrl: String?, override val viewType: Int, val title: String) : RVItem {
}