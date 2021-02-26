package com.kai.rajavatest.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kai.rajavatest.R
import com.kai.rajavatest.adapter.StringCenterAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val knowledgePoints = arrayListOf<String>("基类", "操作方法", "常用名词解析", "实用小技巧")
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = StringCenterAdapter()
        (list.adapter as StringCenterAdapter).setNewInstance(knowledgePoints)
        (list.adapter as StringCenterAdapter).setOnItemClickListener { adapter, _, position ->
            when (adapter.data[position]) {
                "基类" -> {
                    val intent = Intent(this, RxjavaBaseClassActivity::class.java)
                    startActivity(intent)
                }
                "操作方法" -> {
                    
                }
                "实用小技巧" -> {
                    
                }
                "常用名词解析" -> {

                }
            }
        }
    }
}