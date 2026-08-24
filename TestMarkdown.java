import burp.ui.MarkdownUtil;

public class TestMarkdown {
    public static void main(String[] args) {
        String req = "GET /projects/c29dcbf4-5481-4f2f-8e99-7134eb27f4d3/download-zip HTTP/2\n\nHost: api.lovable.dev\nUser-Agent: test";
        String html = "<pre class='http-code-box'>" + MarkdownUtil.escapeHtml(req) + "</pre>";
        System.out.println(MarkdownUtil.toHtml(html));
    }
}
