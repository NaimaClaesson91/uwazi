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

If you detect a yaml file of type `kind: Runtime` in the repository, remove any occurence of the `roles` key in this file. So the above example would then look like:

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

If the values of all 4 of these keys in the file fall below the default values, remove the `resourceQuota` key entirely. So the above example, after removing both the `roles` key and the `resourceQuota` key (if applicable) would look as follows:

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