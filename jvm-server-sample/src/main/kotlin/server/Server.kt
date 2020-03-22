package server

import helloWorldPage
import io.undertow.Undertow
import io.undertow.server.HttpHandler
import io.undertow.server.handlers.resource.PathResourceManager
import io.undertow.server.handlers.resource.ResourceHandler
import io.undertow.util.Headers
import render
import java.nio.file.Paths

fun main() {
    val resources = Paths.get("js-ui-sample/build/distributions")
    println(resources.toAbsolutePath())
    val rootHandler = ResourceHandler(PathResourceManager(resources), HttpHandler {
        it.responseHeaders.add(Headers.CONTENT_TYPE, "text/html")
        it.responseSender.send(helloWorldPage.render("root"))
    }
    )
    Undertow.builder()
        .addHttpListener(8080, "localhost", rootHandler)
        .build().start()
}
