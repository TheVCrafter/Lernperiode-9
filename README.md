# Lernperiode-9
**20.02.2026 - 27.03.2026**

## Project Overview
In this learning period, I aim to build a **web-based Minecraft PvP Guide**.  
For the tech stack, I chose:

- **Backend:** Kotlin with the Ktor framework (providing a RESTful API)  
- **Frontend:** JavaScript with React  

The website should eventually provide:

- PvP guides for different combat styles  
- Interactive tools like CPS tests and aim trainers  
- Possibly user accounts and progress tracking  
- **An appealing, user-friendly design that is visually engaging but not overcomplicated**

---

## 20.02.2026 - Exploring Ktor & React

**Goals**

- [ ] Work through the official Ktor REST API tutorial ([link](https://ktor.io/docs/server-create-restful-apis.html#prerequisit))  
- [ ] Understand how to set up a minimal Ktor backend for a RESTful API  
- [ ] Learn basic routing and JSON responses in Ktor  
- [ ] Set up a basic React project and learn how components and state work ([React Official Tutorial](https://react.dev/learn))  
- [ ] Connect the React frontend to Ktor REST API via a simple GET request  

**Report**

Today I worked on the backend for my *Minecraft PvP Guide* project using Ktor. I am currently following the official Ktor REST API tutorial and have reached the chapter on *Content Negotiation*.

I started with a project generated via the Ktor Project Generator (https://start.ktor.io), which provided the basic project structure, including files such as `Application.kt` and a default test file. This allowed me to focus directly on understanding the framework instead of setting up the project from scratch.

At the beginning, I encountered several Gradle build issues. The main error message was:

```
Unable to load class 'org.gradle.util.VersionNumber'
```

Resolving this problem took a significant amount of time. After some research, I discovered that the issue was caused by a Gradle version mismatch. I was able to fix it by downgrading Gradle to version 8.11.

Unfortunately, due to the time spent troubleshooting the build configuration, I was not able to make substantial progress in the tutorial beyond resolving the setup issues.

---

## 27.02.2026 - Completing the Ktor Backend Tutorial

**Goals**

- [X] Finish the official Ktor REST API tutorial completely  
- [X] Understand routing and JSON responses in Ktor and test endpoints  
- [X] Plan the backend structure for the Minecraft PvP Guide project (data models, routes, and endpoints)  
- [ ] Start coding the planned backend structure by creating the first endpoints and data classes  

**Report**
Today I finished the official Ktor REST API tutorial. The code was mostly provided, so my main focus was understanding how everything works together rather than writing it from scratch.

I reviewed the routing setup, the repository pattern, and the implementation of GET, POST, and DELETE endpoints. A key part was understanding how the Content Negotiation plugin handles JSON serialization and how request bodies are deserialized using `call.receive<T>()`.

While working through the testing section, I ran into several issues, especially with missing dependencies and configuration problems. At one point, the ContentNegotiation plugin was installed twice, which caused a `DuplicatePluginException`. Debugging these errors helped me better understand how Ktor loads modules and plugins internally.

I also looked at automated tests using `testApplication` and JsonPath to understand how API responses and JSON structure can be verified.

Besides the tutorial, I continued planning the backend structure for my Minecraft PvP Guide project. The UML diagram is not fully finished yet and still lacks relations, but I was already able to define some of the main entities such as `Kit`, `Server`, and `Mechanic`.

---

## 06.03.2026 - Finalizing Backend Planning

**Goals**

- [X] Finish the UML class diagram for the backend  
- [X] Define associations, compositions, and multiplicities between the main entities  
- [X] Finalize the backend architecture planning document  
- [ ] Start implementing the first backend endpoints based on the planned API  

**Report**

Today I focused on finishing the planning phase for the backend of the PvP Guide.

I completed the UML class diagram and defined the relationships between the main entities such as `Server`, `Kit`, `KitVariant`, `Mechanic`, `Technique`, and `Drill`. While working on the diagram, I also added the correct UML relation types like aggregation and composition as well as multiplicities where they make sense. This helped clarify how the different parts of the system depend on each other.

In addition to the diagram, I finalized the backend planning document. It now contains the overall API structure, planned endpoints, and the responsibilities of each entity in the system. The backend will mainly act as a REST API that provides structured PvP guide content to the frontend.

The API design now includes endpoints for servers, kits, kit variants, mechanics, techniques, drills, matchups, tags, and search functionality. I also defined several constraints, such as unique slugs and consistency rules for version groups.

With the architecture mostly defined, the next step will be to start implementing the actual backend structure in Ktor based on the planned data model and API routes.

---

## 20.03.2026 - Starting the Backend Implementation

**Goals**

- [X] Start implementing the planned backend structure in Ktor  
- [X] Organize the backend into a cleaner project structure with plugins, configuration, and feature folders  
- [X] Implement the first main backend features such as servers, kits, kit variants, mechanics, techniques, drills, and tags  
- [X] Improve the backend setup with seed data, error handling, and updated Swagger documentation  

**Report**

Today I moved from planning the backend to actually implementing it in Ktor.

At first, I focused on the project structure. I separated the Ktor setup into plugin files such as `HTTP.kt`, `Routing.kt`, `Serialization.kt`, `Swagger.kt`, and `StatusPages.kt`, while the actual backend logic was organized into feature folders. I also added an `AppConfig` class together with an `application.conf` file so that the project configuration is cleaner and easier to manage.

After that, I started implementing the actual backend features. I worked on the core parts of the API such as `Server`, `Kit`, and `KitVariant`, and then also added the first learning-related features like `Mechanic`, `Technique`, `Drill`, and `Tag`. For these, I created the corresponding data classes, repositories, routes, and seed data.

I also improved the content of the seed data. Instead of using only placeholder values, I expanded the server and kit data and tried to make it fit better with real Minecraft PvP categories. This makes the backend more useful already, even before the frontend is connected to it.

Finally, I improved the technical setup of the project. I added centralized error handling with `StatusPages` and updated the Swagger/OpenAPI documentation so that the implemented endpoints are documented properly.

Overall, today was an important step because the project is no longer only planned on paper. The backend now has a real structure and already contains the first implemented features of the PvP Guide.
