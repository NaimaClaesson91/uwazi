# Shift skeleton

A new shift for Fleetshift. The manifest lives in [kubernetes/shift.yaml](shifts/update-component-type.yaml).

See the status of this shift in Backstage: https://backstage.spotify.net/fleetshift/shifts/ai-migrations

## Enable declarative-infra for this project

In order for this project to work you need to enable declarative infra for this project and repository.

You do this via this link: https://backstage.spotify.net/projects/genai-migration-experiment/declarative-infra/access//ai-migrations

## Testing

### Fleetshift testing

You can use the [fleetshift-cli](https://ghe.spotify.net/charud/fleetshift-cli) to test-run your shift against a repository like this:

```
$ fleetshift run --pr --repo <target-repo>
```

Note that fleetshift-cli is a hack project that's not officially supported by a team.

## Develop

### Templates

Test the template generation locally by:

1. Go to https://backstage.spotify.net/create/template
2. Click **File** > **Open Template Directory**
3. Choose e.g. `~/dev/ai-migrations/templates/honk-with-goose`
4. Select the `template.yaml` file
5. Fill in the form and click **Review** > **Create**

```
./scripts/generate-from-template.sh templates/honk-with-goose
```
