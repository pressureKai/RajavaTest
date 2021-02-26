package com.kai.rajavatest.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kai.rajavatest.R
import com.kai.rajavatest.adapter.StringCenterAdapter
import kotlinx.android.synthetic.main.activity_main.*

/**
 *
 * @ProjectName:    RajavaTest
 * @Description:     java类作用描述
 * @Author:         pressureKai
 * @UpdateDate:     2021/2/26 11:14
 */
class RxjavaBaseClassActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxjava_base_class)
        val knowledgePoints = arrayListOf<String>("Flowable", "Observable", "Single","Completable","Maybe")
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = StringCenterAdapter()
        (list.adapter as StringCenterAdapter).setNewInstance(knowledgePoints)
        (list.adapter as StringCenterAdapter).setOnItemClickListener { adapter, _, position ->
            val name = adapter.data[position] as String
            when (name) {
                "Flowable" -> {
                    goDetailActivity(name,"发送0个N个的数据，支持Reactive-Streams和背压")
                }
                "Observable" -> {
                    goDetailActivity(name,"发送0个N个的数据，不支持背压")
                }
                "Single" -> {
                    goDetailActivity(name,"只能发送单个数据或者一个错误")
                }
                "Completable" -> {
                    goDetailActivity(name,"没有发送任何数据，但只处理 onComplete 和 onError 事件")
                }
                "Maybe" -> {
                    goDetailActivity(name,"能够发射0或者1个数据，要么成功，要么失败")
                }
            }
        }
    }



    private fun goDetailActivity(name :String,desContent :String){
        val intent = Intent(this,RxjavaBaseClassDetailActivity::class.java)
        intent.putExtra("name",name)
        intent.putExtra("desContent",desContent)
        startActivity(intent)
    }
}