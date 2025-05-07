# Service Info classification

Your task is to update the `component_type` in the service-info.yaml file.
An example service-info.yaml file is provided below.

```
id: a-id-with-hyphens
description: This is a description
system: a-system-name
owner: the-owner
visibility: public
facts:
  component_type: service
  lifecycle: production
  slack_channel: slackchannel
  support_email: the-owner@spotify.com
  alert_email: the-owner@spotify.com
```

## Instructions

You should not give me a plan for this task, instead you should perform update the files.

1. Start by getting the relevant input by running the command:
   ```bash
   find . -type f \( -name "*.md" -o -name "*.yaml" -o -name "*.sh" -o -name "*.java" -o -name "*.python" -o -name "*.ts" \) ! -path "*/target/*" -exec sh -c 'head -n 100 "$1"' _ {} \; | head -n 1500
   ```
2. Use the content from the bash command to build an understanding of what this software component does.
3. Update the `component_type` fields in the service-info.yaml file. For the `component_type` field, you should choose one of the following values:
    - `service` A regular backend service, typically serving a request/response flow or consuming pub/sub events.
    - `scheduled-task` Recurring, scheduled job such as a k8s CronJob.
    - `storage` Unmanaged databases, caches and other storage deployments such as Elasticsearch.
    - `third-party` A component that packages/deploys a third party software.
    - `provisioning` A component that provisions things, e.g. terraform repositories and such.
    - `configuration` A component only containing of configuration.
3. When you have updated the service-info.yaml file, you must validate the syntax of the yaml file
   by using running `yq file.yaml >/dev/null`. The tool will output error if the syntax is invalid.
   Otherwise, it will output nothing. If the syntax is invalid, you should fix it before finishing.

## Pointers
- You may ONLY change the field `component_type` in the service-info.yaml file. You MUST not change anything else.
- Do NOT edit or remove any comments.
- You may update the `component_type` field to any of the values listed above.

## Validation
You must validate your changes before terminating. To validate run:

```bash
git diff --numstat
```

This command should return:
```
1       1       service-info.yaml
```

If it does not you must ´git reset --hard´ and restart the task.
