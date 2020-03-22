import org.w3c.dom.Element
import kotlin.browser.document
import kotlin.dom.appendText

actual fun Node.render(root: String): String? {
    val element = document.createElement(localName = type).also {
        it.appendText(content + "From JS")
        children.forEach { child ->
            it.appendChild(renderChild(child))
        }
    }

    document.querySelector("#$root")?.replaceWith(element)

    return null
}

fun renderChild(node: Node): Element {
    return document.createElement(localName = node.type).also {
        it.appendText(node.content)
        node.children.forEach { child ->
            it.appendChild(renderChild(child))
        }
    }
}
