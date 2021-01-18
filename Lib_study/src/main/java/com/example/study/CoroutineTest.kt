package com.example.study

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * 协程练习
 *
 * @author WangQingYi
 * @since  2021/1/14
 */
class CoroutineTest {
    fun test1() {
        /**
         * GlobalScope: 协程的作用域
         * Dispatchers: 调度器
         * launch: 协程构建器
         */
        GlobalScope.launch(Dispatchers.Main) {


        }
    }
}