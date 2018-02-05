**Microservices Orchestration Design Patterns**

**Version 1.0**



















**                                                                                      Created by: Vivek Katoch**
                                                                                





# 1. **Gateway Aggregation Pattern:**

Use a gateway to aggregate multiple individual requests into a single request. This pattern is useful when a client must make multiple calls to different backend systems to perform an operation. To perform a single task, a client may have to make multiple calls to various backend services. An application that relies on many services to perform a task must expend resources on each request. When any new feature or service is added to the application, additional requests are needed, further increasing resource requirements and network calls. This chattiness between a client and a backend can adversely impact the performance and scale of the application. Microservice architectures have made this problem more common, as applications built around many smaller services naturally have a higher amount of cross-service calls.

Variation of aggregator pattern:




**Applicability**

Use this pattern when:

A client needs to communicate with multiple backend services to perform an operation.

The client may use networks with significant latency, such as cellular networks.

This pattern may not be suitable when:

You want to reduce the number of calls between a client and a single service across multiple operations. In that scenario, it may be better to add a batch operation to the service.

The client or application is located near the backend services and latency is not a significant factor.

1.
# 2. **Gateway Routing Pattern:**

When a client needs to consume multiple services, setting up a separate endpoint for each service and having the client manage each endpoint can be challenging. For example, an e-commerce application might provide services such as search, reviews, cart, checkout, and order history. Each service has a different API that the client must interact with, and the client must know about each endpoint in order to connect to the services. If an API changes, the client must be updated as well. If you refactor a service into two or more separate services, the code must change in both the service and the client.



**Applicability**

Use this pattern when:

A client needs to consume multiple services that can be accessed behind a gateway. You wish to simplify client applications by using a single endpoint. You need to route requests from externally addressable endpoints to internal virtual endpoints, such as exposing ports on a VM to cluster virtual IP addresses. This pattern may not be suitable when you have a simple application that uses only one or two services.


# 3. **Gateway Offloading pattern**

Some features are commonly used across multiple services, and these features require configuration, management, and maintenance. A shared or specialized service that is distributed with every application deployment increases the administrative overhead and increases the likelihood of deployment error. Any updates to a shared feature must be deployed across all services that share that feature.

Other common services such SSL termination, to the API gateway, configuration of all micro services with separate configuration sever shared across services.

 


**Applicability**

Use this pattern when:

An application deployment has a shared concern such as SSL certificates or encryption. A feature that is common across application deployments that may have different resource requirements, such as memory resources, storage capacity or network connections. You wish to move the responsibility for issues such as network security, throttling, or other network boundary concerns to a more specialized team.

This pattern may not be suitable if it introduces coupling across services. ** **


# 4. **Bulk head pattern – Hystrix Isolation**

A cloud-based application may include multiple services, with each service having one or more consumers. Excessive load or failure in a service will impact all consumers of the service.

Moreover, a consumer may send requests to multiple services simultaneously, using resources for each request. When the consumer sends a request to a service that is misconfigured or not responding, the resources used by the client&#39;s request may not be freed in a timely manner. As requests to the service continue, those resources may be exhausted. For example, the client&#39;s connection pool may be exhausted. At that point, requests by the consumer to other services are impacted. Eventually the consumer can no longer send requests to other services, not just the original unresponsive service.

The same issue of resource exhaustion affects services with multiple consumers. A large number of requests originating from one client may exhaust available resources in the service. Other consumers are no longer able to consume the service, causing a cascading failure effect.









**Applicability**

Use this pattern to:

Isolate resources used to consume a set of backend services, especially if the application can provide some level of functionality even when one of the services is not responding. Isolate critical consumers from standard consumers. Protect the application from cascading failures.



# 5. **Circuit breaker pattern**
An application that communicates with elements running in the cloud has to be sensitive to the transient faults that can occur in this environment. Faults include the momentary loss of network connectivity to components and services, the temporary unavailability of a service, or timeouts that occur when a service is busy.

