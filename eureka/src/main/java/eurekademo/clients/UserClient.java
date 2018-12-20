package eurekademo.clients;

import eurekademo.clientOpertaions.UserOperations;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


public interface UserClient extends UserOperations {
}
