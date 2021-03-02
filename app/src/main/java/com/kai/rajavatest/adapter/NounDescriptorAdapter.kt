package com.kai.rajavatest.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kai.rajavatest.R
import com.kai.rajavatest.entity.NounDescriptor

class NounDescriptorAdapter :BaseQuickAdapter<NounDescriptor,BaseViewHolder>
                       (R.layout.item_base_detail){
    override fun convert(holder: BaseViewHolder, item: NounDescriptor) {

        val name = holder.getView<TextView>(R.id.name)
        val content = holder.getView<TextView>(R.id.content)

        name.text = item.name
        content.text = item.descriptor
    }
}