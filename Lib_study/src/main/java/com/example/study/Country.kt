package com.example.study

data class Country(
    val name: String,
    val continent: String, // 大陆
    val population: Int,
)

class CountryApp {
    /**
     * 对单一国家进行匹配
     */
    fun filterCountries(countries: List<Country>): List<Country> {
        val res = mutableListOf<Country>()
        countries.forEach { item ->
            if (item.continent == "英国") {
                res.add(item)
            }
        }
        return res
    }

    /**
     * 对输入的国家进行匹配
     * @param countries 国家集合
     * @param country 国家
     */
    fun filterCountries1(countries: List<Country>, country: String): List<Country> {
        val res = mutableListOf<Country>()
        countries.forEach { item ->
            if (item.continent == country) {
                res.add(item)
            }
        }
        return res
    }

    /**
     * 增加筛选人口
     */
    fun filterCountries2(
        countries: List<Country>,
        country: String,
        population: Int,
    ): List<Country> {
        val res = mutableListOf<Country>()
        countries.forEach { item ->
            if (item.continent == country && item.population > population) {
                res.add(item)
            }
        }
        return res
    }

    /**
     * 使用高阶函数
     */
    fun filterCountries3(
        countries: List<Country>,
        test1: (Country) -> Boolean,
    ): List<Country> {
        val res = mutableListOf<Country>()
        countries.forEach { item ->
            if (test1(item)) {
                res.add(item)
            }
        }
        return res
    }

    // 方法和成员引用
    class Book(val name: String)

    fun main1(array: Array<String>) {
        val getBook = ::Book
    }

    fun main2(array: Array<String>) {
        val bookName = listOf(
            Book("第一行代码"),
            Book("第二行代码")
        ).map(Book::name)
    }

    class CountryTest {
        fun isBiogEuropeanCountry(country: Country): Boolean {
            return country.continent == "EU" && country.population > 1000
        }

        private val countryApp = CountryApp()
        private val countryTest = CountryTest()
        private val countries = mutableListOf<Country>()
        val a = countryApp.filterCountries3(countries, countryTest::isBiogEuropeanCountry)
        fun test() {
            countryApp.filterCountries3(countries) { country ->
                country.continent == "EU" && country.population > 1000
            }
        }

        /**
         * Kotlin 中的函数类型声明需要遵循以下几点
         * 1.通过 -> 符号来组织参数类型和返回值类型
         * 2.必须用一个括号来包裹参数类型
         * 3.返回值类型即使是Unit，也必须显示声明
         */
        fun functionTest(
            name: String,
            age1: (Int) -> Unit,  // 例
            age2: () -> Unit,     // 如果是一个没有参数的函数类型，参数类型部分就用()来表示
            age3: (errCode: Int, errMsg: String?) -> Unit, // 为声明参数指定名称，在Unit后加上?就可以将函数变为可选(也就是可空类型)
            age4: (Int) -> ((Int) -> Unit),   // 高阶函数还支持返回另一种函数，这表示闯入一个类型为Int的参数然后返回另一个类型为(Int) -> Unit的函数
            age5: ((Int) -> Int) -> Unit,     // 表示传入一个函数类型的参数，在返回一个Unit
        ) {
        }
    }

    /**
     * LambdaTest
     * 总结Lambda语法：
     * 1.一个Lambda表达式必须通过{}来包裹
     * 2.如果Lambda声明了参数部分类型，且返回值类型支持类型推导，
     *   那么Lambda就可以省略函数类型声明
     * 3.如果Lambda变量声明了函数类型，那么Lambda的参数部分的类型就可以省略
     */
    fun lambdaTest() {

        val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
        // 由于支持类型推导，我们可以采用两种方式进行简化
        val sum1 = { x: Int, y: Int -> x + y }
        val sum2: (Int, Int) -> Int = { x, y -> x + y }
        val foo = {x:Int ->
            val y = x+1
         y
        }
    }

}