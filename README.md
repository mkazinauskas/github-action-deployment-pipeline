# Github actions deployment pipeline with manual triggers for environments!
This example shows how to create github actions deployment pipeline for building Java projects.

# Important info
- The most important part is under `.github/workflows` folder. All steps should be self-explanatory.
- Please note that deployment pipeline with manual triggers for environments are restricted to open-source and enterprise accounts. Up to date info is here: [https://docs.github.com/en/actions/reference/environments](https://docs.github.com/en/actions/reference/environments)
- All builds include caching of gradle downloaded libraries! So your build will be even faster!
- Deployment pipeline IMPORTANT SECRETS:
  * DOCKER_REGISTRY_USERNAME - Username of your docker registry.
  * DOCKER_REGISTRY_TOKEN - token generated via docker registry provider. If you are using `hub.docker.com`, go to [https://hub.docker.com/settings/security](https://hub.docker.com/settings/security)  
    