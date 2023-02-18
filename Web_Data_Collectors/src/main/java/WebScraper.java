import javax.lang.model.util.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.util.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

  public class WebScraper {

    public static void main(String[] args) throws IOException {
      String url = "https://www.example.com/blog";
      List<BlogPost> posts = scrapeTextData(url);
      for (BlogPost post : posts) {
        System.out.println(post);
      }
    }

    public static List<BlogPost> scrapeTextData(String url) throws IOException {
      List<BlogPost> posts = new ArrayList<>();

      // Send an HTTP GET request to the blog page
      Document doc = Jsoup.connect(url).get();

      // Use a CSS selector to find the list of blog posts
      Elements postElements = doc.select(".blog-posts li");

      // Iterate over the blog post elements and extract the data
      for (Element postElement : postElements) {
        String title = postElement.select("h2 a").text();
        String excerpt = postElement.select(".excerpt").text();
        String permalink = postElement.select("h2 a").attr("href");
        BlogPost post = new BlogPost(title, excerpt, permalink);
        posts.add(post);
      }

      return posts;
    }

    public static class BlogPost {
      private String title;
      private String excerpt;
      private String permalink;

      public BlogPost(String title, String excerpt, String permalink) {
        this.title = title;
        this.excerpt = excerpt;
        this.permalink = permalink;
      }

      @Override
      public String toString() {
        return "BlogPost{" +
                "title='" + title + '\'' +
                ", excerpt='" + excerpt + '\'' +
                ", permalink='" + permalink + '\'' +
                '}';
      }
    }
  }