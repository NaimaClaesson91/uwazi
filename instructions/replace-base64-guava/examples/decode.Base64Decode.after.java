import java.util.Base64;

class Foo {
  public void foo() {
    final byte[] decoded = Base64.getDecoder().decode("hello");
  }
}
