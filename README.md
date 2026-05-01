# GraphQL BFF
## 1] Overview
> Graphql BFF(Backend For Frontend)는 클라이언트 요청을 단일 진입점으로 받아
> 여러 도메인 서비스를 조합하여 응답을 구성하는 API Gateway 역할을 수행하니다.  
- Client -> GraphQL -> BFF -> gRPC -> Domain Servcies  
- Aggregation 및 Orchestration 담당합니다.  
- 비즈니스 로직은 서비스 레이어에 위임합니다.  

## 2] Responsibilities  
- GraphQL API를 제공합니다.  
- 여러 서비스 호출 및 데이터를 조합합니다.  
- 요청 흐름을 제어합니다.  
- 클라이언트 요구사항에 맞는 응답을 구성합니다.  

## 3] Request Flow  
**Example: 게시글 조회**  
1. Client -> GraphQL Query 요청  
2. Query Resolver -> UseCase 호출  
3. UseCase -> Post-Service(gRPC)
[생략(의도적 설계): 필요 시 user-service 호출]  
4. 결과를 조합하여 반환

## 4] Tech Stack
- 언어: Java
- 프레임워크: Spring Boot
- API: GraphQL
- 통신: gRPC
