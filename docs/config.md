After you've created the shift using
the [backstage template](https://backstage.spotify.net/create/templates/default/ai-migration-shift-skeleton) you can configure a few different areas.

Specifically [the Honk](#the-honk), [target repos](#target-repos), and if using the Duck agent [examples and target files](#examples-and-target-files).

### The Honk

In your ```shift.yaml``` you will find a section to configure your Honk. The args allows is your main way to control what Honk does.

```yaml
      image: gcr.io/genai-migration-experiment/gaggle:latest
      args:
        [
          "--no-goose-in-docker",
          "run",
          "gs://honk-plans/instructions/${{ shift_name }}/instructions.md",
        ]
      nonRootUser: true
```

For example if you want to use another model you can set it in the args by passing ```--model=o3-mini```.

!!! Plans and examples in GCS
    Plans and examples are stored in GCS allows us to use the same container for all shifts. Your **examples and plans are automatically uploaded to GCS**  when the master build runs.

### Target repos

You will  need to configure the target repos in your ```shift.yaml```. Example below:

```yaml
  targets:
    where:
      allMatch:
        - component:
            lifecycle: experimental
        - subpath:
            at: "**/*.java"
            withContentsMatching: "BaseEncoding.base64()"
    unless:
      inList:
        - repository: spotify/services-pilot
        - repository: genai-migration/ai-migrations
```

!!! Start small
    We recommend you start small. Perhaps iterating on a single system or repo to keep costs low. Expand the scope gradually.

### Examples and target files

This is only applicable if you are using the Duck agent 🦆. Activate the Duck Agent by passing ```---agent duck``` to your Honk. 

The Duck 🦆 agent supports the ability to add examples and a grep command for targeting.

The examples should be uploaded in a folder called ```examples``` next to your instructions. The ```--git-grep``` allows you to select which exact files the Duck agent should run on. Example:

```yaml
    - name: honk
      image: gcr.io/genai-migration-experiment/gaggle:latest
      args:
        - "--model=o3-mini"
        - "--no-goose-in-docker"
        - "--agent"
        - "duck"
        - "run"
        - "--examples"
        - "gs://honk-plans/instructions/replace-base64-guava/examples"
        - "--git-grep"
        - "git grep -l 'BaseEncoding' -- '*.java'"
        - "gs://honk-plans/instructions/replace-base64-guava/instructions.md"
      nonRootUser: true
```


