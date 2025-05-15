import java.util.Base64;

class Foo {
  public String foo(final byte[] arr) {
    return Base64.getUrlEncoder().encodeToString(arr);
  }
}