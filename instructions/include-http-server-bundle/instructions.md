# Include HTTP Server Bundle

You must actually perform these tasks. Do not give me a list of instructions or a plan, do the work yourself.

There is a YAML block that configures the apollo template. It looks like this:

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

If there are no files to modify then do nothing.