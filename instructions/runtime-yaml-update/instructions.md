# Update the Runtime kubernetes resource

You must actually perform these tasks. Do not give me a list of instructions or a plan, do the work yourself.

Some background. There is a yaml based on a CRD we have created that has the `kind: Runtime`. Here is an example:

```
apiVersion: runtime.spotify.com/v1alpha1
kind: Runtime
metadata:
  namespace: some-gcp-project
  name: some-workload-namespace
spec:
  owners:
    - sample-squad@iam.spotify.com
  roles:
    - somerole
    - someotherrole 
  resourceQuota:
    hard:
      requests.cpu: "600"
      requests.memory: 500Gi
      limits.cpu: "700"
      limits.memory: 500Gi
```
Only perform these actions on yaml files, and only on yaml files that have on top level the `kind` key set to `Runtime`, so `kind: Runtime`. If you detect a yaml file of type `kind: Runtime` in the repository, remove any occurence of the `roles` key (and its values) in this file. So the above example would then look like:

```
apiVersion: runtime.spotify.com/v1alpha1
kind: Runtime
metadata:
  namespace: some-gcp-project
  name: some-workload-namespace
spec:
  owners:
    - sample-squad@iam.spotify.com
  resourceQuota:
    hard:
      requests.cpu: "600"
      requests.memory: 500Gi
      limits.cpu: "700"
      limits.memory: 500Gi
```

Next also check the values of the `resourceQuota.hard` key. We have default values for the following subkeys under `resourceQuota.hard`:

```
  resourceQuota:
    hard:
      requests.cpu:    300,
      requests.memory: 500Gi,
      limits.cpu:      400,
      limits.memory:   500Gi,
```

If the values of all 4 of these keys in the file fall below the default values or are equal to them, remove the `resourceQuota` key entirely. So the above example, after removing both the `roles` key and the `resourceQuota` key (if applicable) would look as follows:

```
apiVersion: runtime.spotify.com/v1alpha1
kind: Runtime
metadata:
  namespace: some-gcp-project
  name: some-workload-namespace
spec:
  owners:
    - sample-squad@iam.spotify.com
```

If you do remove the `resourceQuota` add a comment in its place, to tell the user what the default `resourceQuota` is and to not set anything less than that. The comment should read as follows:

```
# The default resourceQuota currently is:
#
#  hard:
#    limits.cpu: "400"
#    limits.memory: 500Gi
#    requests.cpu: "300"
#    requests.memory: 500Gi
#
# It can be found [here](https://ghe.spotify.net/warpspeed/runtime-operator/blob a5175e9640c70b45e566b9b6eb9580de01c51946/api/v1alpha1/runtime_webhook.go#L169-L189). 
#
# Please do not set the resourceQuota here if it falls below these values as it would be obsolete config.

```