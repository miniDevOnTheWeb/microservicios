echo "--- Pushing config-server image... ---"
docker push diexdev/microservices_project-config-server:v1

echo "--- Pushing eureka-server image... ---"
docker push diexdev/microservices_project-eureka-server:v1

echo "--- Pushing gateway-service image... ---"
docker push diexdev/microservices_project-gateway-service:v1

echo "--- Pushing orders-service image... ---"
docker push diexdev/microservices_project-orders-service:v1

echo "--- Pushing products-service image... ---"
docker push diexdev/microservices_project-products-service:v1

echo "--- Pushing users-service image... ---"
docker push diexdev/microservices_project-users-service:v1
