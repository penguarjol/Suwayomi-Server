@file:Suppress("ktlint")
package gg.jte.generated.precompiled
import suwayomi.tachidesk.i18n.MR
import suwayomi.tachidesk.server.generated.BuildConfig
@Suppress("UNCHECKED_CAST", "UNUSED_PARAMETER")
class JteLoginGenerated {
companion object {
	@JvmField val JTE_NAME = "Login.kte"
	@JvmField val JTE_LINE_INFO = intArrayOf(0,0,0,1,3,3,3,3,3,10,10,10,10,151,151,151,155,155,155,156,156,156,156,156,156,156,156,156,157,157,157,158,158,158,158,158,158,158,158,158,161,161,161,166,166,166,170,170,170,3,4,4,4,4,4)
	@JvmStatic fun render(jteOutput:gg.jte.html.HtmlTemplateOutput, jteHtmlInterceptor:gg.jte.html.HtmlInterceptor?, locale:java.util.Locale, error:String) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n    <title>")
		jteOutput.setContext("title", null)
		jteOutput.writeUserContent(MR.strings.login_label_title.localized(locale))
		jteOutput.writeContent("</title>\n    <style>\n        * {\n            box-sizing: border-box;\n        }\n        html, body {\n            margin: 0;\n            padding: 0;\n            height: 100%;\n        }\n        body {\n            display: flex;\n            flex-direction: column;\n            background-color: rgb(12, 16, 33);\n            font-family: \"Roboto\",\"Helvetica\",\"Arial\",sans-serif;\n            font-weight: 400;\n            letter-spacing: 0em;\n        }\n        button[disabled], input[disabled] {\n            cursor: not-allowed;\n        }\n        header {\n            background-color: rgb(34, 38, 53);\n            box-shadow: rgba(0, 0, 0, 0.2) 0px 2px 4px -1px, rgba(0, 0, 0, 0.14) 0px 4px 5px 0px, rgba(0, 0, 0, 0.12) 0px 1px 10px 0px;\n            color: #fff;\n            padding: 8px 32px;\n        }\n        header h1, header p {\n            margin: 0;\n        }\n        footer {\n            color: #fff;\n            padding: 8px;\n        }\n        footer p {\n            margin: 0;\n            font-size: 0.7rem;\n        }\n        main {\n            height: 100%;\n        }\n        main {\n            position: relative;\n            padding-top: 24px;\n        }\n        form {\n            margin: 8px;\n            padding: 8px 24px;\n            border-radius: 8px;\n            border: 1px solid rgb(12, 16, 33);\n            background-color: rgb(6, 8, 16);\n            color: white;\n        }\n        .error {\n            margin: 8px;\n            padding: 8px 16px;\n            border-radius: 8px;\n            border: 1px solid #b71c1c;\n            background-color: #c62828;\n            color: white;\n        }\n        .error:empty {\n            display: none;\n        }\n        form label {\n            cursor: pointer;\n        }\n        form button {\n            all: unset;\n            padding: 8px;\n            line-height: 1.75;\n            text-align: center;\n            min-width: 64px;\n            border-radius: 4px;\n            padding: 6px 8px;\n            color: rgb(91, 116, 239);\n            text-transform: uppercase;\n            letter-spacing: 0.02857em;\n        }\n        form button:not([disabled]) {\n            cursor: pointer;\n        }\n        form button:not([disabled]):hover {\n            background-color: rgba(91, 116, 239, 0.08);\n        }\n        form input {\n            all: unset;\n            border-radius: 4px;\n            border: 1px solid rgba(255, 255, 255, 0.23);\n            padding: 6px 12px;\n            width: auto;\n            min-width: 0;\n        }\n        form input:hover {\n            border-color: white;\n        }\n        form input:focus {\n            border-color: rgb(91, 116, 239);\n        }\n        form .controls {\n            display: grid;\n            align-items: center;\n            grid-template-columns: 1fr;\n        }\n        form .controls > :nth-child(even):not(:last-child) {\n            margin-bottom: 6px;\n        }\n        form .submit {\n            display: flex;\n            flex-direction: column;\n            align-items: center;\n            margin-top: 24px;\n        }\n\n        @media (min-width: 500px) {\n            form {\n                width: 100%;\n                max-width: 450px;\n                margin: 8px auto;\n            }\n            .error {\n                width: 100%;\n                max-width: 450px;\n                margin: 8px auto;\n            }\n            form .controls {\n                grid-template-columns: auto 1fr;\n                column-gap: 16px;\n                row-gap: 6px;\n            }\n            form .controls > :nth-child(even):not(:last-child) {\n                margin-bottom: 0px;\n            }\n        }\n    </style>\n</head>\n<body>\n    <header>\n        <h1>Suwayomi</h1>\n    </header>\n    <main>\n        <div class=\"error\">")
		jteOutput.setContext("div", null)
		jteOutput.writeUserContent(error)
		jteOutput.writeContent("</div>\n        <form method=\"POST\">\n            <h2>Login</h2>\n            <div class=\"controls\">\n                <label for=\"user\">")
		jteOutput.setContext("label", null)
		jteOutput.writeUserContent(MR.strings.login_label_username.localized(locale))
		jteOutput.writeContent(":</label>\n                    <input type=\"text\" name=\"user\" id=\"user\" required")
		val __jte_html_attribute_0 = MR.strings.login_placeholder_username.localized(locale)
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" placeholder=\"")
			jteOutput.setContext("input", "placeholder")
			jteOutput.writeUserContent(__jte_html_attribute_0)
			jteOutput.setContext("input", null)
			jteOutput.writeContent("\"")
		}
		jteOutput.writeContent("/>\n                    <label for=\"pass\">")
		jteOutput.setContext("label", null)
		jteOutput.writeUserContent(MR.strings.login_label_password.localized(locale))
		jteOutput.writeContent(":</label>\n                    <input type=\"password\" name=\"pass\" id=\"pass\" required")
		val __jte_html_attribute_1 = MR.strings.login_placeholder_password.localized(locale)
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" placeholder=\"")
			jteOutput.setContext("input", "placeholder")
			jteOutput.writeUserContent(__jte_html_attribute_1)
			jteOutput.setContext("input", null)
			jteOutput.writeContent("\"")
		}
		jteOutput.writeContent("/>\n            </div>\n            <div class=\"submit\">\n                <button type=\"submit\">")
		jteOutput.setContext("button", null)
		jteOutput.writeUserContent(MR.strings.login_label_login.localized(locale))
		jteOutput.writeContent("</button>\n            </div>\n        </form>\n    </main>\n    <footer>\n        <p>Suwayomi: ")
		jteOutput.setContext("p", null)
		jteOutput.writeUserContent(MR.strings.label_version.localized(locale, BuildConfig.VERSION))
		jteOutput.writeContent("</p>\n    </footer>\n</body>\n</html>\n")
	}
	@JvmStatic fun renderMap(jteOutput:gg.jte.html.HtmlTemplateOutput, jteHtmlInterceptor:gg.jte.html.HtmlInterceptor?, params:Map<String, Any?>) {
		val locale = params["locale"] as java.util.Locale
		val error = params["error"] as String
		render(jteOutput, jteHtmlInterceptor, locale, error);
	}
}
}
