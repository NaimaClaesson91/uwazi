# Include HTTP Server Bundle

You must actually perform these tasks. Do not give me a list of instructions or a plan, do the work yourself.

Some background. There is a YAML block that configures the apollo template. It looks like this:

```
panels:
- template: apollo
  type: bundle
  # ... more yaml keys here
```

You need to add the key/value pair `include_http_server: true` to that block and that block alone. So for the above
you would change it to be:

```
panels:
- template: apollo
  type: bundle
  include_http_server: true
  # ... all of the yaml that was previously present
```

YOU MUST ONLY ADD THE LINE `include_http_server: true` MAKE NO OTHER CHANGES. DO NOT MODIFY ANYTHING
ELSE IN THE FILE.

YOU MUST ONLY CHANGE YAML BLOCKS IN panels WITH THE EXACT KEY/value `template: apollo`:

```
panels:
- template: apollo
  type: bundle
```

THERE WILL ONLY BE ONE SUCH YAML BLOCK PER FILE.

DO NOT CHANGE ANY BLOCK OUTSIDE THE `panels` list.

First find all `monitoring-info.yaml` files in the working directory using this command:

```
find . -name monitoring-info.yaml -exec grep -E --files-with-matches "template: apollo\s*" {} \;
```

Then for every file that you have found apply the changes described above.

To verify you have done the correct thing run the following command:

```
git diff
```

The only change you should see per file in the diff output is:

```
+      include_http_server: true
```

With minor variations in whitespace.

If you see other lines added, removed or changed YOU HAVE MADE A MISTAKE AND MUST NOT COMMIT.
