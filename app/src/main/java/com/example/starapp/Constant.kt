package com.example.starapp

object Constant {
    private const val WEB_VIEW_LOAD_URL =
        "https://img.etimg.com/thumb/msid-72948091,width-650,imgsize-95069,resizemode-4,qualit.jpg"
    const val WEB_VIEW_DATA =
        "<html><body ><img id=\"resizeImage\" src=\"$WEB_VIEW_LOAD_URL\" width=\"100%\" height=\"100%\" alt=\"\" align=\"middle\" /></body></html>"
    const val WEB_VIEW_MIME_TYPE = "text/html; charset=UTF-8"
}