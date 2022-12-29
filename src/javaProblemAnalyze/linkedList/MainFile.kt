package javaProblemAnalyze.linkedList

fun main() {

    var listNode = ListNode(3)
    listNode.next = ListNode(5)

}

data class ListNode<T>(var value: T) {
    var next: ListNode<T>? = null
}


/**
 * O(n) time complexity, n is the number of elements in l, and O(1) additional space complexity
 * 33333
 */

//head  5 ->4 -> 3 -> 2 -> 1


// current - 5 ; next  =  null;   prev = null; count = 0
// next = 4 -> 3- > 2 -> 1
// current.next = 5 ->  null
// prev = 5
// current  =  4 -> 3- > 2 -> 1
// count = 1

// next = 3 -> 2 -> 1
// current.next = 3 -> null
// prev = 3
// current = 3->2->1


// next = 2->1
//




//fun solution(l: ListNode<Int>?, k: Int): ListNode<Int>? {
//
//}