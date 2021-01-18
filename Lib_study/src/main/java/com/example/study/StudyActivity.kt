package com.example.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.*


class StudyActivity : AppCompatActivity() {
    // 1.创建一个MainScope
    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.study_activity)
        val mCoroutineTv = findViewById<TextView>(R.id.mCoroutineTv)

        // 2.启动协程 Dispatchers是调度器
        scope.launch(Dispatchers.Main) {
            // 执行并发任务
            val one = async { getResult(20) }
            val two = async { getResult(40) }
            mCoroutineTv.text = (one.await() + two.await()).toString()
        }
    }

    // 3.销毁的时候释放
    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    private suspend fun getResult(num: Int): Int {
        delay(5000L) // 非阻塞线程5秒钟
        return withContext(Dispatchers.IO) {
            num * num
        }
    }
}