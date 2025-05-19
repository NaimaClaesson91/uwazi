# AI Migration Shifts

!!! info  "This work is experimental"

AI Migration Shifts are a way to shift code from one shape to another using AI.

## Getting started

To get started with AI Migration Shifts, follow these steps:

1. **Join** the `honk-users` Bandmanager group:
    - https://backstage.spotify.net/bandmanager/honk-users@spotify.com

2. **Create** a new AI Migration Shift:
    - https://backstage.spotify.net/create/templates/default/ai-migration-shift-skeleton

3. **Refer** to the Honk documentation for more information on how to Honk 🪿:
    - https://backstage.spotify.net/docs/default/component/honk

## Trying out your shift

You can try a migration against a repo, before committing to master, using [fleetshift-cli]:

```shell
$ npm install -g @spotify-internal/fleetshift-cli --registry https://artifactory.spotify.net/artifactory/api/npm/virtual-npm
$ fleetshift run -m shifts/replace-guava-base64.yaml --repo iam/auth-common --nobuild
```

<!-- prettier-ignore -->
!!! Tip "Join the #ai-assisted-migrations channel"
    If you have any questions or need help, join us in
the [#ai-assisted-migrations](https://spotify.enterprise.slack.com/archives/C084MKZRPCH) channel!


[fleetshift-cli]: https://ghe.spotify.net/charud/fleetshift-cli
