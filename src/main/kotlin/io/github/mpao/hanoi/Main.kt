package io.github.mpao.hanoi

import kotlin.math.pow

/**
 * La Torre di Hanoi (anche conosciuta come Torre di Lucas dal nome del suo inventore)
 * è un rompicapo matematico composto da tre paletti e un certo numero di dischi di
 * grandezza decrescente, che possono essere infilati in uno qualsiasi dei paletti.
 *
 * Il gioco inizia con tutti i dischi incolonnati su un paletto in ordine decrescente,
 * in modo da formare un cono. Lo scopo del gioco è portare tutti i dischi su un paletto diverso,
 * potendo spostare solo un disco alla volta e potendo mettere un disco solo
 * su un altro disco più grande, mai su uno più piccolo.
 */
const val size = 4
var reverseCount = (2.toDouble().pow(size)-1).toInt()

/**
 * Implementazione struttura Stack
 */
class Stack<T>{
    private val elements: MutableList<T> = mutableListOf()

    fun push(item: T) = elements.add(item)
    fun pop(): T? = if (elements.isNotEmpty()) elements.removeAt(size() -1) else null
    fun peek(): T? = elements.lastOrNull()
    fun size(): Int = elements.size

    override fun toString(): String = elements.toString()
}

fun main() {
    val initial = Stack<Int>()
    val middle = Stack<Int>()
    val final = Stack<Int>()
    initial.init(size)
    println("Per risolvere questa torre occorrono $reverseCount mosse")
    resolve(size, initial, middle, final)
    println(final.toString())
}

/**
 * La soluzione base del gioco della torre di Hanoi si formula in modo ricorsivo.
 * Siano i paletti etichettati con A, B e C, e i dischi numerati da 1 (il più piccolo) a n (il più grande). L'algoritmo si esprime come segue:
 *     1. Sposta i primi n-1 dischi da A a B. (Questo lascia il disco n da solo sul paletto A)
 *     2. Sposta il disco n da A a C
 *     3. Sposta n-1 dischi da B a C
 * Per spostare n dischi si richiede di compiere un'operazione elementare (spostamento di un singolo disco) ed una complessa,
 * ossia lo spostamento di n-1 dischi. Tuttavia anche questa operazione si risolve nello stesso modo,
 * richiedendo come operazione complessa lo spostamento di n-2 dischi.
 * Iterando questo ragionamento si riduce il processo complesso ad uno elementare, ovvero lo spostamento di n-(n-1)=1 disco.
 * Questo è un algoritmo ricorsivo, di complessità esponenziale O(2^n)
 */
fun resolve(size: Int, initial: Stack<Int>, middle: Stack<Int>, final: Stack<Int>){
    if(size == 0){
        return
    }else{
        resolve(size-1, initial, final, middle)
        initial.pop()?.let { final.push(it) }
        println(reverseCount--)
        resolve(size-1, middle, initial, final)
    }
}

/**
 * Riempie lo stack iniziale con i valori che rappresentano
 * i dischi da spostare
 */
fun Stack<Int>.init(size: Int){
    for (i in size downTo 1)
        push(i)
}