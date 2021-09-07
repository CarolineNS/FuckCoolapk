/*
 * Fuck Coolapk - Best present for 316 and 423
 * Copyright (C) 2020-2021
 * https://github.com/ejiaogl/FuckCoolapk
 *
 * This software is non-free but opensource software: you can redistribute it
 * and/or modify it under the terms of the GNUGeneral Public License as
 * published by the Free Software Foundation; either version 3 of the License,
 * or any later version and our eula as published by ejiaogl.
 *
 * This software is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License and
 * eula along with this software.  If not, see
 * <https://www.gnu.org/licenses/>
 * <https://github.com/ejiaogl/FuckCoolapk/blob/master/LICENSE>.
 */

package com.fuckcoolapk.module

import android.view.View
import com.fuckcoolapk.utils.OwnSP
import com.fuckcoolapk.utils.ktx.callMethod
import com.fuckcoolapk.utils.ktx.findClass
import com.fuckcoolapk.utils.ktx.getObjectField
import com.fuckcoolapk.utils.ktx.replaceMethod

class RemoveFeedGoods {

    fun init() {
        if (OwnSP.ownSP.getBoolean("removeFeedGoods", false)) {
            val item = "com.coolapk.market.model.HolderItem".findClass()
            "com.coolapk.market.view.feed.reply.FeedBindGoodsViewHolder".replaceMethod("bindToContent", item) {
                val titleView = it.thisObject.callMethod("getBinding")?.getObjectField("titleView") as? View
                titleView?.visibility = View.GONE
                null
            }
        }
    }

}