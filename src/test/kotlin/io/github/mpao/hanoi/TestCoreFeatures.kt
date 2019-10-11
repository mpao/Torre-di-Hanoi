package io.github.mpao.hanoi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.pow

class TestCoreFeatures{

    @Test
    fun explainAndTestAlgorithmForFourElements(){
        val size = 4
        val initial = Stack<Int>()
        val middle = Stack<Int>()
        val final = Stack<Int>()
        initial.init(size)
        val minMoves = (2.toDouble().pow(size)-1).toInt()
        var moves = 0
        // X
        // XX
        // XXX
        // XXXX
        initial.pop()?.let { middle.push(it) }
        moves++ // 1
        // 
        // XX
        // XXX
        // XXXX  X
        initial.pop()?.let { final.push(it) }
        moves++ // 2
        // 
        // 
        // XXX
        // XXXX  X  XX
        middle.pop()?.let { final.push(it) }
        moves++ // 3
        // 
        // 
        // XXX      X
        // XXXX     XX
        initial.pop()?.let { middle.push(it) }
        moves++ // 4
        // 
        // 
        //            X
        // XXXX  XXX  XX
        final.pop()?.let { initial.push(it) }
        moves++ // 5
        //
        //
        // X
        // XXXX  XXX  XX
        final.pop()?.let { middle.push(it) }
        moves++ // 6
        //
        //
        // X     XX
        // XXXX  XXX
        initial.pop()?.let { middle.push(it) }
        moves++ // 7
        //
        //       X
        //       XX
        // XXXX  XXX
        initial.pop()?.let { final.push(it) }
        moves++ // 8
        //
        //       X
        //       XX
        //       XXX  XXXX
        middle.pop()?.let { final.push(it) }
        moves++ // 9
        //
        //
        //       XX   X
        //       XXX  XXXX
        middle.pop()?.let { initial.push(it) }
        moves++ // 10
        //
        //
        //            X
        // XX    XXX  XXXX
        final.pop()?.let { initial.push(it) }
        moves++ // 11
        //
        //
        // X
        // XX    XXX  XXXX
        middle.pop()?.let { final.push(it) }
        moves++ // 12
        //
        //
        // X        XXX
        // XX       XXXX
        initial.pop()?.let { middle.push(it) }
        moves++ // 13
        //
        //
        //          XXX
        // XX   X   XXXX
        initial.pop()?.let { final.push(it) }
        moves++ // 14
        //
        //          XX
        //          XXX
        //      X   XXXX
        middle.pop()?.let { final.push(it) }
        moves++ // 15
        //          X
        //          XX
        //          XXX
        //          XXXX
        assertEquals(moves, minMoves)
        assertEquals(initial.size(), 0)
        assertEquals(middle.size(), 0)
        assertEquals(final.size(), size)
        for (i in 1..size){
            assertEquals(final.peek(), i)
            final.pop()
        }
    }

    @Test
    fun solveRecursively(){
        val size = 4
        val initial = Stack<Int>()
        val middle = Stack<Int>()
        val final = Stack<Int>()
        initial.init(size)
        resolve(size, initial, middle, final)
        assertEquals(initial.size(), 0)
        assertEquals(middle.size(), 0)
        assertEquals(final.size(), size)
        for (i in 1..size){
            assertEquals(final.peek(), i)
            final.pop()
        }
    }

}