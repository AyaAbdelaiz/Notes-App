package com.ayaabdelaziz.mynotes


fun compare(a: Array<Int>, b: Array<Int>): Array<Int> {
    var alice = 0
    var bob = 0
    var ar = Array<Int>(2) { 0 }
    for (i in 0 until a.size) {
        if (a.get(i) > b.get(i)) {
            alice++
        }
        if (a.get(i) < b.get(i)) {
            bob++
        }
        ar[0] = alice
        ar[1] = bob
    }

    return ar

}

fun main() {

    var a = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    var b = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    var res = compare(a, b)
    for(i in res){
        print(i)
    }


}