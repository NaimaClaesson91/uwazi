import com.google.common.io.BaseEncoding;

class Foo {
  public void foo() {
    final byte[] decoded = BaseEncoding.base64().decode("hello");
  }
}
