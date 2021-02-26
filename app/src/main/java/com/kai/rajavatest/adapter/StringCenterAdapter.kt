package com.kai.rajavatest.adapter

import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kai.rajavatest.R

/**
 *
 * @ProjectName:    RajavaTest
 * @Description:     java类作用描述
 * @Author:         pressureKai
 * @UpdateDate:     2021/2/26 10:32
 */
class StringCenterAdapter:BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_string_center) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.getView<TextView>(R.id.item_name).text = item
        val line = holder.getView<View>(R.id.line)
        val itemPosition = getItemPosition(item)
        if(itemPosition == data.size - 1){
            line.visibility = View.GONE
        } else {
            line.visibility = View.VISIBLE
        }
    }
}