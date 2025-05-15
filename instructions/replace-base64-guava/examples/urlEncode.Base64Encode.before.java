import com.google.common.io.BaseEncoding;

class Foo {
  public String foo(final byte[] arr) {
    return BaseEncoding.base64Url().encode(arr);
  }
}