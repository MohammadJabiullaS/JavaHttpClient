**1. HttpURLConnection (Old School)**
------------------------------------------
Introduced: Java 1.1 (as part of java.net).

Blocking API: You open a connection, write to it, and read the response — all synchronously.

Usage:

java
Copy
Edit
URL url = new URL("https://example.com");
HttpURLConnection con = (HttpURLConnection) url.openConnection();
con.setRequestMethod("GET");

try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
    String line;
    while ((line = in.readLine()) != null) {
        System.out.println(line);
    }
}
con.disconnect();
Pros:

Built into Java SE (no extra dependencies).

Works fine for simple GET/POST requests.

Cons:

Verbose and clunky for modern use.

No built-in async or reactive support.

Limited configuration flexibility.

Harder to deal with cookies, redirects, timeouts, and request building compared to newer APIs.

**2. HttpClient (New & Shiny)**
--------------------------------------
Introduced: Java 11 (java.net.http.HttpClient).

Modern API: Supports both synchronous and asynchronous (non-blocking) calls.

HTTP/2 Support: Out of the box.

Easier Request Building:

java
Copy
Edit
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://example.com"))
    .GET()
    .build();

HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
System.out.println(response.body());
Async Example:

java
Copy
Edit
client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
      .thenApply(HttpResponse::body)
      .thenAccept(System.out::println);
Pros:

Cleaner, less boilerplate code.

Async and HTTP/2 support.

Built-in JSON, file, and string body handlers.

Cons:

Only available in Java 11+ (or backported via external libs).

Slight learning curve for async API if you’ve never used CompletableFuture.

Bottom line
If you’re on Java 11+, use HttpClient — it’s faster, cleaner, and future-proof.

If you’re stuck on Java 8 or lower, HttpURLConnection is your default option unless you bring in a third-party HTTP library like Apache HttpClient or OkHttp.

