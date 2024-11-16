## how to run postgres via docker
``docker run --name postgres \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=password \
  -p 5432:5432 \
  -d postgres:17-alpine``

## hot to deploy on kubernetes
``kubectl apply -f application-deployment-local.yml``

## how to delete application on kubernetes
``kubectl delete -f application-deployment-local.yml``

## hot to get detail of pod
``kubectl describe pod {the-pod-name}``

## how to get logs for pod
`` kubectl logs order-deployment-5f76d87448-s922h --all-containers``