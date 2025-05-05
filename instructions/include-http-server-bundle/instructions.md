# Include HTTP Server Bundle

You must actually perform these tasks. Do not give me a list of instructions or a plan, do the work yourself.

Some background. There is a YAML block that configures the apollo template. It looks like this:

```
- template: apollo
  type: bundle
  # ... more yaml keys here
```

You need to add the key/value pair `include_http_server: true` to that block and that block alone. So for the above
you would change it to be:

```
- template: apollo
  type: bundle
  include_http_server: true
  # ... all of the yaml that was previously present
```

You only need to add this one key do not change, add, or remove any other YAML.

YOU MUST ONLY CHANGE YAML BLOCKS WITH THE KEYS:

```
- template: apollo
  type: bundle
```

THERE WILL ONLY BE ONE SUCH YAML BLOCK PER FILE.

First find all `monitoring-info.yaml` files in the working directory using this command:

```
find . -name monitoring-info.yaml
```

Then for every file that you have found apply the changes described above.


