package section_20_networkprogramming._04_uriurl;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        printPartsExample();
        resolvedUri();
        relativizing();
    }

    public static void printPartsExample() {
        try {
            // URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            print(uri);
            System.out.println("===============");
            // uri = new URI("/catalogue/phones?os=android#samsung");
            // URL url = uri.toURL(); // IllegalArgumentException: URI is not absoulute
            uri = new URI("hello");
            print(uri);
        } catch (URISyntaxException e) {
            System.out.println("URI Bad Syntax: " + e.getMessage());
        }
    }

    private static void print(URI uri) {
        System.out.println("Scheme = " + uri.getScheme());
        System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
        System.out.println("Authority = " + uri.getAuthority());
        System.out.println("User info = " + uri.getUserInfo());
        System.out.println("Host = " + uri.getHost());
        System.out.println("Port = " + uri.getPort());
        System.out.println("Path = " + uri.getPath());
        System.out.println("Query = " + uri.getQuery());
        System.out.println("Fragment = " + uri.getFragment());
    }

    public static void resolvedUri() {
        try {
            URI baseUri = new URI("http://username:password@mynewserver.com:5000");
            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
            URI uri3 = new URI("/stores/locations?zip=1234");

            URI resolvedUri1 = baseUri.resolve(uri1);
            URI resolvedUri2 = baseUri.resolve(uri2);
            URI resolvedUri3 = baseUri.resolve(uri3);

            URL url1 = resolvedUri1.toURL();
            System.out.println("URL = " + url1);
            URL url2 = resolvedUri2.toURL();
            System.out.println("URL = " + url2);
            URL url3 = resolvedUri3.toURL();
            System.out.println("URL = " + url3);

        } catch (URISyntaxException e) {
            System.out.println("URI Bad Syntax: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException: " + e.getMessage());
        }
    }

    public static void relativizing() {
        try {
            URI baseUri = new URI("http://username:password@myserver.com:5000");
            URI uri = new URI("/catalogue/phones?os=android#samsung");
            URI resolvedUri =baseUri.resolve(uri);

            URI relativizedUri = baseUri.relativize(resolvedUri);
            System.out.println("\nRelativized URI: " + relativizedUri);
        } catch (URISyntaxException e) {
            System.out.println("URI Bad Syntax: " + e.getMessage());
        }
    }

}
