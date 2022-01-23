package base

interface Delegate<T> {
    fun click(data: T)
}