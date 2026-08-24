import javax.swing.*;
import burp.ui.MarkdownUtil;

public class TestSwingHtml {
    public static void main(String[] args) {
        String md = "```http\nGET /projects/c29dcbf4-5481-4f2f-8e99-7134eb27f4d3/download-zip HTTP/2\nHost: api.lovable.dev\n```";
        String htmlFromMd = MarkdownUtil.toHtml(md);
        System.out.println("=== HTML FROM MARKDOWN CODE BLOCK ===");
        System.out.println(htmlFromMd);

        String rawHtml = "<pre class='http-code-box'>GET /projects/c29dcbf4-5481-4f2f-8e99-7134eb27f4d3/download-zip HTTP/2\nHost: api.lovable.dev</pre>";
        String htmlFromRaw = MarkdownUtil.toHtml(rawHtml);
        System.out.println("\n=== HTML FROM RAW PRE ===");
        System.out.println(htmlFromRaw);
    }
}
