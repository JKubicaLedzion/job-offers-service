### Users and Job Offers services POC.

- Separate service was created for users and job offers due to scalability. Assumption - services are a backend side of
  job offers portal so job offers service (mostly reading offers) will be exposed to bigger work loads than users
  service. 

- There are comments in the code indicating what should be finished / what additional functionalities should be
  implemented.
  
- Deployment - Docker file to be added, services to be deployed on Kubernetes.


