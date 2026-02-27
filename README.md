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

- [ ] Finish the official Ktor REST API tutorial completely  
- [ ] Understand routing and JSON responses in Ktor and test endpoints  
- [ ] Plan the backend structure for the Minecraft PvP Guide project (data models, routes, and endpoints)  
- [ ] Start coding the planned backend structure by creating the first endpoints and data classes  

**Report**
