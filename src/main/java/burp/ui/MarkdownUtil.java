package burp.ui;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;

public class MarkdownUtil {
    private static final Parser PARSER;
    private static final HtmlRenderer RENDERER;

    static {
        MutableDataSet options = new MutableDataSet();
        PARSER = Parser.builder(options).build();
        RENDERER = HtmlRenderer.builder(options).build();
    }

    public static String escapeHtml(String text) {
        if (text == null) return "";
        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;")
                   .replace("\"", "&quot;")
                   .replace("'", "&#39;");
    }

    public static String toHtml(String markdown) {
        if (markdown == null || markdown.isEmpty()) {
            return "";
        }
        String bodyHtml = RENDERER.render(PARSER.parse(markdown));

        // Modern, high-contrast dark theme matching AIAssistantProRedesigned
        return "<html><head><style>"
                + "body { font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; font-size: 13px; line-height: 1.6; padding: 12px; margin: 0; background-color: #18181c; color: #d4d4d8; }"
                + "h1, h2, h3, h4 { color: #f4f4f5; font-weight: 600; margin-top: 14px; margin-bottom: 6px; border-bottom: 1px solid #27272a; padding-bottom: 4px; }"
                + "h3 { color: #a855f7; border-bottom: none; font-size: 14px; font-weight: bold; }"
                + "p { margin-top: 0; margin-bottom: 10px; color: #e4e4e7; }"
                + "code { font-family: 'JetBrains Mono', 'Fira Code', 'Consolas', monospace; background-color: #27272a; color: #f97316; padding: 2px 6px; border-radius: 4px; font-size: 12px; }"
                + "pre { font-family: 'JetBrains Mono', 'Fira Code', 'Consolas', monospace; background-color: #09090b; color: #f4f4f5; padding: 12px; border-radius: 8px; overflow-x: auto; font-size: 12px; border: 1px solid #27272a; line-height: 1.4; white-space: pre-wrap; word-wrap: break-word; }"
                + "pre code { background-color: transparent; padding: 0; color: #38bdf8; }"
                + "blockquote { border-left: 3px solid #a855f7; margin: 0 0 12px 0; padding-left: 12px; color: #a1a1aa; background-color: #1f1f23; padding-top: 6px; padding-bottom: 6px; border-radius: 0 6px 6px 0; }"
                + "ul, ol { margin-top: 0; margin-bottom: 10px; padding-left: 20px; color: #e4e4e7; }"
                + "li { margin-bottom: 6px; color: #e4e4e7; }"
                + "li::marker { color: #a855f7; }"
                + "table { border-collapse: collapse; width: 100%; margin-bottom: 12px; border-radius: 6px; overflow: hidden; }"
                + "th, td { border: 1px solid #27272a; padding: 8px 12px; text-align: left; font-size: 12px; }"
                + "th { background-color: #27272a; color: #f4f4f5; font-weight: 600; }"
                + "td { background-color: #1f1f23; }"
                + "hr { border: none; border-top: 1px solid #27272a; margin: 16px 0; }"
                + ".msg-meta { font-size: 11px; color: #a1a1aa; margin-top: -2px; margin-bottom: 8px; font-weight: normal; }"
                + ".user-bubble { background-color: #323746; border: 1px solid #484f63; border-radius: 8px; padding: 12px; margin-bottom: 14px; }"
                + ".user-bubble h3 { color: #a855f7; margin-bottom: 2px; }"
                + ".ai-bubble { background-color: #2b2b2b; border: 1px solid #3c3c3c; border-radius: 8px; padding: 12px; margin-bottom: 14px; }"
                + ".ai-bubble h3 { color: #a855f7; margin-bottom: 2px; }"
                + ".http-code-box { background-color: #09090b; border: 1px solid #3f3f46; border-radius: 6px; padding: 10px; margin: 8px 0; font-family: 'JetBrains Mono', 'Fira Code', 'Consolas', monospace; font-size: 12px; color: #f4f4f5; white-space: pre-wrap; word-wrap: break-word; overflow-x: auto; line-height: 1.4; }"
                + "</style></head><body>"
                + bodyHtml
                + "</body></html>";
    }
}
