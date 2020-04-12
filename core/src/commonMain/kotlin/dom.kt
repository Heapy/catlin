// External event: interactions, network responses, timers
interface HostTree

data class Node(
    val type: String,
    val children: List<Node>,
    val content: String
) : HostTree

data class NodeBuilder(
    val children: MutableList<Node> = mutableListOf(),
    var content: String = ""
)

fun node(type: String, builder: NodeBuilder.() -> Unit): Node {
    val cache = NodeBuilder()
    builder(cache)
    return Node(type, cache.children.toList(), cache.content)
}

fun NodeBuilder.node(type: String, builder: NodeBuilder.() -> Unit) {
    val cache = NodeBuilder()
    builder(cache)
    children.add(Node(type, cache.children.toList(), cache.content))
}

expect fun Node.render(root: String): String?
