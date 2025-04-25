# Shift skeleton

A new shift for Fleetshift. The manifest lives in [kubernetes/shift.yaml](shifts/template/shift.yaml).

See the status of this shift in Backstage: https://backstage.spotify.net/fleetshift/shifts/ai-migrations

## Enable declarative-infra for this project

In order for this project to work you need to enable declarative infra for this project and repository.

You do this via this link: https://backstage.spotify.net/projects/genai-migration-experiment/declarative-infra/access//ai-migrations

## Testing

### Unit testing

Unit tests are run using [codemod-testrunner](https://ghe.spotify.net/web-infra/codemod-testrunner). To run the tests locally, use the following command:

```shell
./scripts/test.sh
```

### Fleetshift testing

You can use the [fleetshift-cli](https://ghe.spotify.net/charud/fleetshift-cli) to test-run your shift against a repository like this:

```
$ fleetshift run --pr --repo <target-repo>
```

Note that fleetshift-cli is a hack project that's not officially supported by a team. 
