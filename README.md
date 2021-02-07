# Github actions deployment pipeline with manual triggers for environments!
This example shows how to create github actions deployment pipeline for building Java projects.

# Important info
- The most important part is under `.github/workflows` folder. All steps should be self-explanatory.
- Please note that deployment pipeline with manual triggers for environments are restricted to open-source and enterprise accounts. Up to date info is here: [https://docs.github.com/en/actions/reference/environments](https://docs.github.com/en/actions/reference/environments)
- All builds include caching of gradle downloaded libraries! So your build will be even faster!
- Deployment pipeline SECRETS:
  * DOCKER_REGISTRY_USERNAME - Username of your docker registry.
  * DOCKER_REGISTRY_TOKEN - token generated via docker registry provider. If you are using `hub.docker.com`, go to [https://hub.docker.com/settings/security](https://hub.docker.com/settings/security)  
- Environment SECRETS. Each environment allows configuring env specific secrets. This allows to distinct configuration from environments.
  * KUBERNETES_CONFIG - This secret contains your `base64 kubeconfig.yaml` encoded secret. Go to repository Settings -> Environments -> [Required Environment] -> Environment secrets.
  * NAMESPACE - This secret contains namespace where application will be deployed.
- Please note, that this example was made, thinking that you will use private docker registry instance. 
  * Due to this reason `deployment-template.yaml` contains `imagePullSecrets` variable, which points to secret in kuberntes cluster to access images. If you are using public images this part is not required.
  * `deployment-pipeline.yml` contains `Login to Docker Hub` steps, but you don't need it if you are using public images
  
# Things to consider
- Deployment steps to test/stage/prod are identical, currently Gihub actions does not have mechanism to reuse steps...