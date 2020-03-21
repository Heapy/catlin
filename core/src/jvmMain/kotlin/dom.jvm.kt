actual fun Node.render(root: String): String? {
    return """
    <!doctype html>
    <html lang="en">
    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, 
minimum-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>Document</title>
    </head>
    <body>
      <$type id="$root">$content${renderAll(this)}</$type>
    </body>
    </html>
    """.trimIndent()
}

fun renderAll(node: Node): String {
    return node.children.joinToString {
        """<${it.type}>${it.content}${renderAll(it)}</${it.type}>"""
    }
}

fun main() {
    println(helloWorldPage.render("root"))
}