These faults are typically self-correcting, and if the action that triggered a fault is repeated after a suitable delay it&#39;s likely to be successful. For example, a database service that&#39;s processing a large number of concurrent requests can implement a throttling strategy that temporarily rejects any further requests until its workload has eased. An application trying to access the database might fail to connect, but if it tries again after a delay it might succeed.



 
**Applicability**

Use this pattern when an application could experience transient faults as it interacts with a remote service or accesses a remote resource. These faults are expected to be short lived, and repeating a request that has previously failed could succeed on a subsequent attempt.

This pattern might not be useful:

When a fault is likely to be long lasting, because this can affect the responsiveness of an application. The application might be wasting time and resources trying to repeat a request that&#39;s likely to fail.

For handling failures that aren&#39;t due to transient faults, such as internal exceptions caused by errors in the business logic of an application. As an alternative to addressing scalability issues in a system. If an application experiences frequent busy faults, it&#39;s often a sign that the service or resource being accessed should be scaled up.


# 6. **Health Check API Pattern**


You have applied the Microservice architecture pattern. Sometimes a service instance can be incapable of handling requests yet still be running. For example, it might have ran out of database connections. When this occurs, the monitoring system should generate a alert. Also, the load balancer or service registry should not route requests to the failed service instance.How to detect that a running service instance is unable to handle requests?

 

**Applicability**

Use this pattern when an application could experience transient faults as it interacts with a remote service or accesses a remote resource. These faults are expected to be short lived, and repeating a request that has previously failed could succeed on a subsequent attempt.

This pattern might not be useful:

When a fault is likely to be long lasting, because this can affect the responsiveness of an application. The application might be wasting time and resources trying to repeat a request that&#39;s likely to fail.

For handling failures that aren&#39;t due to transient faults, such as internal exceptions caused by errors in the business logic of an application. As an alternative to addressing scalability issues in a system. If an application experiences frequent busy faults, it&#39;s often a sign that the service or resource being accessed should be scaled up.




# 7. (CQRS)Command query and responsibility segregation &amp; Eventuate pattern**

In traditional data management systems, both commands (updates to the data) and queries (requests for data) are executed against the same set of entities in a single data repository. These entities can be a subset of the rows in one or more tables in a relational database such as SQL Server.

Split the application into two parts: the command-side and the query-side. The command-side handles create, update, and delete requests and emits events when data changes. The query-side handles query by executing them against one or more materialized views that are kept up to date by subscribing to the stream of events emitted when data changes.

 

**Applicability**

Use this pattern in the following situations:

Collaborative domains where multiple operations are performed in parallel on the same data. CQRS allows you to define commands with enough granularity to minimize merge conflicts at the domain level (any conflicts that do arise can be merged by the command), even when updating what appears to be the same type of data.

Task-based user interfaces where users are guided through a complex process as a series of steps or with complex domain models. Also, useful for teams already familiar with domain-driven design (DDD) techniques. The write model has a full command-processing stack with business logic, input validation, and business validation to ensure that everything is always consistent for each of the aggregates (each cluster of associated objects treated as a unit for data changes) in the write model. The read model has no business logic or validation stack and just returns a DTO for use in a view model. The read model is eventually consistent with the write model.

Scenarios where performance of data reads must be fine-tuned separately from performance of data writes, especially when the read/write ratio is very high, and when horizontal scaling is required. For example, in many systems the number of read operations is many times greater that the number of write operations. To accommodate this, consider scaling out the read model, but running the write model on only one or a few instances. A small number of write model instances also helps to minimize the occurrence of merge conflicts.

Scenarios where one team of developers can focus on the complex domain model that is part of the write model, and another team can focus on the read model and the user interfaces.

Scenarios where the system is expected to evolve over time and might contain multiple versions of the model, or where business rules change regularly.

Integration with other systems, especially in combination with event sourcing, where the temporal failure of one subsystem shouldn&#39;t affect the availability of the others.
